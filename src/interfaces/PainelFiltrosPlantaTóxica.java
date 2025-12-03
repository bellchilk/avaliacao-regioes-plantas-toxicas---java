package interfaces;

import entidades.PlantaTóxica.CompostoTóxico;

public class PainelFiltrosPlantaTóxica extends javax.swing.JPanel {
    
    public PainelFiltrosPlantaTóxica() {
        initComponents();
    }

    public void limparFiltros() {
        composto_tóxicoButtonGroup.clearSelection();
    }
    
   public CompostoTóxico getSelectedCompostoTóxico() {
        CompostoTóxico composto_tóxico = null;
        if (composto_tóxicoButtonGroup.getSelection()!= null){
            composto_tóxico= CompostoTóxico.values()
                [composto_tóxicoButtonGroup.getSelection().getMnemonic()];
        }
        return composto_tóxico;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        composto_tóxicoButtonGroup = new javax.swing.ButtonGroup();
        efeitoColateralButtonGroup = new javax.swing.ButtonGroup();
        composto_tóxicojLabel = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        saponinasRadioButton = new javax.swing.JRadioButton();
        glicosídeosRadioButton = new javax.swing.JRadioButton();
        alcalóidesRadioButton = new javax.swing.JRadioButton();

        setLayout(new java.awt.GridBagLayout());

        composto_tóxicojLabel.setText("Composto Tóxico");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        add(composto_tóxicojLabel, gridBagConstraints);

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
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton alcalóidesRadioButton;
    private javax.swing.ButtonGroup composto_tóxicoButtonGroup;
    private javax.swing.JLabel composto_tóxicojLabel;
    private javax.swing.ButtonGroup efeitoColateralButtonGroup;
    private javax.swing.JRadioButton glicosídeosRadioButton;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JRadioButton saponinasRadioButton;
    // End of variables declaration//GEN-END:variables
}
