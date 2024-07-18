import java.util.ArrayList;


public abstract class ExamenElementaire implements Examen {
    private String nomExamen;
    protected ArrayList<String> parametrePossible;
    protected ArrayList<String> parametreChoisis;

    public ExamenElementaire() {
        parametrePossible = new ArrayList<>();
        parametreChoisis = new ArrayList<>();
    }


    public String getNom() {
        return nomExamen;
    }

    public void setNomExamen(String nomExamen) {
        this.nomExamen = nomExamen;
    }


    public void addParametre(String choisit) {
        if (parametrePossible.contains(choisit)) {
            parametreChoisis.add(choisit);
        } else{
            System.out.println("Le paramètre " + choisit + " n'est pas valide pour " + nomExamen);
        }
    }

    public void addParametres(ArrayList<String> parametres) {
        for (String parametre : parametres) {
            addParametre(parametre);
        }
    }


    public String toString() {
        return nomExamen + " " + parametreChoisis + " " + parametrePossible;
    }
}
