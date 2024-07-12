package backend;

import java.util.Arrays;

public class Echographie extends ExamenElementaire {

    public Echographie() {
        parametrePossible.addAll(Arrays.asList("Thyroide", "cerveau", "obstetricale"));
    }
}
