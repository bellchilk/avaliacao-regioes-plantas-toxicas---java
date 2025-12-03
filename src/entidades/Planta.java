package entidades;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.PlantaMedicinal.ParteUtilizada;
import entidades.PlantaMedicinal.PropriedadeTerapeutica;
import entidades.PlantaTóxica.CompostoTóxico;
import entidades.PlantaTóxica.EfeitoColateral;
import persistência.BD;

public class Planta {
    public enum Origem     {  brasil, chile, japao, oriente_medio, russia }
    public enum Toxicidade { não_tóxica, baixa, moderada, alta }

    private String nome;
    private int altura_maxima_cm;
    private Toxicidade toxicidade;
    private Origem origem;

    public Planta(String nome, int altura_maxima_cm, Toxicidade toxicidade, Origem origem) {
        this.nome = nome;
        this.altura_maxima_cm = altura_maxima_cm;
        this.toxicidade = toxicidade;
        this.origem = origem;
    }
    
    public Planta(String nome, Toxicidade toxicidade) {
        this.nome = nome;
        this.toxicidade = toxicidade;
    }
     
    public String getNome() { return this.nome; }
    public Integer getAlturaMaximaCm() {return this.altura_maxima_cm;}
    public Toxicidade getToxicidade() { return this.toxicidade; }
    public void setToxicidade(Toxicidade toxicidade) {
        this.toxicidade = toxicidade;
    }
    
    public Origem getOrigem() { return this.origem; }
 
    @Override
    public String toString() {
        return nome + " (" + toxicidade + ")";
    }
   
    public String toStringFull() {
        String str = nome + " [" + toxicidade + "] - altura máxima em cm: " + altura_maxima_cm + "  ";
        return str;
    }
    
    public Planta getVisão() { return new Planta(nome, toxicidade); }

    public static Planta[] getVisões() {
        String sql = "SELECT Nome FROM Plantas";
        ResultSet lista_resultados = null;
        ArrayList<Planta> visões = new ArrayList();

        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            lista_resultados = comando.executeQuery();
            
            while (lista_resultados.next()) {
                visões.add(buscarPlanta (lista_resultados.getString("Nome")).getVisão());
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção_sql) { exceção_sql.printStackTrace(); }
        return visões.toArray(new Planta[visões.size()]);
    }
      
    public static Planta buscarPlanta(String nome) {
        String sql = null;
        ResultSet lista_resultados = null;
        sql = "SELECT Nome, AlturaMaximaCm, Toxicidade, Origem FROM Plantas WHERE Nome = ?";
        String nome_planta = null;
        int altura_maxima_cm = 0;
        Toxicidade toxicidade = null;
        Origem origem = null;
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1, nome);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                nome_planta = lista_resultados.getString("Nome");
                altura_maxima_cm = lista_resultados.getInt("AlturaMaximaCm");
                toxicidade = Toxicidade.values()[lista_resultados.getInt("Toxicidade")];
                origem = Origem.values()[lista_resultados.getInt("Origem")];
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção_sql) { exceção_sql.printStackTrace(); }
        if (nome_planta == null) return null;
        sql = "SELECT ParteUtilizada, PropriedadeTerapeutica FROM PlantasMedicinais WHERE PlantaId = ?";
        lista_resultados = null;
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1, nome);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {    
                return new PlantaMedicinal(nome,altura_maxima_cm, toxicidade, origem,
                    ParteUtilizada.values()[lista_resultados.getInt("ParteUtilizada")],
                    PropriedadeTerapeutica.values()[lista_resultados.getInt("PropriedadeTerapeutica")]
                );
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção_sql) { exceção_sql.printStackTrace(); }
        sql = "SELECT CompostoToxico, EfeitoColateral FROM PlantasToxicas WHERE PlantaId = ?";
        lista_resultados = null;
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1, nome);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {    
                return new PlantaTóxica(nome, altura_maxima_cm, toxicidade, origem,
                    CompostoTóxico.values()[lista_resultados.getInt("CompostoToxico")],
                    EfeitoColateral.values()[lista_resultados.getInt("EfeitoColateral")]
                );
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção_sql) { exceção_sql.printStackTrace(); }
        return null;
    }

    public static String inserirPlanta(Planta planta) {
        String sql = "INSERT INTO Plantas (Nome, AlturaMaximaCm, Toxicidade, Origem) VALUES (?,?,?,?)";
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);

            comando.setString(1, planta.getNome());
            comando.setInt(2,planta.getAlturaMaximaCm());
            comando.setInt(3, planta.getToxicidade().ordinal());
            comando.setInt(4, planta.getOrigem().ordinal());

            comando.executeUpdate();
            comando.close();
            
        } catch (SQLException exceção_sql) { 
            exceção_sql.printStackTrace(); 
            return "Erro na Inserção da Planta no BD"; 
        }
        String nome = planta.getNome(); 
        if (planta instanceof PlantaMedicinal){
            PlantaMedicinal planta_medicinal = (PlantaMedicinal) planta;
            sql = "INSERT INTO PlantasMedicinais (ParteUtilizada, PropriedadeTerapeutica, PlantaId) VALUES (?,?,?)";
            try {
                PreparedStatement comando = BD.conexão.prepareStatement(sql);
                comando.setInt(1, planta_medicinal.getParteUtilizada().ordinal());
                comando.setInt(2, planta_medicinal.getPropriedadeTerapeutica().ordinal());
                comando.setString(3, nome);
                comando.executeUpdate();
                comando.close();
            } catch (SQLException exceção_sql) {
                exceção_sql.printStackTrace();
                return "Erro na Inserção do PlantaMedicinal no BD";
            }
        } else if (planta instanceof PlantaTóxica) {
            PlantaTóxica planta_tóxica = (PlantaTóxica) planta;
            sql = "INSERT INTO PlantasToxicas (CompostoToxico, EfeitoColateral, PlantaId) VALUES (?,?,?)";
            try {
                PreparedStatement comando = BD.conexão.prepareStatement(sql);
                comando.setInt(1, planta_tóxica.getCompostoTóxico().ordinal());
                comando.setInt(2, planta_tóxica.getEfeitoColateral().ordinal());
                comando.setString(3, nome);
                comando.executeUpdate();
                comando.close();
            } catch (SQLException exceção_sql) {
                exceção_sql.printStackTrace();
                return "Erro na Inserção do PlantaTóxica no BD";

            }
            
        }
        return null;
    }

    public static String alterarPlanta(Planta planta) {
        String sql = "UPDATE Plantas SET AlturaMaximaCm = ?, Toxicidade = ?, " + 
                "Origem = ? WHERE Nome = ?";
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            
            comando.setInt(1, planta.getAlturaMaximaCm());
            comando.setInt(2, planta.getToxicidade().ordinal());
            comando.setInt(3, planta.getOrigem().ordinal());
            comando.setString(4, planta.getNome());
            
            comando.executeUpdate();
            comando.close();
            
        } catch (SQLException exceção_sql) { 
            exceção_sql.printStackTrace(); 
            return "Erro na Alteração da Planta no BD"; 
        }
        if(planta instanceof PlantaMedicinal){
            PlantaMedicinal planta_medicinal = (PlantaMedicinal) planta;
            sql = "UPDATE PlantasMedicinais SET ParteUtilizada = ?, PropriedadeTerapeutica = ? " + 
                "WHERE PlantaId = ?";
            try {
                PreparedStatement comando = BD.conexão.prepareStatement(sql);
                
                comando.setInt(1, planta_medicinal.getParteUtilizada().ordinal());
                comando.setInt(2, planta_medicinal.getPropriedadeTerapeutica().ordinal());
                comando.setString(3, planta.getNome());
                
                comando.executeUpdate();
                comando.close();
                
            } catch (SQLException exceção_sql) { 
                exceção_sql.printStackTrace(); 
                return "Erro na Alteração do PlantaMedicinal no BD"; 
            }
        } else if (planta instanceof PlantaTóxica) {
            PlantaTóxica planta_tóxica = (PlantaTóxica) planta;
            sql = "UPDATE PlantasToxicas SET CompostoToxico = ?, EfeitoColateral = ? " + 
                "WHERE PlantaId = ?";
            try {
                PreparedStatement comando = BD.conexão.prepareStatement(sql);
                
                comando.setInt(1, planta_tóxica.getCompostoTóxico().ordinal());
                comando.setInt(2, planta_tóxica.getEfeitoColateral().ordinal());
                comando.setString(3, planta.getNome());
                
                comando.executeUpdate();
                comando.close();
                
            } catch (SQLException exceção_sql) { 
                exceção_sql.printStackTrace(); 
                return "Erro na Alteração do PlantaTóxica no BD";

            }
        }
        return null;
    }

    public static String removerPlanta(Planta planta){
        String nome = planta.getNome();
        if (planta instanceof PlantaMedicinal){
            String sql = "DELETE FROM PlantasMedicinais WHERE PlantaId = ?";
            try {
                PreparedStatement comando = BD.conexão.prepareStatement(sql);
                comando.setString(1, nome);
                comando.executeUpdate();
                comando.close();
                
            } catch (SQLException exceção_sql) { 
                exceção_sql.printStackTrace(); 
                return "Erro na Remoção do PlantaMedicinal no BD"; 
            }
        }else if (planta instanceof PlantaTóxica) {
            String sql = "DELETE FROM PlantasToxicas WHERE PlantaId = ?";
            try {
                PreparedStatement comando = BD.conexão.prepareStatement(sql);
                comando.setString(1, nome);
                comando.executeUpdate();
                comando.close();
                
            } catch (SQLException exceção_sql) { 
                exceção_sql.printStackTrace(); 
                return "Erro na Remoção do PlantaTóxica no BD"; 
            }
        }
        String sql = "DELETE FROM Plantas WHERE Nome = ?";
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1, nome);
            comando.executeUpdate();
            comando.close();
            
        } catch (SQLException exceção_sql) { 
            exceção_sql.printStackTrace(); 
            return "Erro na Remoção da Planta no BD"; 
        }
        return null;
    }

}
