
package interfaces;

import javax.swing.JOptionPane;
import controles.ControladorCadastroVisitasCampo;
import entidades.VisitaCampo;
import entidades.Região;
import entidades.Planta;
import javax.swing.DefaultListModel;
import javax.swing.DefaultComboBoxModel;

public class JanelaCadastroVisitasCampo extends javax.swing.JFrame {
    
    ControladorCadastroVisitasCampo controlador;
    JanelaCadastroRegiões janela_mãe;
    int sequencial_região;
    Planta[] plantas_cadastradas;
    DefaultListModel modelo_lista_visitas_campo;

   
    public JanelaCadastroVisitasCampo(ControladorCadastroVisitasCampo controlador, JanelaCadastroRegiões janela_mãe, int sequencial_região) {
        this.controlador = controlador;
        this.janela_mãe = janela_mãe;
        this.sequencial_região = sequencial_região;

        plantas_cadastradas = Planta.getVisões();
        initComponents();
        atualizarEcossistemaRegião();
        atualizarListaVisitasCampo();
    }

    private void atualizarEcossistemaRegião () {
        Região região = Região.buscarRegião(sequencial_região);
        regiãoLabel.setText("Região : " + região.getEcossistema());
    }

    private void atualizarListaVisitasCampo () {
        modelo_lista_visitas_campo = (DefaultListModel)visitasCampoList.getModel();
        VisitaCampo[] visitas_campo = VisitaCampo.buscarVisitaCampo(sequencial_região);
        for (VisitaCampo visita_campo : visitas_campo) modelo_lista_visitas_campo.addElement(visita_campo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        regiãoLabel = new javax.swing.JLabel();
        botânicosCadastradosLabel = new javax.swing.JLabel();
        visitasCampoRegiãoLabel = new javax.swing.JLabel();
        plantas_cadastradasComboBox = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        visitasCampoList = new javax.swing.JList();
        comandosPanel = new javax.swing.JPanel();
        inserirButton = new javax.swing.JButton();
        removerButton = new javax.swing.JButton();
        Espaçamento = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Visitas de Campo");
        setMinimumSize(new java.awt.Dimension(621, 330));
        setPreferredSize(new java.awt.Dimension(490, 320));

        regiãoLabel.setText("Regiões:");

        botânicosCadastradosLabel.setText("Plantas Cadastradas");

        visitasCampoRegiãoLabel.setText("Visitas de Campo na Região");

        plantas_cadastradasComboBox.setModel(new javax.swing.DefaultComboBoxModel(plantas_cadastradas));

        visitasCampoList.setModel(new DefaultListModel());
        jScrollPane1.setViewportView(visitasCampoList);

        inserirButton.setText("Inserir");
        inserirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inserirVisitaCampo(evt);
            }
        });
        comandosPanel.add(inserirButton);

        removerButton.setText("Remover");
        removerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerVisitaCampo(evt);
            }
        });
        comandosPanel.add(removerButton);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(regiãoLabel)
                            .addComponent(botânicosCadastradosLabel)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(visitasCampoRegiãoLabel)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
                    .addComponent(plantas_cadastradasComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Espaçamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 74, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(comandosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(190, 190, 190))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(62, Short.MAX_VALUE)
                .addComponent(regiãoLabel)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botânicosCadastradosLabel)
                    .addComponent(plantas_cadastradasComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(Espaçamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(visitasCampoRegiãoLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comandosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void removerVisitaCampo(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerVisitaCampo
        VisitaCampo visita_campo = (VisitaCampo) visitasCampoList.getSelectedValue();
        String mensagem_erro = null;
        if (visita_campo != null) mensagem_erro = controlador.removerVisitaCampo(visita_campo.getSequencial());
        else mensagem_erro = "Nenhuma visita de campo foi selecionado";
        if (mensagem_erro == null) modelo_lista_visitas_campo.removeElement(visita_campo);
        else informarErro (mensagem_erro);
    }//GEN-LAST:event_removerVisitaCampo

    private void inserirVisitaCampo(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inserirVisitaCampo
        Planta visão_planta = (Planta) plantas_cadastradasComboBox.getSelectedItem();
        String mensagem_erro = null;
        VisitaCampo visita_campo = null;
        if (visão_planta != null) {
            Região visão_região = Região.buscarRegião(sequencial_região);
            visita_campo = new VisitaCampo (0, visão_região, visão_planta);
            mensagem_erro = controlador.inserirVisitaCampo(visita_campo);
        } else mensagem_erro = "Nenhuma planta foi selecionada";
        if (mensagem_erro == null) {
            int sequencial = VisitaCampo.últimoSequencial();
            visita_campo.setSequencial(sequencial);
            modelo_lista_visitas_campo.addElement(visita_campo);
        } else informarErro (mensagem_erro);
    }//GEN-LAST:event_inserirVisitaCampo

    private void informarErro(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Espaçamento;
    private javax.swing.JLabel botânicosCadastradosLabel;
    private javax.swing.JPanel comandosPanel;
    private javax.swing.JButton inserirButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox plantas_cadastradasComboBox;
    private javax.swing.JLabel regiãoLabel;
    private javax.swing.JButton removerButton;
    private javax.swing.JList visitasCampoList;
    private javax.swing.JLabel visitasCampoRegiãoLabel;
    // End of variables declaration//GEN-END:variables
}
