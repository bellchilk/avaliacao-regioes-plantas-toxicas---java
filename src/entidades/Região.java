package entidades;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import persistência.BD;

public class Região {
    public enum Uf { MS, SP, AM, GO }
    
    private int sequencial;
    private String ecossistema;
    private Uf uf;
    private int frequencia_acidentes_por_ano;
    private boolean acessível;
    
    public Região(int sequencial, String ecossistema, Uf uf, int frequencia_acidentes_por_ano, boolean acessível) {
        this.sequencial = sequencial;
        this.ecossistema = ecossistema;
        this.uf = uf;
        this.frequencia_acidentes_por_ano = frequencia_acidentes_por_ano;
        this.acessível = acessível;
    }

    public int getSequencial() { return this.sequencial; }
    public void setSequencial(int sequencial) { this.sequencial = sequencial;}
    public String getEcossistema() { return this.ecossistema; }
    public void setEcossistema(String ecossistema) { this.ecossistema = ecossistema;}
    public Uf getUf() { return this.uf; }
    public Integer getFrequenciaAcidentesPorAno() {return this.frequencia_acidentes_por_ano;}
    public boolean isAcessível() {return this.acessível;};
 
    public Região(int sequencial, String ecossistema, Uf uf) {
        this.sequencial = sequencial;
        this.ecossistema = ecossistema;
        this.uf = uf;
    }
    
    public String toString() {
        return "["+sequencial +"] " + ecossistema +" - "+ uf;
    }

    public String toStringFull() {
        String str = uf + " - " + frequencia_acidentes_por_ano + " [" + ecossistema + "]" ;
        if (acessível) str += " - acessível";
        return str;
    }
    
    public Região getVisão() { return new Região(sequencial, ecossistema, uf); }

       public static Região[] getVisões() {
        String sql = "SELECT Sequencial, Ecossistema, Uf FROM Regioes";
        ResultSet lista_resultados = null;
        ArrayList<Região> visões = new ArrayList();

        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            lista_resultados = comando.executeQuery();
            
            while (lista_resultados.next()) {
                int sequencial = lista_resultados.getInt("Sequencial");
                String ecossistema = lista_resultados.getString("Ecossistema");
                Uf uf = Uf.values()[lista_resultados.getInt("Uf")];
                
                visões.add(new Região(sequencial, ecossistema, uf));
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção_sql) { exceção_sql.printStackTrace(); }

        return visões.toArray(new Região[visões.size()]);
    }

    public static int últimoSequencial () {
        String sql = "SELECT MAX(Sequencial) FROM Regioes";
        ResultSet lista_resultados = null;
        int sequencial = 0;
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                sequencial = lista_resultados.getInt (1);
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace ();
        }
        return sequencial;
    }
    
    public static boolean existeRegiãoMesmosAtributos (Região região) {
        String sql = "SELECT COUNT(Sequencial) FROM Regioes"
            + " WHERE Ecossistema = ? AND Uf = ? AND FrequenciaAcidentesPorAno = ? AND Acessivel = ?";
        ResultSet lista_resultados = null;
        int n_regiões_mesmos_atributos = 0;
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1, região.getEcossistema());
            comando.setInt(2, região.getUf().ordinal());
            comando.setInt(3, região.getFrequenciaAcidentesPorAno());
            comando.setBoolean(4, região.isAcessível());
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                n_regiões_mesmos_atributos = lista_resultados.getInt(1);
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção_sql) {exceção_sql.printStackTrace ();}
        if (n_regiões_mesmos_atributos > 0) return true;
        else return false;
    }
    
        public static Região buscarRegião(int sequencial) {
        String sql = "SELECT * FROM Regioes WHERE Sequencial = ?";
        ResultSet lista_resultados = null;
        Região região = null;

        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setInt(1, sequencial);
            lista_resultados = comando.executeQuery();

            while (lista_resultados.next()) {
                região = new Região( sequencial,
                    lista_resultados.getString("Ecossistema"),
                    Uf.values()[lista_resultados.getInt("Uf")],
                    lista_resultados.getInt("FrequenciaAcidentesPorAno"),
                    lista_resultados.getBoolean("Acessivel")
                );
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
            região = null;
        }
        return região;
    }

    public static String inserirRegião(Região região) {
        String sql = "INSERT INTO Regioes (Sequencial, Ecossistema, Uf, FrequenciaAcidentesPorAno, Acessivel) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            
            comando.setInt(1, região.getSequencial());
            comando.setString(2, região.getEcossistema());
            comando.setInt(3, região.getUf().ordinal());
            comando.setInt(4, região.getFrequenciaAcidentesPorAno());
            comando.setBoolean(5, região.isAcessível());

            comando.executeUpdate();
            comando.close();
            
            return null;

        } catch (SQLException exceção_sql) { 
            exceção_sql.printStackTrace(); 
            return "Erro na Inserção da Região no BD"; 
        }
    }
    
        
    public static String alterarRegião(Região região) {
        String sql = "UPDATE Regioes SET Acessivel = ?, FrequenciaAcidentesPorAno = ?, Uf = ? , Ecossistema = ? WHERE Sequencial = ?";
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setBoolean(1, região.isAcessível());
            comando.setInt(2, região.getFrequenciaAcidentesPorAno());
            comando.setInt(3, região.getUf().ordinal());
            comando.setString(4, região.getEcossistema());
            comando.setInt(5, região.getSequencial());
            
            comando.executeUpdate();
            comando.close();
            
            return null;

        } catch (SQLException exceção_sql) { 
            exceção_sql.printStackTrace(); 
            return "Erro na Alteração da Região no BD"; 
        }
    }

    public static String removerRegião(int Sequencial) {
        String sql = "DELETE FROM Regioes WHERE Sequencial = ?";
        
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setInt(1, Sequencial);
            comando.executeUpdate();
            comando.close();
            return null;
            
        } catch (SQLException exceção_sql) { 
            exceção_sql.printStackTrace(); 
            return "Erro na Remoção da Região no BD"; 
        }
        
    }

}
