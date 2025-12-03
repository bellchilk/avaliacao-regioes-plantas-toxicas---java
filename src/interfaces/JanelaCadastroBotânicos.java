package interfaces;

import javax.swing.JOptionPane;
import controles.ControladorCadastroBotânicos;
import entidades.Botânico;
import entidades.Botânico.Especialidade;
import entidades.Botânico.Titulação;

import javax.swing.DefaultComboBoxModel;

public class JanelaCadastroBotânicos extends javax.swing.JFrame {

    ControladorCadastroBotânicos controlador;
    Botânico[] botanicos_cadastrados;
   
    public JanelaCadastroBotânicos(ControladorCadastroBotânicos controlador) {
        this.controlador = controlador;
        botanicos_cadastrados = Botânico.getVisões();
        initComponents();
        limparCampos(null);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        especialidadeButtonGroup = new javax.swing.ButtonGroup();
        titulaçãoButtonGroup = new javax.swing.ButtonGroup();
        BotânicosCadastradosLabel = new javax.swing.JLabel();
        botanicos_cadastradosComboBox = new javax.swing.JComboBox();
        NomeLabel = new javax.swing.JLabel();
        nomeTextField = new javax.swing.JTextField();
        EspecialidadeLabel = new javax.swing.JLabel();
        TitulaçãoLabel = new javax.swing.JLabel();
        AnosExperiênciaLabel = new javax.swing.JLabel();
        anosExperiênciaTextField = new javax.swing.JTextField();
        comandosPanel = new javax.swing.JPanel();
        inserirButton = new javax.swing.JButton();
        removerButton = new javax.swing.JButton();
        consultarButton = new javax.swing.JButton();
        alterarButton = new javax.swing.JButton();
        limparButton = new javax.swing.JButton();
        Espaçamento = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        graduaçãoRadioButton = new javax.swing.JRadioButton();
        especializaçãoRadioButton = new javax.swing.JRadioButton();
        mestradoRadioButton = new javax.swing.JRadioButton();
        doutoradoRadioButton = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        taxonomiaVegetalRadioButton = new javax.swing.JRadioButton();
        fisiologiaVegetalRadioButton = new javax.swing.JRadioButton();
        botânicaEconômicaRadioButton = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar Botânico");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        BotânicosCadastradosLabel.setText("Botânicos Cadastrados");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 3);
        getContentPane().add(BotânicosCadastradosLabel, gridBagConstraints);

        botanicos_cadastradosComboBox.setModel(new javax.swing.DefaultComboBoxModel(botanicos_cadastrados));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(7, 0, 0, 100);
        getContentPane().add(botanicos_cadastradosComboBox, gridBagConstraints);

        NomeLabel.setText("Nome");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 3);
        getContentPane().add(NomeLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 3, 8, 100);
        getContentPane().add(nomeTextField, gridBagConstraints);

        EspecialidadeLabel.setText("Especialidade");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 3);
        getContentPane().add(EspecialidadeLabel, gridBagConstraints);

        TitulaçãoLabel.setText("Titulação");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 3);
        getContentPane().add(TitulaçãoLabel, gridBagConstraints);

        AnosExperiênciaLabel.setText("Anos de Experiência");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 3);
        getContentPane().add(AnosExperiênciaLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 37;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 5);
        getContentPane().add(anosExperiênciaTextField, gridBagConstraints);

        inserirButton.setText("Inserir");
        inserirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inserirBotânico(evt);
            }
        });
        comandosPanel.add(inserirButton);

        removerButton.setText("Remover");
        removerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerBotânico(evt);
            }
        });
        comandosPanel.add(removerButton);

        consultarButton.setText("Consultar");
        consultarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarBotânico(evt);
            }
        });
        comandosPanel.add(consultarButton);

        alterarButton.setText("Alterar");
        alterarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterarBotânico(evt);
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

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 41, 0, 2);
        getContentPane().add(comandosPanel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 8, 8, 8);
        getContentPane().add(Espaçamento, gridBagConstraints);

        titulaçãoButtonGroup.add(graduaçãoRadioButton);
        graduaçãoRadioButton.setText("graduação");
        jPanel2.add(graduaçãoRadioButton);

        titulaçãoButtonGroup.add(especializaçãoRadioButton);
        especializaçãoRadioButton.setMnemonic('\u0001');
        especializaçãoRadioButton.setText("especialização");
        jPanel2.add(especializaçãoRadioButton);

        titulaçãoButtonGroup.add(mestradoRadioButton);
        mestradoRadioButton.setMnemonic('\u0002');
        mestradoRadioButton.setText("mestrado");
        jPanel2.add(mestradoRadioButton);

        titulaçãoButtonGroup.add(doutoradoRadioButton);
        doutoradoRadioButton.setMnemonic('\u0003');
        doutoradoRadioButton.setText("doutorado");
        jPanel2.add(doutoradoRadioButton);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 69);
        getContentPane().add(jPanel2, gridBagConstraints);

        especialidadeButtonGroup.add(taxonomiaVegetalRadioButton);
        taxonomiaVegetalRadioButton.setText("taxonomia vegetal");
        jPanel3.add(taxonomiaVegetalRadioButton);

        especialidadeButtonGroup.add(fisiologiaVegetalRadioButton);
        fisiologiaVegetalRadioButton.setMnemonic('\u0001');
        fisiologiaVegetalRadioButton.setText("fisiologia vegetal");
        jPanel3.add(fisiologiaVegetalRadioButton);

        especialidadeButtonGroup.add(botânicaEconômicaRadioButton);
        botânicaEconômicaRadioButton.setMnemonic('\u0002');
        botânicaEconômicaRadioButton.setText("botânica econômica");
        jPanel3.add(botânicaEconômicaRadioButton);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 0);
        getContentPane().add(jPanel3, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void selecionarEspecialidadeRadioButton(int índice_especialidade) {
        switch(índice_especialidade) {
            case 0: taxonomiaVegetalRadioButton.setSelected(true);
                    break;
            case 1: fisiologiaVegetalRadioButton.setSelected(true);
                    break;
            case 2: botânicaEconômicaRadioButton.setSelected(true);
                    break;
        }
    }
    
    private void selecionarTitulaçãoRadioButton(int índice_titulação) {
        switch(índice_titulação) {
            case 0: graduaçãoRadioButton.setSelected(true);
                    break;
            case 1: especializaçãoRadioButton.setSelected(true);
                    break;
            case 2: mestradoRadioButton.setSelected(true);
                    break;
            case 3: doutoradoRadioButton.setSelected(true);
        }
    }
    
    private void consultarBotânico(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarBotânico
        Botânico visão = (Botânico) botanicos_cadastradosComboBox.getSelectedItem();
        Botânico botanico = null;
        String mensagem_erro = null;

        if (visão != null) {
            botanico = Botânico.buscarBotânico(visão.getNome());
            if (botanico == null) mensagem_erro = "Botânico não cadastrado";
        } else mensagem_erro = "Nenhum botânico selecionado";

        if (mensagem_erro == null) {
            nomeTextField.setText(botanico.getNome());
            anosExperiênciaTextField.setText(String.valueOf(botanico.getAnosExperiencia()));
            selecionarEspecialidadeRadioButton(botanico.getEspecialidade().ordinal());
            selecionarTitulaçãoRadioButton(botanico.getTitulação().ordinal());

        } else informarErro(mensagem_erro);
    }//GEN-LAST:event_consultarBotânico

@SuppressWarnings({ "rawtypes", "unchecked" })
    private void inserirBotânico(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inserirBotânico
      Botânico botanico = obterBotanicoInformado();
      String mensagem_erro = null;
        if (botanico != null) mensagem_erro = controlador.inserirBotanico(botanico);
        else mensagem_erro = "Algum atributo de botânico não foi informado";
        if (mensagem_erro == null){
            Botânico visão = botanico.getVisão();
            botanicos_cadastradosComboBox.addItem(visão);
            botanicos_cadastradosComboBox.setSelectedItem(visão);
        }else informarErro (mensagem_erro);
    }//GEN-LAST:event_inserirBotânico

    @SuppressWarnings({ "rawtypes" })
    private void removerBotânico(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerBotânico
      Botânico visão = (Botânico) botanicos_cadastradosComboBox.getSelectedItem();
      String mensagem_erro = null;

        if (visão != null) mensagem_erro = controlador.removerBotanico(visão.getNome());
        else mensagem_erro = "Nenhum botanico selecionado";

        if (mensagem_erro == null) {
           botanicos_cadastradosComboBox.removeItem(visão);
           limparCampos(null);
        } else informarErro(mensagem_erro);  

    }//GEN-LAST:event_removerBotânico

    private void alterarBotânico(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterarBotânico
        Botânico botanico = obterBotanicoInformado();
        String mensagen_erro = null;

        if (botanico != null) mensagen_erro = controlador.alterarBotanico(botanico);
        else mensagen_erro = "Algum atributo de botanico não foi informado";

        if (mensagen_erro == null) {
            Botânico visão = getVisãoAlterada(botanico.getNome());
            
            if (visão != null) {
                visão.setEspecialidade(botanico.getEspecialidade());
                botanicos_cadastradosComboBox.updateUI();
                botanicos_cadastradosComboBox.setSelectedItem(visão);
            }
            
        } else informarErro(mensagen_erro);
    }//GEN-LAST:event_alterarBotânico

    private void limparCampos(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparCampos
        nomeTextField.setText("");
        especialidadeButtonGroup.clearSelection();
        titulaçãoButtonGroup.clearSelection();
        anosExperiênciaTextField.setText("");
    }//GEN-LAST:event_limparCampos

    
    private Botânico obterBotanicoInformado() {
        String nome = nomeTextField.getText();
        if (nome.isEmpty()) return null;
        
        String anos_experiência_str = anosExperiênciaTextField.getText();
        if (anos_experiência_str.isEmpty()) return null;
        int anos_experiência = Integer.parseInt(anos_experiência_str);

        Especialidade especialidade = null;
        if (especialidadeButtonGroup.getSelection() != null){
            especialidade = Especialidade.values()[especialidadeButtonGroup.getSelection().getMnemonic()];
        }else return null;
        
        Titulação titulação = null;
        if (titulaçãoButtonGroup.getSelection() != null){
            titulação = Titulação.values()[titulaçãoButtonGroup.getSelection().getMnemonic()];
        }else return null;
        return new Botânico(nome, anos_experiência, especialidade, titulação);
    }
    
    private Botânico getVisãoAlterada(String nome) {
        for (Botânico visão : botanicos_cadastrados) {
            if (visão.getNome().equals(nome)) return visão;
        }
        return null;
    }

    private void informarErro(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AnosExperiênciaLabel;
    private javax.swing.JLabel BotânicosCadastradosLabel;
    private javax.swing.JPanel Espaçamento;
    private javax.swing.JLabel EspecialidadeLabel;
    private javax.swing.JLabel NomeLabel;
    private javax.swing.JLabel TitulaçãoLabel;
    private javax.swing.JButton alterarButton;
    private javax.swing.JTextField anosExperiênciaTextField;
    private javax.swing.JComboBox botanicos_cadastradosComboBox;
    private javax.swing.JRadioButton botânicaEconômicaRadioButton;
    private javax.swing.JPanel comandosPanel;
    private javax.swing.JButton consultarButton;
    private javax.swing.JRadioButton doutoradoRadioButton;
    private javax.swing.ButtonGroup especialidadeButtonGroup;
    private javax.swing.JRadioButton especializaçãoRadioButton;
    private javax.swing.JRadioButton fisiologiaVegetalRadioButton;
    private javax.swing.JRadioButton graduaçãoRadioButton;
    private javax.swing.JButton inserirButton;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton limparButton;
    private javax.swing.JRadioButton mestradoRadioButton;
    private javax.swing.JTextField nomeTextField;
    private javax.swing.JButton removerButton;
    private javax.swing.JRadioButton taxonomiaVegetalRadioButton;
    private javax.swing.ButtonGroup titulaçãoButtonGroup;
    // End of variables declaration//GEN-END:variables
}
