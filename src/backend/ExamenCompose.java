import java.util.ArrayList;
import java.util.List;

public abstract class ExamenCompose implements Examen {
    private String nomExamen;
    private ArrayList<ExamenElementaire> examenInclus = new ArrayList<>();

    public ExamenCompose() {
        initializeExamens();
    }

    public abstract void initializeExamens();

    @Override
    public String getNomExamen() {
        return nomExamen;
    }

    public ArrayList<ExamenElementaire> getExamenInclus() {
        return examenInclus;
    }

    public void addExamenElementaire(ExamenElementaire examenElementaire) {
        examenInclus.add(examenElementaire);
    }
}
