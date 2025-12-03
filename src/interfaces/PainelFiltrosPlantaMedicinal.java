
package interfaces;

import entidades.PlantaMedicinal.ParteUtilizada;

public class PainelFiltrosPlantaMedicinal extends javax.swing.JPanel {

    
    public PainelFiltrosPlantaMedicinal() {
        initComponents();
    }
    
    public void limparFiltros() {
        parte_utilizadaButtonGroup.clearSelection();
    }
    
    public ParteUtilizada getSelectedParteUtilizada() {
        ParteUtilizada parte_utilizada = null;
        if (parte_utilizadaButtonGroup.getSelection()!= null){
            parte_utilizada= ParteUtilizada.values()
                [parte_utilizadaButtonGroup.getSelection().getMnemonic()];
        }
        return parte_utilizada;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        parte_utilizadaButtonGroup = new javax.swing.ButtonGroup();
        propriedadeTerapeuticaButtonGroup = new javax.swing.ButtonGroup();
        parte_utilizadajLabel = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        floresRadioButton = new javax.swing.JRadioButton();
        raízesRadioButton = new javax.swing.JRadioButton();
        folhasRadioButton = new javax.swing.JRadioButton();

        setLayout(new java.awt.GridBagLayout());

        parte_utilizadajLabel.setText("Parte Utilizada");
        add(parte_utilizadajLabel, new java.awt.GridBagConstraints());

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
    private javax.swing.JRadioButton floresRadioButton;
    private javax.swing.JRadioButton folhasRadioButton;
    private javax.swing.JPanel jPanel7;
    private javax.swing.ButtonGroup parte_utilizadaButtonGroup;
    private javax.swing.JLabel parte_utilizadajLabel;
    private javax.swing.ButtonGroup propriedadeTerapeuticaButtonGroup;
    private javax.swing.JRadioButton raízesRadioButton;
    // End of variables declaration//GEN-END:variables
}
