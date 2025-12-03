
package controles;

import entidades.AvaliaçãoToxicidade;
import interfaces.JanelaCadastroAvaliaçõesToxicidade;

public class ControladorCadastroAvaliaçõesToxicidade {
    
    
      public ControladorCadastroAvaliaçõesToxicidade() {
        new JanelaCadastroAvaliaçõesToxicidade(this).setVisible(true);
    }
     
    public String inserirAvaliaçãoToxicidade(AvaliaçãoToxicidade avaliação_toxicidade) {
        if (!AvaliaçãoToxicidade.existeAvaliaçãoToxicidade(avaliação_toxicidade.getBotânico().getNome(),
                avaliação_toxicidade.getRegião().getSequencial())) {
            return AvaliaçãoToxicidade.inserirAvaliaçãoToxicidade (avaliação_toxicidade);
        } else {
            return "Avaliação de Toxicidade já cadastrada";
        }
    }
    
    public String alterarAvaliaçãoToxicidade(AvaliaçãoToxicidade avaliação_toxicidade_informada) {
        AvaliaçãoToxicidade avaliação_toxicidade_cadastradas = AvaliaçãoToxicidade.buscarAvaliaçãoToxicidade(avaliação_toxicidade_informada.getSequencial());
        if ((avaliação_toxicidade_informada.getBotânico().getNome().equals(avaliação_toxicidade_cadastradas.getBotânico().getNome()))
                && (avaliação_toxicidade_informada.getRegião().getSequencial()
                == avaliação_toxicidade_cadastradas.getRegião().getSequencial())) {
            return AvaliaçãoToxicidade.alterarAvaliaçãoToxicidade(avaliação_toxicidade_informada);
        } else {
            return "Alteração não permitida : chave do botânico e/ou da região foram alteradas";
        }
    }
    
    public String removerAvaliaçãoToxicidade(int sequencial) {
        if (AvaliaçãoToxicidade.existeAvaliaçãoToxicidade(sequencial)) {
            return AvaliaçãoToxicidade.removerAvaliaçãoToxicidade(sequencial);
        } else {
            return "Sequencial não corresponde a nenhuma reserva cadastrada";
        }
    }

    
}
