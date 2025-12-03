
package entidades;

public class PlantaTóxica extends Planta {
    
    public enum CompostoTóxico {alcalóides, glicosídeos, saponinas};
    public enum EfeitoColateral {náusea, paralisia, alucinação};

    private CompostoTóxico composto_tóxico;
    private EfeitoColateral efeito_colateral;

    public CompostoTóxico getCompostoTóxico() { return composto_tóxico; }
    public EfeitoColateral getEfeitoColateral() { return efeito_colateral; }
    public void setCompostoTóxico(CompostoTóxico composto_tóxico) {
        this.composto_tóxico = composto_tóxico;
    }
    
    public PlantaTóxica (String nome, Toxicidade toxicidade, CompostoTóxico composto_tóxico){
        super(nome, toxicidade);
        this.composto_tóxico = composto_tóxico;
    }
    public PlantaTóxica (String nome, int altura_maxima_cm, Toxicidade toxicidade, Origem origem, 
        CompostoTóxico composto_tóxico, EfeitoColateral efeito_colateral){
        super(nome, altura_maxima_cm, toxicidade, origem);
        this.composto_tóxico = composto_tóxico;
        this.efeito_colateral = efeito_colateral;
    }

    public PlantaTóxica getVisão(){
        return new PlantaTóxica (getNome(), getToxicidade(), composto_tóxico);
    }

    public String toString (){
        String str = "[" + getNome() + "] " + getToxicidade();
        if (composto_tóxico != null) str += " - Planta Tóxica: " + composto_tóxico;
        return str;
    }
    
    
}
