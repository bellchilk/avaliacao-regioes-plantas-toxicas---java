package interfaces;

import controles.ControladorCadastroBotânicos;
import controles.ControladorCadastroPlantas;
import controles.ControladorCadastroRegiões;
import controles.ControladorCadastroAvaliaçõesToxicidade;
import interfaces.JanelaPesquisaAvaliaçõesToxicidade;

import javax.swing.JOptionPane;

import persistência.BD;


public class JanelaSistema extends javax.swing.JFrame {

    public JanelaSistema() {
        BD.criaConexão();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        plantas_regiãoMenuBar = new javax.swing.JMenuBar();
        plantaMenu = new javax.swing.JMenu();
        cadastrar_plantaMenuItem = new javax.swing.JMenuItem();
        botanicoMenu = new javax.swing.JMenu();
        cadastrar_botanicoMenuItem = new javax.swing.JMenuItem();
        RegiõesMenu = new javax.swing.JMenu();
        RegiõesMenuItem = new javax.swing.JMenuItem();
        avaliaçõesMenu = new javax.swing.JMenu();
        cadastrar_avaliaçãoMenuItem = new javax.swing.JMenuItem();
        pesquisar_avaliaçãoMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Avaliação de Regiões com Plantas Tóxicas");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                terminarSistema(evt);
            }
        });

        plantaMenu.setText("Planta");

        cadastrar_plantaMenuItem.setText("Cadastrar");
        cadastrar_plantaMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarPlanta(evt);
            }
        });
        plantaMenu.add(cadastrar_plantaMenuItem);

        plantas_regiãoMenuBar.add(plantaMenu);

        botanicoMenu.setText("Botânico");

        cadastrar_botanicoMenuItem.setText("Cadastrar");
        cadastrar_botanicoMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarBotanico(evt);
            }
        });
        botanicoMenu.add(cadastrar_botanicoMenuItem);

        plantas_regiãoMenuBar.add(botanicoMenu);

        RegiõesMenu.setText("Região");

        RegiõesMenuItem.setText("Cadastrar");
        RegiõesMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarRegião(evt);
            }
        });
        RegiõesMenu.add(RegiõesMenuItem);

        plantas_regiãoMenuBar.add(RegiõesMenu);

        avaliaçõesMenu.setText("Avaliação");

        cadastrar_avaliaçãoMenuItem.setText("Cadastrar");
        cadastrar_avaliaçãoMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarAvaliaçãoToxicidade(evt);
            }
        });
        avaliaçõesMenu.add(cadastrar_avaliaçãoMenuItem);

        pesquisar_avaliaçãoMenuItem.setText("Pesquisar");
        pesquisar_avaliaçãoMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisarAvaliaçãoToxicidade(evt);
            }
        });
        avaliaçõesMenu.add(pesquisar_avaliaçãoMenuItem);

        plantas_regiãoMenuBar.add(avaliaçõesMenu);

        setJMenuBar(plantas_regiãoMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 281, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void terminarSistema(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_terminarSistema
        BD.fechaConexão();
        System.exit(0);
    }//GEN-LAST:event_terminarSistema

    private void cadastrarBotanico(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarBotanico
        new ControladorCadastroBotânicos();
    }//GEN-LAST:event_cadastrarBotanico

    private void cadastrarAvaliaçãoToxicidade(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarAvaliaçãoToxicidade
        new ControladorCadastroAvaliaçõesToxicidade();
    }//GEN-LAST:event_cadastrarAvaliaçãoToxicidade

    private void pesquisarAvaliaçãoToxicidade(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisarAvaliaçãoToxicidade
        new JanelaPesquisaAvaliaçõesToxicidade().setVisible(true);
    }//GEN-LAST:event_pesquisarAvaliaçãoToxicidade

    private void cadastrarPlanta(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarPlanta
        new ControladorCadastroPlantas();
    }//GEN-LAST:event_cadastrarPlanta

    private void cadastrarRegião(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarRegião
        new ControladorCadastroRegiões();
    }//GEN-LAST:event_cadastrarRegião

    private void informarServiçoIndisponível() {
        JOptionPane.showMessageDialog (this, "Serviço Indisponível", "Informação",
        JOptionPane.INFORMATION_MESSAGE);
    }
   
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JanelaSistema().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu RegiõesMenu;
    private javax.swing.JMenuItem RegiõesMenuItem;
    private javax.swing.JMenu avaliaçõesMenu;
    private javax.swing.JMenu botanicoMenu;
    private javax.swing.JMenuItem cadastrar_avaliaçãoMenuItem;
    private javax.swing.JMenuItem cadastrar_botanicoMenuItem;
    private javax.swing.JMenuItem cadastrar_plantaMenuItem;
    private javax.swing.JMenuItem pesquisar_avaliaçãoMenuItem;
    private javax.swing.JMenu plantaMenu;
    private javax.swing.JMenuBar plantas_regiãoMenuBar;
    // End of variables declaration//GEN-END:variables
}
