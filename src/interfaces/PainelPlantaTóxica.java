package interfaces;

import entidades.PlantaTóxica.CompostoTóxico;
import entidades.PlantaTóxica.EfeitoColateral;

public class PainelPlantaTóxica extends javax.swing.JPanel {
    
    public PainelPlantaTóxica() {
        initComponents();
    }

    public void limparFiltros() {
        composto_tóxicoButtonGroup.clearSelection();
    }
    
   public CompostoTóxico getSelectedCompostoTóxico() {
        CompostoTóxico composto_tóxico = null;
        if (composto_tóxicoButtonGroup.getSelection()!= null){
            composto_tóxico= CompostoTóxico.values()[composto_tóxicoButtonGroup.getSelection().getMnemonic()];
        }
        return composto_tóxico;
    }

    public void setSelectedCompostoTóxico(int índice_composto_tóxico) {
        switch(índice_composto_tóxico){
            case 0: alcalóidesRadioButton.setSelected(true); break;
            case 1: glicosídeosRadioButton.setSelected(true); break;
            case 2: saponinasRadioButton.setSelected(true);
        }
    }

    public EfeitoColateral getSelectedEfeitoColateral() {
        EfeitoColateral efeito_colateral = null;
        if (efeitoColateralButtonGroup.getSelection() != null) {
            efeito_colateral = EfeitoColateral.values()[efeitoColateralButtonGroup.getSelection().getMnemonic()];
        }
        return efeito_colateral;
    }

    public void setSelectedEfeitoColateral(int índice_efeito_colateral) { 
      switch(índice_efeito_colateral){
            case 0: náuseaRadioButton.setSelected(true); break;
            case 1: paralisiaRadioButton.setSelected(true); break;
            case 2: alucinaçãoRadioButton.setSelected(true);
        }  
    }
    
    public void limparCampos() {
        composto_tóxicoButtonGroup.clearSelection();
        efeitoColateralButtonGroup.clearSelection();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        composto_tóxicoButtonGroup = new javax.swing.ButtonGroup();
        efeitoColateralButtonGroup = new javax.swing.ButtonGroup();
        composto_tóxicojLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        paralisiaRadioButton = new javax.swing.JRadioButton();
        alucinaçãoRadioButton = new javax.swing.JRadioButton();
        náuseaRadioButton = new javax.swing.JRadioButton();
        jPanel7 = new javax.swing.JPanel();
        saponinasRadioButton = new javax.swing.JRadioButton();
        glicosídeosRadioButton = new javax.swing.JRadioButton();
        alcalóidesRadioButton = new javax.swing.JRadioButton();
        composto_tóxicojLabel1 = new javax.swing.JLabel();

        setLayout(new java.awt.GridBagLayout());

        composto_tóxicojLabel.setText("Composto Tóxico");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        add(composto_tóxicojLabel, gridBagConstraints);

        efeitoColateralButtonGroup.add(paralisiaRadioButton);
        paralisiaRadioButton.setMnemonic('\u0001');
        paralisiaRadioButton.setText("paralisia");

        efeitoColateralButtonGroup.add(alucinaçãoRadioButton);
        alucinaçãoRadioButton.setMnemonic('\u0002');
        alucinaçãoRadioButton.setText("alucinação");

        efeitoColateralButtonGroup.add(náuseaRadioButton);
        náuseaRadioButton.setText("náusea");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(náuseaRadioButton)
                .addGap(18, 18, 18)
                .addComponent(paralisiaRadioButton)
                .addGap(18, 18, 18)
                .addComponent(alucinaçãoRadioButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(náuseaRadioButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(paralisiaRadioButton)
                    .addComponent(alucinaçãoRadioButton))
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 7, 0, 0);
        add(jPanel1, gridBagConstraints);

        composto_tóxicoButtonGroup.add(saponinasRadioButton);
        saponinasRadioButton.setMnemonic('\u0002');
        saponinasRadioButton.setText("saponinas");

        composto_tóxicoButtonGroup.add(glicosídeosRadioButton);
        glicosídeosRadioButton.setMnemonic('\u0001');
        glicosídeosRadioButton.setText("glicosídeos");

        composto_tóxicoButtonGroup.add(alcalóidesRadioButton);
        alcalóidesRadioButton.setText("alcalóides");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(alcalóidesRadioButton)
                .addGap(18, 18, 18)
                .addComponent(glicosídeosRadioButton)
                .addGap(18, 18, 18)
                .addComponent(saponinasRadioButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(glicosídeosRadioButton)
                    .addComponent(alcalóidesRadioButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(saponinasRadioButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 7, 0, 0);
        add(jPanel7, gridBagConstraints);

        composto_tóxicojLabel1.setText("Efeito Colateral");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        add(composto_tóxicojLabel1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton alcalóidesRadioButton;
    private javax.swing.JRadioButton alucinaçãoRadioButton;
    private javax.swing.ButtonGroup composto_tóxicoButtonGroup;
    private javax.swing.JLabel composto_tóxicojLabel;
    private javax.swing.JLabel composto_tóxicojLabel1;
    private javax.swing.ButtonGroup efeitoColateralButtonGroup;
    private javax.swing.JRadioButton glicosídeosRadioButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JRadioButton náuseaRadioButton;
    private javax.swing.JRadioButton paralisiaRadioButton;
    private javax.swing.JRadioButton saponinasRadioButton;
    // End of variables declaration//GEN-END:variables
}
