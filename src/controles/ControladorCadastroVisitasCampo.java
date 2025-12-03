package controles;

import entidades.VisitaCampo;
import interfaces.JanelaCadastroRegiões;
import interfaces.JanelaCadastroVisitasCampo;


public class ControladorCadastroVisitasCampo {

    public ControladorCadastroVisitasCampo() {}

    public ControladorCadastroVisitasCampo(JanelaCadastroRegiões janela_cadastro_regiões,
            int sequencial_região) {
        new JanelaCadastroVisitasCampo(this, janela_cadastro_regiões, sequencial_região)
                .setVisible(true);
    }

    public String inserirVisitaCampo (VisitaCampo visita_Campo) {
        boolean existe_visita_Campo = VisitaCampo.existeVisitaCampo
            (visita_Campo.getRegião().getSequencial(), visita_Campo.getPlanta().getNome());
        if (!existe_visita_Campo) return VisitaCampo.inserirVisitaCampo (visita_Campo);
        else return "Sequencial de visita de campo já cadastrado";
    }
    
    public String removerVisitaCampo (int sequencial) {
        boolean existe_visita_Campo = VisitaCampo.existeVisitaCampo (sequencial);
        if (existe_visita_Campo) return VisitaCampo.removerVisitaCampo (sequencial);
        else return "Não existe visita de campo com este sequencial";
    }
}
