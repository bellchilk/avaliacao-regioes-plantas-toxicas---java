package interfaces;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import controles.ControladorCadastroPlantas;
import entidades.Planta;
import entidades.Planta.Origem;
import entidades.Planta.Toxicidade;
import entidades.PlantaMedicinal;
import entidades.PlantaMedicinal.ParteUtilizada;
import entidades.PlantaMedicinal.PropriedadeTerapeutica;
import entidades.PlantaTóxica;
import entidades.PlantaTóxica.CompostoTóxico;
import entidades.PlantaTóxica.EfeitoColateral;

public class JanelaCadastroPlantas extends javax.swing.JFrame {
    
    ControladorCadastroPlantas controlador;
    Planta[] plantas_cadastradas;
    PainelPlantaMedicinal planta_medicinalPainel;
    PainelPlantaTóxica planta_tóxicaPainel;

   
    public JanelaCadastroPlantas(ControladorCadastroPlantas controlador) {
        this.controlador = controlador;
        plantas_cadastradas = Planta.getVisões();
        initComponents();
        
        planta_medicinalPainel = new PainelPlantaMedicinal();
        planta_tóxicaPainel= new PainelPlantaTóxica();

        especialização_plantaTabbedPane.addTab("Planta Medicinal", planta_medicinalPainel);
        especialização_plantaTabbedPane.addTab("Planta Tóxica", planta_tóxicaPainel);
        limparCampos(null);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        toxicidadeButtonGroup = new javax.swing.ButtonGroup();
        PlantasCadastradasLabel = new javax.swing.JLabel();
        plantas_cadastradasComboBox = new javax.swing.JComboBox();
        NomeLabel = new javax.swing.JLabel();
        nomeTextField = new javax.swing.JTextField();
        ToxicidadeLabel = new javax.swing.JLabel();
        OrigemLabel = new javax.swing.JLabel();
        comandosPanel = new javax.swing.JPanel();
        inserirPlanta = new javax.swing.JButton();
        removerPlanta = new javax.swing.JButton();
        consultarPlanta = new javax.swing.JButton();
        alterarPlanta = new javax.swing.JButton();
        limparButton = new javax.swing.JButton();
        Espaçamento = new javax.swing.JPanel();
        alturaMaximaCmLabel = new javax.swing.JLabel();
        alturaMaximaCmTextField = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        nãoTóxicaRadioButton = new javax.swing.JRadioButton();
        baixaRadioButton = new javax.swing.JRadioButton();
        moderadaRadioButton = new javax.swing.JRadioButton();
        altaRadioButton = new javax.swing.JRadioButton();
        origemComboBox = new javax.swing.JComboBox();
        especialização_plantaTabbedPane = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar Planta");
        setLocation(new java.awt.Point(0, 0));
        setMinimumSize(new java.awt.Dimension(635, 393));
        setPreferredSize(new java.awt.Dimension(470, 220));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        PlantasCadastradasLabel.setText("Plantas Cadastradas");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 3);
        getContentPane().add(PlantasCadastradasLabel, gridBagConstraints);

        plantas_cadastradasComboBox.setModel(new javax.swing.DefaultComboBoxModel(plantas_cadastradas));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 16;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 108);
        getContentPane().add(plantas_cadastradasComboBox, gridBagConstraints);

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
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 149);
        getContentPane().add(nomeTextField, gridBagConstraints);

        ToxicidadeLabel.setText("Toxicidade");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(7, 3, 9, 3);
        getContentPane().add(ToxicidadeLabel, gridBagConstraints);

        OrigemLabel.setText("Origem");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(2, 3, 0, 3);
        getContentPane().add(OrigemLabel, gridBagConstraints);

        inserirPlanta.setText("Inserir");
        inserirPlanta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inserirPlanta(evt);
            }
        });
        comandosPanel.add(inserirPlanta);

        removerPlanta.setText("Remover");
        removerPlanta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerPlanta(evt);
            }
        });
        comandosPanel.add(removerPlanta);

        consultarPlanta.setText("Consultar");
        consultarPlanta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarPlanta(evt);
            }
        });
        comandosPanel.add(consultarPlanta);

        alterarPlanta.setText("Alterar");
        alterarPlanta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterarPlanta(evt);
            }
        });
        comandosPanel.add(alterarPlanta);

        limparButton.setText("Limpar");
        limparButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparCampos(evt);
            }
        });
        comandosPanel.add(limparButton);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 115, 0, 0);
        getContentPane().add(comandosPanel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new java.awt.Insets(8, 8, 8, 8);
        getContentPane().add(Espaçamento, gridBagConstraints);

        alturaMaximaCmLabel.setText("Altura Máxima (cm)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 3);
        getContentPane().add(alturaMaximaCmLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 1, 0, 245);
        getContentPane().add(alturaMaximaCmTextField, gridBagConstraints);

        toxicidadeButtonGroup.add(nãoTóxicaRadioButton);
        nãoTóxicaRadioButton.setText("não tóxica");
        jPanel2.add(nãoTóxicaRadioButton);

        toxicidadeButtonGroup.add(baixaRadioButton);
        baixaRadioButton.setMnemonic('\u0001');
        baixaRadioButton.setText("baixa");
        jPanel2.add(baixaRadioButton);

        toxicidadeButtonGroup.add(moderadaRadioButton);
        moderadaRadioButton.setMnemonic('\u0002');
        moderadaRadioButton.setText("moderada");
        jPanel2.add(moderadaRadioButton);

        toxicidadeButtonGroup.add(altaRadioButton);
        altaRadioButton.setMnemonic('\u0003');
        altaRadioButton.setText("alta");
        jPanel2.add(altaRadioButton);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 11;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 105);
        getContentPane().add(jPanel2, gridBagConstraints);

        origemComboBox.setModel(new DefaultComboBoxModel (Origem.values()));
        origemComboBox.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(3, 0, 4, 0);
        getContentPane().add(origemComboBox, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        getContentPane().add(especialização_plantaTabbedPane, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

       private void selecionarToxicidadeRadioButton(int índice_toxicidade) {
        switch(índice_toxicidade) {
            case 0: nãoTóxicaRadioButton.setSelected(true);
                    break;
            case 1: baixaRadioButton.setSelected(true);
                    break;
            case 2: moderadaRadioButton.setSelected(true);
                    break;
            case 3: altaRadioButton.setSelected(true);
        }
 }
    
    private void consultarPlanta(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarPlanta
        Planta visão = (Planta) plantas_cadastradasComboBox.getSelectedItem();
        Planta planta = null;
        String nome = "";
        String mensagem_erro = null;

        if (visão != null) {
            nome = visão.getNome();
            planta = Planta.buscarPlanta(nome);
            if (planta == null) mensagem_erro = "Planta não cadastrada";
        } else mensagem_erro = "Nenhuma planta selecionada";

        if (mensagem_erro == null) {
            nomeTextField.setText(planta.getNome());
            alturaMaximaCmTextField.setText(String.valueOf(planta.getAlturaMaximaCm()));
            selecionarToxicidadeRadioButton(planta.getToxicidade().ordinal());
            origemComboBox.setSelectedItem(planta.getOrigem());
            
            if (planta instanceof PlantaMedicinal) {

                especialização_plantaTabbedPane.setSelectedIndex(0);
                PlantaMedicinal planta_medicinal = (PlantaMedicinal) planta;
                planta_medicinalPainel.setSelectedParteUtilizada(planta_medicinal.getParteUtilizada().ordinal());
                planta_medicinalPainel.setSelectedPropriedadeTerapeutica(planta_medicinal.getPropriedadeTerapeutica().ordinal());

            } else if (planta instanceof PlantaTóxica) {

                especialização_plantaTabbedPane.setSelectedIndex(1);
                PlantaTóxica planta_tóxica = (PlantaTóxica) planta;
                planta_tóxicaPainel.setSelectedCompostoTóxico(planta_tóxica.getCompostoTóxico().ordinal());
                planta_tóxicaPainel.setSelectedEfeitoColateral(planta_tóxica.getEfeitoColateral().ordinal());
            }            
            
        } else informarErro(mensagem_erro);
    }//GEN-LAST:event_consultarPlanta

@SuppressWarnings({ "rawtypes" })

    private void removerPlanta(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerPlanta
        Planta visão = (Planta) plantas_cadastradasComboBox.getSelectedItem();
        String mensagem_erro = null;

        if (visão != null) mensagem_erro = controlador.removerPlanta(visão.getNome());
        else mensagem_erro = "Nenhuma planta selecionada";

        if (mensagem_erro == null) {
            plantas_cadastradasComboBox.removeItem(visão);
           limparCampos(null);
        } else informarErro(mensagem_erro);
    }//GEN-LAST:event_removerPlanta
    
    private void alterarPlanta(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterarPlanta
        Planta planta = obterPlantaInformada();
        String mensagen_erro = null;

        if (planta != null) mensagen_erro = controlador.alterarPlanta(planta);
        else mensagen_erro = "Algum atributo de planta não foi informado";

        if (mensagen_erro == null) {
            Planta visão = (Planta) plantas_cadastradasComboBox.getSelectedItem();

            if (visão != null) {
                visão.setToxicidade(planta.getToxicidade());
                if(planta instanceof PlantaMedicinal){
                    PlantaMedicinal planta_medicinal = (PlantaMedicinal) planta;
                    PlantaMedicinal visão_medicinal = (PlantaMedicinal) visão;
                    visão_medicinal.setParteUtilizada(planta_medicinal.getParteUtilizada());
                }else if (planta instanceof PlantaTóxica){
                    PlantaTóxica planta_tóxica = (PlantaTóxica) planta;
                    PlantaTóxica visão_tóxica = (PlantaTóxica) visão;
                    visão_tóxica.setCompostoTóxico(planta_tóxica.getCompostoTóxico());
                }
                plantas_cadastradasComboBox.updateUI();
            }
        } else informarErro(mensagen_erro);
    }//GEN-LAST:event_alterarPlanta

    private void limparCampos(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparCampos
        nomeTextField.setText("");
        alturaMaximaCmTextField.setText("");
        toxicidadeButtonGroup.clearSelection();
        origemComboBox.setSelectedIndex(-1);
        planta_medicinalPainel.limparCampos();
        planta_tóxicaPainel.limparCampos();
        
    }//GEN-LAST:event_limparCampos

    private void inserirPlanta(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inserirPlanta
        Planta planta = obterPlantaInformada();
        String mensagem_erro = null;
        if (planta != null) mensagem_erro = controlador.inserirPlanta(planta);
        else mensagem_erro = "Algum atributo de planta não foi informado";
        if (mensagem_erro == null){
            Planta visão = planta.getVisão();
            plantas_cadastradasComboBox.addItem(visão);
            plantas_cadastradasComboBox.setSelectedItem(visão);
        }else informarErro (mensagem_erro);
    }//GEN-LAST:event_inserirPlanta
 
    private Planta obterPlantaInformada() {
        String nome = nomeTextField.getText();
        if (nome.isEmpty()) return null;
        
        String altura_maxima_cm__str = alturaMaximaCmTextField.getText();
        if (altura_maxima_cm__str.isEmpty()) return null;
        int altura_maxima_cm = Integer.parseInt(altura_maxima_cm__str);
        
        Toxicidade toxicidade = null;
        if (toxicidadeButtonGroup.getSelection() != null){
            toxicidade = Toxicidade.values()[toxicidadeButtonGroup.getSelection().getMnemonic()];
        }else return null;
        
        Origem origem = null;
        if (origemComboBox.getSelectedItem() != null){
            origem = (Origem)origemComboBox.getSelectedItem();
        }else return null;
        Planta planta = null;
        int índice_aba_selecionada = especialização_plantaTabbedPane.getSelectedIndex();
        switch (índice_aba_selecionada) {
            case 0: 
                ParteUtilizada parte_utilizada 
                    = planta_medicinalPainel.getSelectedParteUtilizada();
                if (parte_utilizada == null) return null;
                
                PropriedadeTerapeutica propriedade_terapeutica
                    = planta_medicinalPainel.getSelectedPropriedadeTerapeutica();
                if (propriedade_terapeutica == null) return null;

                planta = new PlantaMedicinal (nome, altura_maxima_cm, toxicidade, origem, parte_utilizada, propriedade_terapeutica);
                break;

            case 1: 
                CompostoTóxico composto_tóxico 
                    = planta_tóxicaPainel.getSelectedCompostoTóxico();
                if (composto_tóxico == null) return null;

                EfeitoColateral efeito_colateral 
                    = planta_tóxicaPainel.getSelectedEfeitoColateral();
                if (efeito_colateral == null) return null;

                planta = new PlantaTóxica (nome, altura_maxima_cm, toxicidade, origem, composto_tóxico, efeito_colateral);
                break;
        }
        return planta;
    }
    
    private void informarErro(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Espaçamento;
    private javax.swing.JLabel NomeLabel;
    private javax.swing.JLabel OrigemLabel;
    private javax.swing.JLabel PlantasCadastradasLabel;
    private javax.swing.JLabel ToxicidadeLabel;
    private javax.swing.JRadioButton altaRadioButton;
    private javax.swing.JButton alterarPlanta;
    private javax.swing.JLabel alturaMaximaCmLabel;
    private javax.swing.JTextField alturaMaximaCmTextField;
    private javax.swing.JRadioButton baixaRadioButton;
    private javax.swing.JPanel comandosPanel;
    private javax.swing.JButton consultarPlanta;
    private javax.swing.JTabbedPane especialização_plantaTabbedPane;
    private javax.swing.JButton inserirPlanta;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton limparButton;
    private javax.swing.JRadioButton moderadaRadioButton;
    private javax.swing.JTextField nomeTextField;
    private javax.swing.JRadioButton nãoTóxicaRadioButton;
    private javax.swing.JComboBox origemComboBox;
    private javax.swing.JComboBox plantas_cadastradasComboBox;
    private javax.swing.JButton removerPlanta;
    private javax.swing.ButtonGroup toxicidadeButtonGroup;
    // End of variables declaration//GEN-END:variables
}