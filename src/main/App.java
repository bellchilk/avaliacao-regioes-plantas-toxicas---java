import javax.swing.SwingUtilities;

import interfaces.JanelaSistema;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new JanelaSistema().setVisible(true));
    }
}