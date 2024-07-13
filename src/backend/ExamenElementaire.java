package backend;
import java.util.ArrayList;


public abstract class ExamenElementaire implements Examen {
    private String nomExamen;
    protected ArrayList<String> parametrePossible;
    protected ArrayList<String> parametreChoisis;

    public ExamenElementaire() {
        parametrePossible = new ArrayList<>();
        parametreChoisis = new ArrayList<>();
    }


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
