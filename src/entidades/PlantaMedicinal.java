
package entidades;

public class PlantaMedicinal extends Planta {
    
    public enum ParteUtilizada {folhas, raízes, flores};
    public enum PropriedadeTerapeutica {anti_inflamatório, analgésica, digestiva};

    private ParteUtilizada parte_utilizada;
    private PropriedadeTerapeutica propriedade_terapeutica;

    public ParteUtilizada getParteUtilizada() { return parte_utilizada; }
    public PropriedadeTerapeutica getPropriedadeTerapeutica() { return propriedade_terapeutica; }
    public void setParteUtilizada(ParteUtilizada parte_utilizada) {
    this.parte_utilizada = parte_utilizada;
    }
    
    public PlantaMedicinal (String nome, Toxicidade toxicidade, ParteUtilizada parte_utilizada){
        super (nome, toxicidade);
        this.parte_utilizada = parte_utilizada;
    }
    
    public PlantaMedicinal (String nome, int altura_maxima_cm, Toxicidade toxicidade, Origem origem, ParteUtilizada parte_utilizada, 
        PropriedadeTerapeutica propriedade_terapeutica){
        super(nome, altura_maxima_cm, toxicidade, origem);
        this.parte_utilizada = parte_utilizada;
        this.propriedade_terapeutica = propriedade_terapeutica;
    }

    public PlantaMedicinal getVisão(){
        return new PlantaMedicinal (getNome(), getToxicidade(), parte_utilizada);
    }

    public String toString (){
        String str = "[" + getNome() + "] " + getToxicidade();
        if (parte_utilizada != null) str += " - Planta Medicinal: " + parte_utilizada;
        return str;
    }
}