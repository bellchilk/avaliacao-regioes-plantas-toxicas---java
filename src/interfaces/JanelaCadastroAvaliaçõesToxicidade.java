package interfaces;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import controles.ControladorCadastroAvaliaçõesToxicidade;
import entidades.AvaliaçãoToxicidade;
import entidades.Botânico;
import entidades.Região;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class JanelaCadastroAvaliaçõesToxicidade extends javax.swing.JFrame {
 ControladorCadastroAvaliaçõesToxicidade controlador;
    DefaultListModel modelo_lista_avaliações_toxicidade;
    Botânico[] botânicos_cadastrados;
    Região[] regiões_cadastradas;

   
    public JanelaCadastroAvaliaçõesToxicidade(ControladorCadastroAvaliaçõesToxicidade controlador) {
        this.controlador = controlador;
        botânicos_cadastrados = Botânico.getVisões();
        regiões_cadastradas = Região.getVisões();
        initComponents();
        modelo_lista_avaliações_toxicidade = (DefaultListModel)avaliações_toxicidade_cadastradasList.getModel();
        inicializarListaAvaliaçõesToxicidade();
        limparCampos(null);
    }
    
    private Botânico getVisãoBotânicoSelecionado(AvaliaçãoToxicidade avaliação_toxicidade){
        String chave_botânico = avaliação_toxicidade.getBotânico().getNome();
        for (Botânico visão_botânico: botânicos_cadastrados){
            if (visão_botânico.getNome().equals(chave_botânico)) 
                return visão_botânico;
        }
        return null;
    }
    
    private Região getVisãoRegiãoSelecionada(AvaliaçãoToxicidade avaliação_toxicidade) {
        int chave_região = avaliação_toxicidade.getRegião().getSequencial();
        for (Região visão_região : regiões_cadastradas) {
            if (visão_região.getSequencial()== chave_região) {
                return visão_região;
            }
        }
        return null;
    }
    
    public void inicializarListaAvaliaçõesToxicidade (){
        modelo_lista_avaliações_toxicidade.clear();
        AvaliaçãoToxicidade[] avaliações_toxicidade = AvaliaçãoToxicidade.getVisões();
        for (AvaliaçãoToxicidade avaliação_toxicidade : avaliações_toxicidade) {
            modelo_lista_avaliações_toxicidade.addElement(avaliação_toxicidade);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        avaliações_toxicidade_cadastradasList = new javax.swing.JList();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        regiões_cadastradasComboBox = new javax.swing.JComboBox<>();
        botânicos_cadastradosComboBox = new javax.swing.JComboBox<>();
        n_plantas_baixa_toxicidadeTextField = new javax.swing.JTextField();
        n_plantas_alta_toxicidadeTextField = new javax.swing.JTextField();
        comandosPanel = new javax.swing.JPanel();
        inserirButton = new javax.swing.JButton();
        consultarButton = new javax.swing.JButton();
        removerButton = new javax.swing.JButton();
        alterarButton = new javax.swing.JButton();
        limparButton = new javax.swing.JButton();
        sequencialTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro Avaliações de Toxicidade");
        setMinimumSize(new java.awt.Dimension(700, 483));

        jLabel1.setText("Avaliações de Toxicidade Cadastradas");

        avaliações_toxicidade_cadastradasList.setModel(new DefaultListModel());
        jScrollPane1.setViewportView(avaliações_toxicidade_cadastradasList);

        jLabel2.setText("Ordem da Avaliação de Toxicidade");

        jLabel3.setText("Número de Plantas com Baixa Toxicidade");

        jLabel4.setText("Número de Plantas com Alta Toxicidade");

        jLabel5.setText("Regiões Cadastrados");

        jLabel6.setText("Botânicos Cadastrados");

        regiões_cadastradasComboBox.setModel(new javax.swing.DefaultComboBoxModel(regiões_cadastradas));
        regiões_cadastradasComboBox.setSelectedItem(new javax.swing.DefaultComboBoxModel(regiões_cadastradas));
        regiões_cadastradasComboBox.setToolTipText("");

        botânicos_cadastradosComboBox.setModel(new javax.swing.DefaultComboBoxModel(botânicos_cadastrados));
        botânicos_cadastradosComboBox.setSelectedItem(new javax.swing.DefaultComboBoxModel(botânicos_cadastrados));

        inserirButton.setText("Inserir");
        inserirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inserirAvaliaçãoToxicidade(evt);
            }
        });
        comandosPanel.add(inserirButton);

        consultarButton.setText("Consultar");
        consultarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarAvaliaçãoToxicidade(evt);
            }
        });
        comandosPanel.add(consultarButton);

        removerButton.setText("Remover");
        removerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerAvaliaçãoToxicidade(evt);
            }
        });
        comandosPanel.add(removerButton);

        alterarButton.setText("Alterar");
        alterarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterarAvaliaçãoToxicidade(evt);
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

        sequencialTextField.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(n_plantas_baixa_toxicidadeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(n_plantas_alta_toxicidadeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(regiões_cadastradasComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botânicos_cadastradosComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sequencialTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(156, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 25, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(19, 19, 19)
                            .addComponent(jLabel1)
                            .addGap(4, 4, 4)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(35, 35, 35)
                            .addComponent(jLabel2))
                        .addComponent(jLabel3)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(226, 226, 226)
                            .addComponent(comandosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(0, 26, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addComponent(sequencialTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botânicos_cadastradosComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(regiões_cadastradasComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(n_plantas_alta_toxicidadeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addComponent(n_plantas_baixa_toxicidadeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(93, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 52, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(52, 52, 52)
                            .addComponent(jLabel1))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(16, 16, 16)
                    .addComponent(jLabel2)
                    .addGap(160, 160, 160)
                    .addComponent(jLabel3)
                    .addGap(12, 12, 12)
                    .addComponent(comandosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 53, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inserirAvaliaçãoToxicidade(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inserirAvaliaçãoToxicidade
        AvaliaçãoToxicidade avaliação_toxicidade = obterAvaliaçãoToxicidadeInformada();
        String mensagem_erro = null;
        if (avaliação_toxicidade != null) {
            mensagem_erro = controlador.inserirAvaliaçãoToxicidade(avaliação_toxicidade);
        } else {
            mensagem_erro = "Algum atributo da avaliação de toxicidade não foi informado";
        }
        if (mensagem_erro == null) {
            int sequencial = AvaliaçãoToxicidade.últimoSequencial();
            avaliação_toxicidade.setSequencial(sequencial);
            modelo_lista_avaliações_toxicidade.addElement(avaliação_toxicidade.getVisão());
            avaliações_toxicidade_cadastradasList.setSelectedIndex(modelo_lista_avaliações_toxicidade.size() - 1);
        } else {
            informarErro(mensagem_erro);
        }

    }//GEN-LAST:event_inserirAvaliaçãoToxicidade

    private void consultarAvaliaçãoToxicidade(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarAvaliaçãoToxicidade
        AvaliaçãoToxicidade visão_avaliação_toxicidade = (AvaliaçãoToxicidade) avaliações_toxicidade_cadastradasList.getSelectedValue();
        AvaliaçãoToxicidade avaliação_toxicidade = null;
        String mensagem_erro = null;
        if (visão_avaliação_toxicidade != null) {
            avaliação_toxicidade = AvaliaçãoToxicidade.buscarAvaliaçãoToxicidade(visão_avaliação_toxicidade.getSequencial());
            if (avaliação_toxicidade == null) {
                mensagem_erro = "Avaliação de Toxicidade não cadastrada";
            }
        } else {
            mensagem_erro = "Nenhuma avaliação de toxicidade selecionada";
        }
        if (mensagem_erro == null) {
            sequencialTextField.setText(avaliação_toxicidade.getSequencial() + "");
            botânicos_cadastradosComboBox.setSelectedItem(getVisãoBotânicoSelecionado(avaliação_toxicidade));
            regiões_cadastradasComboBox.setSelectedItem(getVisãoRegiãoSelecionada(avaliação_toxicidade));
            n_plantas_alta_toxicidadeTextField.setText(String.valueOf(avaliação_toxicidade.getN_plantas_alta_toxicidade()));
            n_plantas_baixa_toxicidadeTextField.setText(String.valueOf(avaliação_toxicidade.getN_plantas_baixa_toxicidade()));

        } else {
            informarErro(mensagem_erro);
        }
    }//GEN-LAST:event_consultarAvaliaçãoToxicidade

    private void removerAvaliaçãoToxicidade(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerAvaliaçãoToxicidade
        AvaliaçãoToxicidade visão = (AvaliaçãoToxicidade) avaliações_toxicidade_cadastradasList.getSelectedValue();
        String mensagem_erro = null;

        if (visão != null) mensagem_erro = controlador.removerAvaliaçãoToxicidade(visão.getSequencial());
        else mensagem_erro = "Nenhuma avaliação de toxicidade selecionada";

        if (mensagem_erro == null) {
            modelo_lista_avaliações_toxicidade.removeElement(visão);
            limparCampos(null);
        } else informarErro(mensagem_erro);
    }//GEN-LAST:event_removerAvaliaçãoToxicidade

    private void alterarAvaliaçãoToxicidade(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterarAvaliaçãoToxicidade
        AvaliaçãoToxicidade avaliação_toxicidade = obterAvaliaçãoToxicidadeInformada();
        String mensagem_erro = null;
        if (avaliação_toxicidade != null) {
            mensagem_erro = controlador.alterarAvaliaçãoToxicidade(avaliação_toxicidade);
        } else {
            mensagem_erro = "Algum atributo da avaliação de toxicidade não foi informado";
        }
        if (mensagem_erro != null) {
            informarErro(mensagem_erro);
        }
    }//GEN-LAST:event_alterarAvaliaçãoToxicidade

    private void limparCampos(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparCampos
        sequencialTextField.setText("");
        botânicos_cadastradosComboBox.setSelectedIndex(-1);
        regiões_cadastradasComboBox.setSelectedIndex(-1);
        n_plantas_alta_toxicidadeTextField.setText("");
        n_plantas_baixa_toxicidadeTextField.setText("");
    }//GEN-LAST:event_limparCampos

    private AvaliaçãoToxicidade obterAvaliaçãoToxicidadeInformada(){
        String sequencial_str = sequencialTextField.getText();
        int sequencial = 0;
        if (!sequencial_str.isEmpty()) sequencial = Integer.parseInt(sequencial_str);

        Botânico visão_botânico = (Botânico) botânicos_cadastradosComboBox.getSelectedItem();
        if (visão_botânico == null) return null;

        Região visão_região = (Região) regiões_cadastradasComboBox.getSelectedItem();
        if (visão_região == null) return null; 

        String n_plantas_alta_toxicidade_str = n_plantas_alta_toxicidadeTextField.getText();
        int n_plantas_alta_toxicidade = -1;
        if (!n_plantas_alta_toxicidade_str.isEmpty()) n_plantas_alta_toxicidade = Integer.parseInt(n_plantas_alta_toxicidade_str);

        String n_plantas_baixa_toxicidade_str = n_plantas_baixa_toxicidadeTextField.getText();
        int n_plantas_baixa_toxicidade = -1;
        if (!n_plantas_baixa_toxicidade_str.isEmpty()) n_plantas_baixa_toxicidade = Integer.parseInt(n_plantas_baixa_toxicidade_str);
        
        return new AvaliaçãoToxicidade(sequencial, visão_botânico, visão_região, n_plantas_alta_toxicidade, n_plantas_baixa_toxicidade);                
    }
    
    private void informarErro(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton alterarButton;
    private javax.swing.JList avaliações_toxicidade_cadastradasList;
    private javax.swing.JComboBox<String> botânicos_cadastradosComboBox;
    private javax.swing.JPanel comandosPanel;
    private javax.swing.JButton consultarButton;
    private javax.swing.JButton inserirButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton limparButton;
    private javax.swing.JTextField n_plantas_alta_toxicidadeTextField;
    private javax.swing.JTextField n_plantas_baixa_toxicidadeTextField;
    private javax.swing.JComboBox<String> regiões_cadastradasComboBox;
    private javax.swing.JButton removerButton;
    private javax.swing.JTextField sequencialTextField;
    // End of variables declaration//GEN-END:variables
}
