import java.util.ArrayList;
import java.util.List;

public abstract class ExamenCompose implements Examen {
    private String nomExamen;
    private ArrayList<Examen> examenInclusElementaire = new ArrayList<>();

    public ExamenCompose() {
        initializeExamens();
    }

    public abstract void initializeExamens();

    @Override
    public String getNom() {
        return nomExamen;
    }

    public void setNomExamen(String nomExamen) {
        this.nomExamen = nomExamen;
    }

    public ArrayList<Examen> getExamenInclus() {
        return examenInclusElementaire;
    }

    public void addExamen(Examen examenElementaire) {
        examenInclusElementaire.add(examenElementaire);
    }

    public void addParametre(String choisit) {}

    public void addParametres(ArrayList<String> parametres) {}
}
