package backend;

import java.util.Arrays;

public class AnalyseUrine extends ExamenElementaire {

    public AnalyseUrine() {
        parametrePossible.addAll(Arrays.asList("Base", "Ph", "proteinurie", "glycosurie", "cetosurie"));
        setNomExamen("Analyse d'urine");
    }
}
