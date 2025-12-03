package entidades;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Botânico.Especialidade;
import entidades.Planta.Origem;
import entidades.PlantaMedicinal.ParteUtilizada;
import entidades.PlantaTóxica.CompostoTóxico;
import persistência.BD;

public class AvaliaçãoToxicidade {
    
    private int sequencial;
    private Botânico botânico;
    private Região região;
    private int n_plantas_alta_toxicidade;
    private int n_plantas_baixa_toxicidade;
    
    public AvaliaçãoToxicidade(int sequencial, Botânico botânico, Região região, int n_plantas_alta_toxicidade, int n_plantas_baixa_toxicidade) {
        this.sequencial = sequencial;
        this.botânico = botânico;
        this.região = região;
        this.n_plantas_alta_toxicidade = n_plantas_alta_toxicidade;
        this.n_plantas_baixa_toxicidade = n_plantas_baixa_toxicidade;
    }

    
    public AvaliaçãoToxicidade(int sequencial, Botânico botânico, Região região , int n_plantas_alta_toxicidade) {
        this.sequencial = sequencial;
        this.botânico = botânico;
        this.região = região;
        this.n_plantas_alta_toxicidade= n_plantas_alta_toxicidade;
    }

    public Integer getSequencial() { return sequencial; }
    public Botânico getBotânico() { return botânico; }
    public Região getRegião() { return região; }
    public Integer getN_plantas_alta_toxicidade() { return n_plantas_alta_toxicidade; }
    public Integer getN_plantas_baixa_toxicidade() { return n_plantas_baixa_toxicidade; }
    public void setSequencial(int sequencial) {
        this.sequencial = sequencial;
    }

     @Override
    public String toString() {
        return "[" + sequencial + "] - " + região + " - " + botânico + ": " + n_plantas_alta_toxicidade;
    }
    
    public String toStringFull() {
        String str = "\n " + botânico.toStringFull() + " --- " + região.toStringFull() + "\n ";
        Planta[] plantas_região = VisitaCampo.buscarPlantasRegião(região.getSequencial());
        for (Planta planta : plantas_região) {
            str += " --\n" +  planta.toStringFull();
        }
        str += "Número de Plantas com Alta Toxicidade [" + n_plantas_alta_toxicidade + "] - Número de Plantas com Baixa Toxicidade [" + n_plantas_baixa_toxicidade + "]";
        return str;
    }
    
    public AvaliaçãoToxicidade getVisão() {
        return new AvaliaçãoToxicidade(sequencial, botânico, região, n_plantas_alta_toxicidade);
    }

    public static AvaliaçãoToxicidade[] getVisões () {
        String sql = "SELECT Sequencial, BotanicoId, RegiaoId, N_plantas_alta_toxicidade FROM AvaliacoesToxicidade";
        ResultSet lista_resultados = null;
        ArrayList<AvaliaçãoToxicidade> visões = new ArrayList();
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                visões.add(new AvaliaçãoToxicidade(
                    lista_resultados.getInt("Sequencial"),
                    Botânico.buscarBotânico(lista_resultados.getString("BotanicoId")).getVisão(),
                    Região.buscarRegião(lista_resultados.getInt("RegiaoId")).getVisão(),
                    lista_resultados.getInt("N_plantas_alta_toxicidade")
                ));
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção_sql) {exceção_sql.printStackTrace ();}
        return visões.toArray(new AvaliaçãoToxicidade[visões.size()]);
    }
    

    public static int últimoSequencial () {
        String sql = "SELECT MAX(Sequencial) FROM AvaliacoesToxicidade";
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
    
   
    public static boolean existeAvaliaçãoToxicidade(String chave_botânico, int chave_região) {
        String sql = "SELECT Sequencial FROM AvaliacoesToxicidade WHERE BotanicoId = ? AND RegiaoId = ?";
        ResultSet lista_resultados = null;
        boolean existe = false;
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1, chave_botânico);
            comando.setInt(2, chave_região);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                existe = true;
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
        }
        return existe;
    }
    
    public static boolean existeAvaliaçãoToxicidade(int sequencial) {
        String sql = "SELECT COUNT(Sequencial) FROM AvaliacoesToxicidade WHERE Sequencial = ?";
        ResultSet lista_resultados = null;
        boolean existe = false;
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setInt(1, sequencial);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                existe = true;
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
        }
        return existe;
    }

    public static String inserirAvaliaçãoToxicidade(AvaliaçãoToxicidade avaliação_toxicidade) {
        String sql = "INSERT INTO AvaliacoesToxicidade (BotanicoId, RegiaoId, N_plantas_alta_toxicidade, N_plantas_baixa_toxicidade)"
                + " VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1, avaliação_toxicidade.getBotânico().getNome());
            comando.setInt(2, avaliação_toxicidade.getRegião().getSequencial());
            comando.setInt(3, avaliação_toxicidade.getN_plantas_alta_toxicidade());
            comando.setInt(4, avaliação_toxicidade.getN_plantas_baixa_toxicidade());
            comando.executeUpdate();
            
            comando.close();
            return null;
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
            return "Erro na Inserção da Avaliação no BD";
        }
    }
    
    public static String alterarAvaliaçãoToxicidade(AvaliaçãoToxicidade avaliação_toxicidade) {
        String sql = "UPDATE AvaliacoesToxicidade SET  N_plantas_baixa_toxicidade= ?, N_plantas_alta_toxicidade = ? WHERE Sequencial = ?";
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setInt(1, avaliação_toxicidade.getN_plantas_baixa_toxicidade());
            comando.setInt(2, avaliação_toxicidade.getN_plantas_alta_toxicidade());
            comando.setInt(3, avaliação_toxicidade.getSequencial());
            comando.executeUpdate();
            comando.close();
            return null;
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
            return "Erro na Alteração da Avaliação de Toxicidade no BD";
        }
    }
    
    public static AvaliaçãoToxicidade buscarAvaliaçãoToxicidade(int sequencial) {
        String sql = "SELECT * FROM AvaliacoesToxicidade WHERE Sequencial = ?";
        ResultSet lista_resultados = null;
        AvaliaçãoToxicidade avaliação_toxicidade = null;
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setInt(1, sequencial);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                avaliação_toxicidade = new AvaliaçãoToxicidade(
                    sequencial,
                    Botânico.buscarBotânico(lista_resultados.getString("BotanicoId")),
                    Região.buscarRegião(lista_resultados.getInt("RegiaoId")),
                    lista_resultados.getInt("N_plantas_alta_toxicidade"),
                    lista_resultados.getInt("N_plantas_baixa_toxicidade"));
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
            avaliação_toxicidade = null;
        }
        return avaliação_toxicidade;
    }

    
    public static String removerAvaliaçãoToxicidade(int Sequencial) {
        String sql = "DELETE FROM AvaliacoesToxicidade WHERE Sequencial = ?";
        
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setInt(1, Sequencial);
            comando.executeUpdate();
            comando.close();
            return null;
            
        } catch (SQLException exceção_sql) { 
            exceção_sql.printStackTrace(); 
            return "Erro na Remoção da Avaliação de Toxicidade no BD"; 
        }
        
    }
    
    private static boolean plantasRegiãoAtendemFiltros(int sequencial_região, Origem origem_planta,
        ParteUtilizada parte_utilizada, CompostoTóxico composto_tóxico, boolean todas_plantas_região) {

        Planta[] plantas_região = VisitaCampo.buscarPlantasRegião(sequencial_região);
        int total_plantas_não_atendem_filtros = 0;

         for (Planta planta : plantas_região) {
            String nome_planta = planta.getNome();

            if (((origem_planta != null) && (planta.getOrigem() != origem_planta))
                    || (!isOkPesquisaEmPlantaMedicinal(nome_planta, parte_utilizada) && (parte_utilizada != null))
                    || (!isOkPesquisaEmPlantaTóxica(nome_planta, composto_tóxico) && (composto_tóxico != null))) {

                total_plantas_não_atendem_filtros++;
                if (todas_plantas_região) return false;
            }
        }

        if (total_plantas_não_atendem_filtros == 0) return true;
        if (todas_plantas_região || (total_plantas_não_atendem_filtros == plantas_região.length)) return false;

        return true;
    }



    private static boolean isOkPesquisaEmPlantaMedicinal(String nome, ParteUtilizada parte_utilizada) {
        boolean pesquisa_ok = false;
        String sql = "SELECT * FROM PlantasMedicinais WHERE PlantaId = ?";
        if (parte_utilizada != null) sql += " AND ParteUtilizada = ?";
        ResultSet lista_resultados = null;
        int index = 1;
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1, nome);
            if (parte_utilizada != null) comando.setInt(++index, parte_utilizada.ordinal());
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) pesquisa_ok = true;
            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção_sql) {exceção_sql.printStackTrace ();}
        return pesquisa_ok;
    }


    private static boolean isOkPesquisaEmPlantaTóxica(String nome, CompostoTóxico composto_tóxico) {
        boolean pesquisa_ok = false;
        String sql = "SELECT * FROM PlantasToxicas WHERE PlantaId = ?";
        if (composto_tóxico != null) sql += " AND CompostoToxico = ?";
        ResultSet lista_resultados = null;
        int index = 1;
      try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1, nome);
            if (composto_tóxico != null) comando.setInt(++index, composto_tóxico.ordinal());
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) pesquisa_ok = true;
            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção_sql) {exceção_sql.printStackTrace ();}
        return pesquisa_ok;
    }

    public static ArrayList<AvaliaçãoToxicidade> pesquisarAvaliaçõesToxicidade(Especialidade especialidade_botânico, char região_acessível,
            Origem origem_planta, int n_plantas_alta_toxicidade, ParteUtilizada parte_utilizada, CompostoTóxico composto_tóxico, boolean todas_plantas_região) {
        String sql = "SELECT Bt.Nome, Bt.Especialidade, R.Sequencial, R.Acessivel,"
                + " Avt.Sequencial, Avt.N_plantas_alta_toxicidade"
                + " FROM Botanicos Bt, Regioes R, AvaliacoesToxicidade Avt"
                + " WHERE Avt.BotanicoId = Bt.Nome AND Avt.RegiaoId = R.Sequencial";

        if (especialidade_botânico != null)  sql += " AND Bt.Especialidade = ?";     
        if (região_acessível != 'X') sql += " AND R.Acessivel = ?";
        if (n_plantas_alta_toxicidade > -1) sql += " AND Avt.N_plantas_alta_toxicidade >= ?";
        
        sql += " ORDER BY Avt.Sequencial";

        ResultSet lista_resultados = null;
        ArrayList<AvaliaçãoToxicidade> avaliações_toxicidade_selecionadas = new ArrayList();
        int index = 0;
        int sequencial_região = -1;
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            boolean possui_região_acessível = true;
            if (especialidade_botânico != null) comando.setInt(++index, especialidade_botânico.ordinal());

            if (região_acessível != 'X') {
                switch (região_acessível) {
                    case 'T': comando.setBoolean(++index, true); break;
                    case 'F': comando.setBoolean(++index, false);
                }
            }

            if (n_plantas_alta_toxicidade > -1)comando.setInt(++index, n_plantas_alta_toxicidade);

            lista_resultados = comando.executeQuery();
            
            while (lista_resultados.next()) {
                AvaliaçãoToxicidade avaliação_toxicidade_pesquisada
                        = AvaliaçãoToxicidade.buscarAvaliaçãoToxicidade(lista_resultados.getInt(5));
                sequencial_região = lista_resultados.getInt(3);
                if (!plantasRegiãoAtendemFiltros(sequencial_região, origem_planta, parte_utilizada, composto_tóxico, todas_plantas_região)) {
                    continue;
                } else {
                    avaliações_toxicidade_selecionadas.add(avaliação_toxicidade_pesquisada);
                }
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
        }
        return avaliações_toxicidade_selecionadas;
    }

   
}
