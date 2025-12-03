package interfaces;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

import entidades.AvaliaçãoToxicidade;
import entidades.Botânico.Especialidade;
import entidades.Planta.Origem;
import entidades.PlantaMedicinal.ParteUtilizada;
import entidades.PlantaTóxica.CompostoTóxico;

public class JanelaPesquisaAvaliaçõesToxicidade extends javax.swing.JFrame {
    PainelFiltrosPlantaMedicinal filtros_planta_medicinalPainel;
    PainelFiltrosPlantaTóxica filtros_planta_tóxicaPainel;


    public JanelaPesquisaAvaliaçõesToxicidade() {
        initComponents();
        filtros_planta_medicinalPainel = new PainelFiltrosPlantaMedicinal();
        filtros_planta_tóxicaPainel = new PainelFiltrosPlantaTóxica();
        filtros_específicos_regiãoTabbedPane.addTab("Filtros de Planta Medicinal",
                filtros_planta_medicinalPainel);
        filtros_específicos_regiãoTabbedPane.addTab("Filtros de Planta Tóxica",
                filtros_planta_tóxicaPainel);
        limparFiltros(null);
    }
    
    private char getRegiãoAcessível() {
        char região_acessível = 'X';
        if (região_acessívelButtonGroup.getSelection() != null) {
            switch (região_acessívelButtonGroup.getSelection().getMnemonic()) {
                case 0:
                    região_acessível = 'T';
                    break;
                case 1:
                    região_acessível = 'F';
                    break;
            }
    
        }
        return região_acessível;
    }

    
    private void mostrarAvaliaçõesSelecionadas(ArrayList<AvaliaçãoToxicidade> avaliações_toxicidade) {
        boolean primeira_avaliação_toxicidade = true;
        for (AvaliaçãoToxicidade avaliação_toxicidade : avaliações_toxicidade) {
            if (primeira_avaliação_toxicidade) {
                pesquisasTextArea.append(avaliação_toxicidade.toStringFull());
                primeira_avaliação_toxicidade = false;
            } else {
                pesquisasTextArea.append("\n" + avaliação_toxicidade.toStringFull());
            }
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        especialidade_botânicoButtonGroup = new javax.swing.ButtonGroup();
        região_acessívelButtonGroup = new javax.swing.ButtonGroup();
        comandosPanel = new javax.swing.JPanel();
        pesquisarButton = new javax.swing.JButton();
        limpar_filtrosButton = new javax.swing.JButton();
        limparButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        taxonomiaVegetalRadioButton = new javax.swing.JRadioButton();
        fisiologiaVegetalRadioButton = new javax.swing.JRadioButton();
        botânicaEconômicaRadioButton = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        n_plantas_alta_toxicidadeTextField = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        simRadioButton = new javax.swing.JRadioButton();
        nãoRadioButton = new javax.swing.JRadioButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pesquisasTextArea = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        OrigemLabel = new javax.swing.JLabel();
        origem_plantasComboBox = new javax.swing.JComboBox();
        filtros_específicos_regiãoTabbedPane = new javax.swing.JTabbedPane();
        jPanel9 = new javax.swing.JPanel();
        todas_plantas_regiãoCheckBox = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pesquisa Avaliações de Toxicidade");

        pesquisarButton.setText("Pesquisar");
        pesquisarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisarAvaliaçãoToxicidade(evt);
            }
        });
        comandosPanel.add(pesquisarButton);

        limpar_filtrosButton.setText("Limpar Filtros");
        limpar_filtrosButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparFiltros(evt);
            }
        });
        comandosPanel.add(limpar_filtrosButton);

        limparButton.setText("Limpar Pesquisa");
        limparButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparPesquisa(evt);
            }
        });
        comandosPanel.add(limparButton);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtros de Botânicos"));

        jLabel2.setText("Especialidade");
        jPanel4.add(jLabel2);

        especialidade_botânicoButtonGroup.add(taxonomiaVegetalRadioButton);
        taxonomiaVegetalRadioButton.setText("taxonomia vegetal");
        jPanel4.add(taxonomiaVegetalRadioButton);

        especialidade_botânicoButtonGroup.add(fisiologiaVegetalRadioButton);
        fisiologiaVegetalRadioButton.setMnemonic('\u0001');
        fisiologiaVegetalRadioButton.setText("fisiologia vegetal");
        jPanel4.add(fisiologiaVegetalRadioButton);

        especialidade_botânicoButtonGroup.add(botânicaEconômicaRadioButton);
        botânicaEconômicaRadioButton.setMnemonic('\u0002');
        botânicaEconômicaRadioButton.setText("botânica econômica");
        jPanel4.add(botânicaEconômicaRadioButton);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(166, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 13, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtros de Avaliações de Toxicidade"));

        jLabel3.setText("Número de Plantas com Alta Toxicidade");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(n_plantas_alta_toxicidadeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(n_plantas_alta_toxicidadeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addContainerGap())))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtros de Regiões"));

        jLabel4.setText("Acessível");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        região_acessívelButtonGroup.add(simRadioButton);
        simRadioButton.setText("sim");
        jPanel7.add(simRadioButton);

        região_acessívelButtonGroup.add(nãoRadioButton);
        nãoRadioButton.setMnemonic('\u0001');
        nãoRadioButton.setText("não");
        jPanel7.add(nãoRadioButton);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Avaliações de Toxicidade Selecionadas"));

        pesquisasTextArea.setEditable(false);
        pesquisasTextArea.setColumns(20);
        pesquisasTextArea.setRows(5);
        jScrollPane1.setViewportView(pesquisasTextArea);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 892, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 13, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtros de Plantas"));

        OrigemLabel.setText("Origem");

        origem_plantasComboBox.setModel(new DefaultComboBoxModel (Origem.values()));
        origem_plantasComboBox.setToolTipText("");

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Abrangência das Plantas das Regiões"));

        todas_plantas_regiãoCheckBox.setText("Todos as Plantas de Região");
        jPanel9.add(todas_plantas_regiãoCheckBox);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(OrigemLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(origem_plantasComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(filtros_específicos_regiãoTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(OrigemLabel)
                            .addComponent(origem_plantasComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(filtros_específicos_regiãoTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(239, 239, 239)
                        .addComponent(comandosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(comandosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void limparPesquisa(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparPesquisa
        pesquisasTextArea.setText("");
    }//GEN-LAST:event_limparPesquisa

    private void limparFiltros(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparFiltros
        especialidade_botânicoButtonGroup.clearSelection();
        região_acessívelButtonGroup.clearSelection();
        todas_plantas_regiãoCheckBox.setSelected(false);
        origem_plantasComboBox.setSelectedIndex(-1);
        n_plantas_alta_toxicidadeTextField.setText("");
        filtros_planta_medicinalPainel.limparFiltros();
        filtros_planta_tóxicaPainel.limparFiltros();
    }//GEN-LAST:event_limparFiltros

    private void pesquisarAvaliaçãoToxicidade(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisarAvaliaçãoToxicidade
        Especialidade especialidade_botânico = null;
        if (especialidade_botânicoButtonGroup.getSelection() != null)
        especialidade_botânico = Especialidade.values()[especialidade_botânicoButtonGroup.getSelection().getMnemonic()];

        char região_acessível = getRegiãoAcessível();

        Origem origem_planta = null;
        if (origem_plantasComboBox.getSelectedItem() != null)
        origem_planta = (Origem) origem_plantasComboBox.getSelectedItem();

        int n_plantas_alta_toxicidade = -1;
        if (!n_plantas_alta_toxicidadeTextField.getText().isEmpty())
        n_plantas_alta_toxicidade = Integer.parseInt(n_plantas_alta_toxicidadeTextField.getText());

        ParteUtilizada parte_utilizada = null;
        CompostoTóxico composto_tóxico = null;
        int índice_aba_secionada = filtros_específicos_regiãoTabbedPane.getSelectedIndex();
        if (índice_aba_secionada == 0){
            parte_utilizada = filtros_planta_medicinalPainel.getSelectedParteUtilizada();
        } else if (índice_aba_secionada == 1){
            composto_tóxico = filtros_planta_tóxicaPainel.getSelectedCompostoTóxico();
        }

        boolean todas_plantas_região = todas_plantas_regiãoCheckBox.isSelected();

        ArrayList<AvaliaçãoToxicidade> avaliações_toxicidade = AvaliaçãoToxicidade.pesquisarAvaliaçõesToxicidade(especialidade_botânico, região_acessível, origem_planta,  n_plantas_alta_toxicidade, parte_utilizada, composto_tóxico,todas_plantas_região);
        mostrarAvaliaçõesSelecionadas(avaliações_toxicidade);
    }//GEN-LAST:event_pesquisarAvaliaçãoToxicidade

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel OrigemLabel;
    private javax.swing.JRadioButton botânicaEconômicaRadioButton;
    private javax.swing.JPanel comandosPanel;
    private javax.swing.ButtonGroup especialidade_botânicoButtonGroup;
    private javax.swing.JTabbedPane filtros_específicos_regiãoTabbedPane;
    private javax.swing.JRadioButton fisiologiaVegetalRadioButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton limparButton;
    private javax.swing.JButton limpar_filtrosButton;
    private javax.swing.JTextField n_plantas_alta_toxicidadeTextField;
    private javax.swing.JRadioButton nãoRadioButton;
    private javax.swing.JComboBox origem_plantasComboBox;
    private javax.swing.JButton pesquisarButton;
    private javax.swing.JTextArea pesquisasTextArea;
    private javax.swing.ButtonGroup região_acessívelButtonGroup;
    private javax.swing.JRadioButton simRadioButton;
    private javax.swing.JRadioButton taxonomiaVegetalRadioButton;
    private javax.swing.JCheckBox todas_plantas_regiãoCheckBox;
    // End of variables declaration//GEN-END:variables
}
