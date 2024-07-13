package backend;

public class Anemie extends ExamenCompose {

    @Override
    public void initializeExamens() {
        AnalyseSang analyseSang = new AnalyseSang();
        Myelogramme mylelogramme = new Myelogramme();
        AnalyseUrine analyseUrine = new AnalyseUrine();

        addExamen(analyseSang);
        addExamen(mylelogramme);
        addExamen(analyseUrine);

        analyseSang.parametreChoisis.add("FSC");
        analyseUrine.parametreChoisis.add("proteinurie");
        analyseUrine.parametreChoisis.add("glycosurie");
        setNomExamen("Anemie");
    }
}

