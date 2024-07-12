package backend;

import java.util.Arrays;

public class RadiographieRayon extends ExamenElementaire {

    public RadiographieRayon() {
        parametrePossible.addAll(Arrays.asList("Membre inférieure", "Membre supérieure", "Thorax", "Crane", "Poumon"));
    }
}
