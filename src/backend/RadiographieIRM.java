package backend;

import java.util.Arrays;

public class RadiographieIRM extends ExamenElementaire {

    public RadiographieIRM() {
        parametrePossible.addAll(Arrays.asList("Cerveau", "Moelle épinière", "Hanche"));
    }
}
