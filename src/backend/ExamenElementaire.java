import java.util.ArrayList;

public abstract class ExamenElementaire {
    private String nomExamen;
    protected ArrayList<String> parametrePossible;
    protected ArrayList<String> parametreChoisis;

    public ExamenElementaire() {
        parametrePossible = new ArrayList<>();
        parametreChoisis = new ArrayList<>();
    }

    @Override
    public String getNomExamen() {
        return nomExamen;
    }

    public void setNomExamen(String nomExamen) {
        this.nomExamen = nomExamen;
    }


    public void addParametre(String choisit) {
        if (parametrePossible.contains(choisit)) {
            parametreChoisis.add(choisit);
        } 
    }
}
