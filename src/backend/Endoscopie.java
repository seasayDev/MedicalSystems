package backend;

import java.util.Arrays;

public class Endoscopie extends ExamenElementaire {

    public Endoscopie() {
        parametrePossible.addAll(Arrays.asList("OEsophage", "bronchique", "Urologique"));
        setNomExamen("Endoscopie");
    }
}
