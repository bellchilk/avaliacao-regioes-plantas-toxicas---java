package entidades;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import persistência.BD;

public class Botânico {
    public enum Especialidade { taxonomia_vegetal, fisiologia_vegetal, botânica_econômica }
    public enum Titulação    { graduação, especialização, mestrado, doutorado }

    private String nome;
    private int anos_experiência;
    private Especialidade especialidade;
    private Titulação titulação;

    public Botânico(String nome, int anos_experiência,
                    Especialidade especialidade, Titulação titulação) {
        this.nome = nome;
        this.anos_experiência = anos_experiência;
        this.especialidade = especialidade;
        this.titulação = titulação;
    }

    public String getNome() { return nome; }
    public Integer getAnosExperiencia() { return anos_experiência; }
    public Especialidade getEspecialidade() { return especialidade; }
    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }
    public Titulação getTitulação() { return titulação; }
    
    public Botânico(String nome, Especialidade especialidade) {
        this.nome = nome;
        this.especialidade = especialidade;
    }
    
    public String toString() {
        return nome + " (" + especialidade + ")";
    }
   
    public String toStringFull() {
        String str = nome;
        if (nome != null) {
            str += " [ " + especialidade + " ] ";
        }
        str += " - " + titulação;
        return str;
    }
    
    public Botânico getVisão() { return new Botânico(nome, especialidade); }

       public static Botânico[] getVisões() {
        String sql = "SELECT Nome, Especialidade FROM Botanicos";
        ResultSet lista_resultados = null;
        ArrayList<Botânico> visões = new ArrayList();

        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            lista_resultados = comando.executeQuery();
            
            while (lista_resultados.next()) {
                String nome = lista_resultados.getString("Nome");
                Especialidade especialidade = Especialidade.values()[lista_resultados.getInt("Especialidade")];
                
                visões.add(new Botânico(nome, especialidade));
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção_sql) { exceção_sql.printStackTrace(); }

        return visões.toArray(new Botânico[visões.size()]);
    }
       
    public static Botânico buscarBotânico(String nome) {
        String sql = "SELECT * FROM Botanicos WHERE Nome = ?";
        ResultSet lista_resultados = null;
        Botânico botânico = null;
    
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1, nome);
            lista_resultados = comando.executeQuery();

            while (lista_resultados.next()) {
                botânico = new Botânico(
                    nome,
                    lista_resultados.getInt("AnosExperiencia"),
                    Especialidade.values()[lista_resultados.getInt("Especialidade")],
                    Titulação.values()[lista_resultados.getInt("Titulacao")]
                );
            }
            lista_resultados.close();
            comando.close(); 
        } catch (SQLException exceção_sql) { 
            exceção_sql.printStackTrace(); 
            botânico = null;
        }
        return botânico;
}

    public static String inserirBotânico(Botânico botanico) {
        String sql = "INSERT INTO Botanicos (Nome, AnosExperiencia, Especialidade, Titulacao) VALUES (?,?,?,?)";
        
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1, botanico.getNome());
            comando.setInt(2, botanico.getAnosExperiencia());
            comando.setInt(3, botanico.getEspecialidade().ordinal());
            comando.setInt(4, botanico.getTitulação().ordinal());
            
            comando.executeUpdate();
            comando.close();
            return null;
        } catch (SQLException exceção_sql) { 
            exceção_sql.printStackTrace(); 
            return "Erro na Inserção do Botânico no BD"; }
    }

    public static String alterarBotânico(Botânico botanico) {
        String sql = "UPDATE Botanicos SET Titulacao=?,"
                + "Especialidade=?, AnosExperiencia=? WHERE Nome=?";
        
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            
            comando.setInt(1, botanico.getTitulação().ordinal());
            comando.setInt(2, botanico.getEspecialidade().ordinal());
            comando.setInt(3, botanico.getAnosExperiencia());
            comando.setString(4, botanico.getNome());
            
            comando.executeUpdate();
            comando.close();
            
            return null;
            
        } catch (SQLException exceção_sql) { 
            exceção_sql.printStackTrace(); 
            return "Erro na Alteração do Botânico no BD"; 
        }
    }

    public static String removerBotânico(String nome) {
        String sql = "DELETE FROM Botanicos WHERE Nome=?";
        
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1, nome);
            comando.executeUpdate();
            comando.close();
            return null;
            
        } catch (SQLException exceção_sql) { 
            exceção_sql.printStackTrace(); 
            return "Erro na Remoção do Botânico no BD"; 
        }
    }

}
