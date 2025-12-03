
package entidades;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import persistência.BD;

public class VisitaCampo {
    
    private int sequencial;
    private Região região;
    private Planta planta;

    public VisitaCampo(int sequencial, Região região, Planta planta) {
        this.sequencial = sequencial;
        this.região = região;
        this.planta = planta;
    }

    public int getSequencial() { return this.sequencial; }
    public void setSequencial(int sequencial) { this.sequencial = sequencial;}
    public Região getRegião() { return this.região; }
    public Planta getPlanta() { return this.planta; }

    public String toString() {
        return planta.toString();
    }

    public static boolean existeVisitaCampo (int sequencial) {
        String sql = "SELECT COUNT(Sequencial) FROM VisitasCampo WHERE Sequencial = ?";
        ResultSet lista_resultados = null;
        boolean existe = false;
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setInt(1, sequencial);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) existe = true;
            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace ();
        }
        return existe;
    }

    public static boolean existeVisitaCampo (int chave_região, String chave_planta) {
        String sql = "SELECT Sequencial FROM VisitasCampo WHERE RegiaoId = ? AND PlantaId = ?";
        ResultSet lista_resultados = null;
        boolean existe = false;
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setInt(1, chave_região);
            comando.setString(2, chave_planta);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) existe = true;
            lista_resultados.close();
            comando.close();
            
        } catch (SQLException exceção_sql) { exceção_sql.printStackTrace (); }
        return existe;
    }

    public static int últimoSequencial () {
        String sql = "SELECT MAX(Sequencial) FROM VisitasCampo";
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
            } catch (SQLException exceção_sql) {exceção_sql.printStackTrace ();}
            return sequencial;
    }

    public static VisitaCampo[] buscarVisitaCampo (int sequencial_região) {
        String sql = "SELECT Sequencial, PlantaId FROM VisitasCampo WHERE RegiaoId = ?";
        ResultSet lista_resultados = null;
        ArrayList<VisitaCampo> visões = new ArrayList();
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setInt(1, sequencial_região);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                visões.add(new VisitaCampo (lista_resultados.getInt("Sequencial"),
                    Região.buscarRegião(sequencial_região).getVisão(),
                    Planta.buscarPlanta(lista_resultados.getString("PlantaId")).getVisão()));
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção_sql) {exceção_sql.printStackTrace ();}
        return visões.toArray(new VisitaCampo[visões.size()]);
    }
    
    public static Planta[] buscarPlantasRegião(int sequencial_região) {
        String sql = "SELECT Sequencial, PlantaId FROM VisitasCampo WHERE RegiaoId = ?";
        ResultSet lista_resultados = null;
        ArrayList<Planta> visões = new ArrayList();
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setInt(1, sequencial_região);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                visões.add(Planta.buscarPlanta(lista_resultados.getString("PlantaId")));
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
        }
        return visões.toArray(new Planta[visões.size()]);
    }
    
    public static String inserirVisitaCampo(VisitaCampo visita_campo) {
        String sql = "INSERT INTO VisitasCampo (Sequencial, RegiaoId, PlantaId) VALUES (?,?,?)";
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setInt(1, visita_campo.getSequencial());
            comando.setInt(2, visita_campo.getRegião().getSequencial());
            comando.setString(3, visita_campo.getPlanta().getNome());
            comando.executeUpdate();
            comando.close();
            return null;
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace(); 
            return "Erro na Inserção da Visita de Campo no BD"; 
        }
    }
    
    public static String removerVisitaCampo(int Sequencial) {
        String sql = "DELETE FROM VisitasCampo WHERE Sequencial = ?";
        
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setInt(1, Sequencial);
            comando.executeUpdate();
            comando.close();
            return null;
            
        } catch (SQLException exceção_sql) { 
            exceção_sql.printStackTrace(); 
            return "Erro na Remoção da Visita de Campo no BD"; 
        }
        
    }
}
