package controles;

import entidades.Região;
import interfaces.JanelaCadastroRegiões;

public class ControladorCadastroRegiões {
    
    public ControladorCadastroRegiões() {
        new JanelaCadastroRegiões(this).setVisible(true);
    }
     
   public String inserirRegião (Região região) {
        if (!Região.existeRegiãoMesmosAtributos(região)) {
            return Região.inserirRegião(região);
        } else {
            return "Já existe uma região com os mesmos atributos";
        }
    }

    public String alterarRegião(Região região) {
        Região região1 = Região.buscarRegião(região.getSequencial());
        if (região1 != null) return Região.alterarRegião(região);
        else return "Ecossistema da região não cadastrado";
    }

    public String removerRegião(int sequencial) {
        Região região1 = Região.buscarRegião(sequencial);
        if (região1 != null) return Região.removerRegião(sequencial);
        else return "Região não cadastrada";
    }
}