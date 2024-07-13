package backend;

public class Thyroide extends ExamenCompose {

    @Override
    public void initializeExamens() {
        Echographie echographie = new Echographie();
        Anemie anemie = new Anemie();
        AnalyseSang analyseSang = new AnalyseSang();

        addExamenElementaire(echographie);
        addExamenElementaire(anemie);
        addExamenElementaire(analyseSang);

        
        echographie.parametreChoisis.add("thyroide");
        analyseSang.parametreChoisis.add("TSH");
        setNomExamen("Thyroide");
    }
}
