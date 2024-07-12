import java.util.Date;
import java.util.List;

import backend.AnalyseSang;
import backend.Anemie;
import backend.Endoscopie;
import backend.Mylelogramme;
import backend.RadiographieIRM;
import backend.RadiographieRayon;
import backend.Thyroide;

public class ExamenFactory {
    public static Examen creerExamen(String typeExamen) {
        switch (typeExamen.toLowerCase()) {
            case "analyse de sang":
            
                return new AnalyseSang();
            case "rayon x":
                return new RadiographieRayon();
            case "irm":
                return new RadiographieIRM();
            case "endoscopie":
                return new Endoscopie();
            case "analyse d'urine":
                return new AnalyseUrine();
            case "myelogramme":
                return new Mylelogramme();
            case "echographie":
                return new Echographie();
            case "anemie":
                return new Anemie();
            case "thyroide":
                return new Thyroide();
            default:
                throw new IllegalArgumentException("Type d'examen inconnu: " + typeExamen);
        }
    }
}

