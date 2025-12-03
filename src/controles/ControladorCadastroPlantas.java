package controles;

import entidades.Planta;
import interfaces.JanelaCadastroPlantas;

public class ControladorCadastroPlantas {

    public ControladorCadastroPlantas() {
        new JanelaCadastroPlantas(this).setVisible(true);
    }

    public String inserirPlanta(final Planta planta) {
        final Planta planta1 = Planta.buscarPlanta(planta.getNome());
        
        if (planta1 == null) return Planta.inserirPlanta(planta);
        else return "Nome de planta já cadastrado";
    }

    public String alterarPlanta(Planta planta) {
        Planta planta1 = Planta.buscarPlanta(planta.getNome());
        if (planta1 != null) return Planta.alterarPlanta(planta);
        else return "Nome de planta não cadastrado";
    }

    public String removerPlanta(String nome) {
        Planta planta1 = Planta.buscarPlanta(nome);
        if (planta1 != null) return Planta.removerPlanta(planta1);
        else return "Nome de planta não cadastrado";
    }
}
