package controles;

import entidades.Botânico;
import interfaces.JanelaCadastroBotânicos;

public class ControladorCadastroBotânicos {

    public ControladorCadastroBotânicos() {
        new JanelaCadastroBotânicos(this).setVisible(true);
    }

    public String inserirBotanico(final Botânico botanico) {
       final Botânico botanico1 = Botânico.buscarBotânico(botanico.getNome());
        
        if (botanico1 == null) return Botânico.inserirBotânico(botanico);
        else return "Nome de botânico já cadastrado";
    }

    public String alterarBotanico(Botânico botanico) {
        Botânico botanico1 = Botânico.buscarBotânico(botanico.getNome());
        if (botanico1 != null) return Botânico.alterarBotânico(botanico);
        else return "Botânico não cadastrado";
    }

    public String removerBotanico(String nome) {
        Botânico botanico1 = Botânico.buscarBotânico(nome);
        if (botanico1 != null) return Botânico.removerBotânico(nome);
        else return "Botânico não cadastrado";
    }
}
