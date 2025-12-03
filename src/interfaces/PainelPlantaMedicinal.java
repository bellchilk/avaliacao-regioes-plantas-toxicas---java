
package interfaces;

import entidades.PlantaMedicinal.ParteUtilizada;
import entidades.PlantaMedicinal.PropriedadeTerapeutica;

public class PainelPlantaMedicinal extends javax.swing.JPanel {

    
    public PainelPlantaMedicinal() {
        initComponents();
    }
    
      public ParteUtilizada getSelectedParteUtilizada() {
        ParteUtilizada parte_utilizada = null;
        if (parte_utilizadaButtonGroup.getSelection()!= null) {
            parte_utilizada= ParteUtilizada.values()[parte_utilizadaButtonGroup.getSelection().getMnemonic()];
        }
        return parte_utilizada;
    }

    public void setSelectedParteUtilizada(int índice_parte_utilizada) {
        switch(índice_parte_utilizada){
            case 0: folhasRadioButton.setSelected(true); break;
            case 1: raízesRadioButton.setSelected(true); break;
            case 2: floresRadioButton.setSelected(true); break;
        }
    }

    public PropriedadeTerapeutica getSelectedPropriedadeTerapeutica() {
        PropriedadeTerapeutica propriedade_terapeutica = null;
        if (propriedadeTerapeuticaButtonGroup.getSelection() != null){
            propriedade_terapeutica = PropriedadeTerapeutica.values()[propriedadeTerapeuticaButtonGroup.getSelection().getMnemonic()];
        }
        return propriedade_terapeutica;
    }

    public void setSelectedPropriedadeTerapeutica(int índice_propriedade_terapeutica) { 
      switch(índice_propriedade_terapeutica){
            case 0: anti_inflamatórioRadioButton.setSelected(true); break;
            case 1: analgésicaRadioButton.setSelected(true); break;
            case 2: digestivaRadioButton.setSelected(true);
        }  
    }
    
    public void limparCampos() {
        parte_utilizadaButtonGroup.clearSelection();
        propriedadeTerapeuticaButtonGroup.clearSelection();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        parte_utilizadaButtonGroup = new javax.swing.ButtonGroup();
        propriedadeTerapeuticaButtonGroup = new javax.swing.ButtonGroup();
        propriedade_terapeuticajLabel = new javax.swing.JLabel();
        parte_utilizadajLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        analgésicaRadioButton = new javax.swing.JRadioButton();
        digestivaRadioButton = new javax.swing.JRadioButton();
        anti_inflamatórioRadioButton = new javax.swing.JRadioButton();
        jPanel7 = new javax.swing.JPanel();
        floresRadioButton = new javax.swing.JRadioButton();
        raízesRadioButton = new javax.swing.JRadioButton();
        folhasRadioButton = new javax.swing.JRadioButton();

        setLayout(new java.awt.GridBagLayout());

        propriedade_terapeuticajLabel.setText("Proriedade Terapeutica");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(8, 0, 0, 0);
        add(propriedade_terapeuticajLabel, gridBagConstraints);

        parte_utilizadajLabel.setText("Parte Utilizada");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(18, 4, 0, 0);
        add(parte_utilizadajLabel, gridBagConstraints);

        propriedadeTerapeuticaButtonGroup.add(analgésicaRadioButton);
        analgésicaRadioButton.setMnemonic('\u0001');
        analgésicaRadioButton.setText("analgésica");

        propriedadeTerapeuticaButtonGroup.add(digestivaRadioButton);
        digestivaRadioButton.setMnemonic('\u0002');
        digestivaRadioButton.setText("digestiva");

        propriedadeTerapeuticaButtonGroup.add(anti_inflamatórioRadioButton);
        anti_inflamatórioRadioButton.setText("anti-inflamatória");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(anti_inflamatórioRadioButton)
                .addGap(18, 18, 18)
                .addComponent(analgésicaRadioButton)
                .addGap(18, 18, 18)
                .addComponent(digestivaRadioButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(anti_inflamatórioRadioButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(analgésicaRadioButton)
                    .addComponent(digestivaRadioButton))
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 7, 0, 0);
        add(jPanel1, gridBagConstraints);

        parte_utilizadaButtonGroup.add(floresRadioButton);
        floresRadioButton.setMnemonic('\u0002');
        floresRadioButton.setText("flores");

        parte_utilizadaButtonGroup.add(raízesRadioButton);
        raízesRadioButton.setMnemonic('\u0001');
        raízesRadioButton.setText("raízes");

        parte_utilizadaButtonGroup.add(folhasRadioButton);
        folhasRadioButton.setText("folhas");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(folhasRadioButton)
                .addGap(18, 18, 18)
                .addComponent(raízesRadioButton)
                .addGap(18, 18, 18)
                .addComponent(floresRadioButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(raízesRadioButton)
                    .addComponent(folhasRadioButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(floresRadioButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 7, 0, 0);
        add(jPanel7, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton analgésicaRadioButton;
    private javax.swing.JRadioButton anti_inflamatórioRadioButton;
    private javax.swing.JRadioButton digestivaRadioButton;
    private javax.swing.JRadioButton floresRadioButton;
    private javax.swing.JRadioButton folhasRadioButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel7;
    private javax.swing.ButtonGroup parte_utilizadaButtonGroup;
    private javax.swing.JLabel parte_utilizadajLabel;
    private javax.swing.ButtonGroup propriedadeTerapeuticaButtonGroup;
    private javax.swing.JLabel propriedade_terapeuticajLabel;
    private javax.swing.JRadioButton raízesRadioButton;
    // End of variables declaration//GEN-END:variables
}
