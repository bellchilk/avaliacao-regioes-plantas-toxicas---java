package interfaces;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import controles.ControladorCadastroRegiões;
import controles.ControladorCadastroVisitasCampo;
import entidades.Região;
import entidades.Região.Uf;
import entidades.VisitaCampo;

public class JanelaCadastroRegiões extends javax.swing.JFrame {
    
    ControladorCadastroRegiões controlador;
    Região[] regiões_cadastradas;
    DefaultListModel modelo_visitas_campo;

    public JanelaCadastroRegiões(ControladorCadastroRegiões controlador) {
        this.controlador = controlador;
        regiões_cadastradas = Região.getVisões();
        initComponents();
        modelo_visitas_campo = (DefaultListModel)visitasCampoList.getModel();
        limparCampos(null);
    }

    private void selecionarUfRadioButton(int índice_uf) {
        switch(índice_uf) {
            case 0:
                msRadioButton.setSelected(true);
                break;
            case 1:
                spRadioButton.setSelected(true);
                break;
            case 2:
                amRadioButton.setSelected(true);
                break;
            case 3:
                goRadioButton.setSelected(true);
                break;
        }
    }
    
    public void atualizarListaVisitasCampo (int sequencial){
        modelo_visitas_campo.clear();
        VisitaCampo[] visitas_campo = VisitaCampo.buscarVisitaCampo(sequencial);
        for (VisitaCampo visita_campo : visitas_campo) modelo_visitas_campo.addElement(visita_campo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        especialidadeButtonGroup = new javax.swing.ButtonGroup();
        titulaçãoButtonGroup = new javax.swing.ButtonGroup();
        ufButtonGroup = new javax.swing.ButtonGroup();
        RegiõesCadastradasLabel = new javax.swing.JLabel();
        regiões_cadastradasComboBox = new javax.swing.JComboBox();
        NomeLabel = new javax.swing.JLabel();
        sequencialTextField = new javax.swing.JTextField();
        EcossistemaLabel = new javax.swing.JLabel();
        TitulaçãoLabel = new javax.swing.JLabel();
        AnosExperiênciaLabel = new javax.swing.JLabel();
        frequenciaAcidentesPorAnoTextField = new javax.swing.JTextField();
        comandosPanel = new javax.swing.JPanel();
        inserirButton = new javax.swing.JButton();
        removerButton = new javax.swing.JButton();
        consultarButton = new javax.swing.JButton();
        alterarButton = new javax.swing.JButton();
        limparButton = new javax.swing.JButton();
        visitaCampo = new javax.swing.JButton();
        ecossistemaTextField = new javax.swing.JTextField();
        VisitasCampoLabel = new javax.swing.JLabel();
        acessívelCheckBox = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        msRadioButton = new javax.swing.JRadioButton();
        spRadioButton = new javax.swing.JRadioButton();
        amRadioButton = new javax.swing.JRadioButton();
        goRadioButton = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        visitasCampoList = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar Regiões");
        setMinimumSize(new java.awt.Dimension(538, 372));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        RegiõesCadastradasLabel.setText("Regiões Cadastradas");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 3);
        getContentPane().add(RegiõesCadastradasLabel, gridBagConstraints);

        regiões_cadastradasComboBox.setModel(new javax.swing.DefaultComboBoxModel(regiões_cadastradas));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 109);
        getContentPane().add(regiões_cadastradasComboBox, gridBagConstraints);

        NomeLabel.setText("Identificador Sequencial");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 3);
        getContentPane().add(NomeLabel, gridBagConstraints);

        sequencialTextField.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 45;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        getContentPane().add(sequencialTextField, gridBagConstraints);

        EcossistemaLabel.setText("Ecossistema");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 0, 3);
        getContentPane().add(EcossistemaLabel, gridBagConstraints);

        TitulaçãoLabel.setText("UF");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 0, 5);
        getContentPane().add(TitulaçãoLabel, gridBagConstraints);

        AnosExperiênciaLabel.setText("Frequencia de Acidentes por Ano");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(1, 3, 0, 3);
        getContentPane().add(AnosExperiênciaLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 19);
        getContentPane().add(frequenciaAcidentesPorAnoTextField, gridBagConstraints);

        inserirButton.setText("Inserir");
        inserirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inserirRegião(evt);
            }
        });
        comandosPanel.add(inserirButton);

        removerButton.setText("Remover");
        removerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerRegião(evt);
            }
        });
        comandosPanel.add(removerButton);

        consultarButton.setText("Consultar");
        consultarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarRegião(evt);
            }
        });
        comandosPanel.add(consultarButton);

        alterarButton.setText("Alterar");
        alterarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterarRegião(evt);
            }
        });
        comandosPanel.add(alterarButton);

        limparButton.setText("Limpar");
        limparButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparCampos(evt);
            }
        });
        comandosPanel.add(limparButton);

        visitaCampo.setText("Visitas de Campo");
        visitaCampo.setActionCommand("Visistas de Campo");
        visitaCampo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarVisitasCampo(evt);
            }
        });
        comandosPanel.add(visitaCampo);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 51;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        getContentPane().add(comandosPanel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 113;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 7);
        getContentPane().add(ecossistemaTextField, gridBagConstraints);

        VisitasCampoLabel.setText("Visitas de Campo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(1, 3, 0, 3);
        getContentPane().add(VisitasCampoLabel, gridBagConstraints);

        acessívelCheckBox.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(6, 4, 5, 0);
        getContentPane().add(acessívelCheckBox, gridBagConstraints);

        jLabel1.setText("Acessível");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(1, 0, 0, 5);
        getContentPane().add(jLabel1, gridBagConstraints);

        ufButtonGroup.add(msRadioButton);
        msRadioButton.setText("MS");
        jPanel1.add(msRadioButton);

        ufButtonGroup.add(spRadioButton);
        spRadioButton.setMnemonic('\u0001');
        spRadioButton.setText("SP");
        jPanel1.add(spRadioButton);

        ufButtonGroup.add(amRadioButton);
        amRadioButton.setMnemonic('\u0002');
        amRadioButton.setText("AM");
        jPanel1.add(amRadioButton);

        ufButtonGroup.add(goRadioButton);
        goRadioButton.setMnemonic('\u0003');
        goRadioButton.setText("GO");
        jPanel1.add(goRadioButton);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 245);
        getContentPane().add(jPanel1, gridBagConstraints);

        visitasCampoList.setModel(new DefaultListModel());
        visitasCampoList.setVisibleRowCount(4);
        jScrollPane1.setViewportView(visitasCampoList);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.ipadx = 184;
        gridBagConstraints.ipady = 92;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        getContentPane().add(jScrollPane1, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents
 
    private void consultarRegião(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarRegião
        Região visão = (Região) regiões_cadastradasComboBox.getSelectedItem();
        Região região = null;
        String mensagem_erro = null;
        int sequencial = -1;

        if (visão != null) {
            sequencial = visão.getSequencial();
            região = Região.buscarRegião(sequencial);
            if (região == null) mensagem_erro = "Região não cadastrada";
        } else mensagem_erro = "Nenhuma região selecionada";

        if (mensagem_erro == null) {
            sequencialTextField.setText(sequencial + "");
            ecossistemaTextField.setText(região.getEcossistema());
            selecionarUfRadioButton(região.getUf().ordinal());
            frequenciaAcidentesPorAnoTextField.setText(região.getFrequenciaAcidentesPorAno() +"");
            acessívelCheckBox.setSelected(região.isAcessível());
            atualizarListaVisitasCampo(sequencial);

        } else informarErro(mensagem_erro);
    }//GEN-LAST:event_consultarRegião

@SuppressWarnings({ "rawtypes", "unchecked" })
    private void inserirRegião(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inserirRegião
        Região região = obterRegiãoInformada();
        String mensagem_erro = null;
        if (região != null) mensagem_erro = controlador.inserirRegião(região);
        else mensagem_erro = "Algum atributo de região não foi informado";
        if (mensagem_erro == null){
            int sequencial = Região.últimoSequencial();
            região.setSequencial(sequencial);
            Região visão = região.getVisão();
            regiões_cadastradasComboBox.addItem(visão);
            regiões_cadastradasComboBox.setSelectedItem(visão);
            sequencialTextField.setText ("" + sequencial);

        }else informarErro (mensagem_erro);
    }//GEN-LAST:event_inserirRegião

    @SuppressWarnings({ "rawtypes" })
    private void removerRegião(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerRegião
      Região visão = (Região) regiões_cadastradasComboBox.getSelectedItem();
      String mensagem_erro = null;

        if (visão != null) mensagem_erro = controlador.removerRegião(visão.getSequencial());
        else mensagem_erro = "Nenhuma região selecionado";

        if (mensagem_erro == null) {
           regiões_cadastradasComboBox.removeItem(visão);
           limparCampos(null);
        } else informarErro(mensagem_erro);  

    }//GEN-LAST:event_removerRegião

    private void alterarRegião(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterarRegião
        Região região = obterRegiãoInformada();
        String mensagen_erro = null;

        if (região != null) mensagen_erro = controlador.alterarRegião(região);
        else mensagen_erro = "Algum atributo de região não foi informado";

        if (mensagen_erro == null) {
            Região visão = (Região) regiões_cadastradasComboBox.getSelectedItem();
                    
            if (visão != null) {
                visão.setEcossistema(região.getEcossistema());
                regiões_cadastradasComboBox.updateUI();
                regiões_cadastradasComboBox.setSelectedItem(visão);
            }
            
        } else informarErro(mensagen_erro);
    }//GEN-LAST:event_alterarRegião

    private void limparCampos(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparCampos
        sequencialTextField.setText("");
        ecossistemaTextField.setText("");
        ufButtonGroup.clearSelection();
        frequenciaAcidentesPorAnoTextField.setText("");
        acessívelCheckBox.setSelected(false);
    }//GEN-LAST:event_limparCampos

    private void cadastrarVisitasCampo(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarVisitasCampo
        String sequencial_str = sequencialTextField.getText();
        int sequencial = 0;
        if (!sequencial_str.isEmpty()) sequencial = Integer.parseInt(sequencial_str);
        if (sequencial > 0) new ControladorCadastroVisitasCampo(this, sequencial);
        else informarErro ("Nenhuma região selecionado");
    }//GEN-LAST:event_cadastrarVisitasCampo

    
    private Região obterRegiãoInformada() {
        String sequencial_str = sequencialTextField.getText();
        int sequencial = 0;
        if (!sequencial_str.isEmpty()) sequencial = Integer.parseInt(sequencial_str);
        
        String ecossistema = ecossistemaTextField.getText();
        if (ecossistema.isEmpty()) return null;
        
        Uf uf = null;
        if (ufButtonGroup.getSelection() != null){
            uf = Uf.values()[ufButtonGroup.getSelection().getMnemonic()];
        }else return null;
        
        String frequencia_acidentes_por_ano_str = frequenciaAcidentesPorAnoTextField.getText();
        int frequencia_acidentes_por_ano = -1;
        if (!frequencia_acidentes_por_ano_str.isEmpty()) frequencia_acidentes_por_ano = Integer.parseInt(frequencia_acidentes_por_ano_str);
        else return null;
        
        boolean  acessível = acessívelCheckBox.isSelected();

        return new Região(sequencial, ecossistema, uf, frequencia_acidentes_por_ano, acessível);
    }
    
    private void informarErro(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AnosExperiênciaLabel;
    private javax.swing.JLabel EcossistemaLabel;
    private javax.swing.JLabel NomeLabel;
    private javax.swing.JLabel RegiõesCadastradasLabel;
    private javax.swing.JLabel TitulaçãoLabel;
    private javax.swing.JLabel VisitasCampoLabel;
    private javax.swing.JCheckBox acessívelCheckBox;
    private javax.swing.JButton alterarButton;
    private javax.swing.JRadioButton amRadioButton;
    private javax.swing.JPanel comandosPanel;
    private javax.swing.JButton consultarButton;
    private javax.swing.JTextField ecossistemaTextField;
    private javax.swing.ButtonGroup especialidadeButtonGroup;
    private javax.swing.JTextField frequenciaAcidentesPorAnoTextField;
    private javax.swing.JRadioButton goRadioButton;
    private javax.swing.JButton inserirButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton limparButton;
    private javax.swing.JRadioButton msRadioButton;
    private javax.swing.JComboBox regiões_cadastradasComboBox;
    private javax.swing.JButton removerButton;
    private javax.swing.JTextField sequencialTextField;
    private javax.swing.JRadioButton spRadioButton;
    private javax.swing.ButtonGroup titulaçãoButtonGroup;
    private javax.swing.ButtonGroup ufButtonGroup;
    private javax.swing.JButton visitaCampo;
    private javax.swing.JList visitasCampoList;
    // End of variables declaration//GEN-END:variables
}
