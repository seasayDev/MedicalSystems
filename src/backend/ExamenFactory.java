package backend;
import java.util.Date;
import java.util.List;

import backend.AnalyseSang;
import backend.Anemie;
import backend.Endoscopie;
import backend.Myelogramme;
import backend.RadiographieIRM;
import backend.RadiographieRayon;
import backend.Thyroide;
import backend.AnalyseUrine;
import backend.Echographie;

public class ExamenFactory {
    public static Examen creerExamen(String typeExamen) {
        
        if (typeExamen.contains("Analyse de sang")) {
            return new AnalyseSang();
        } else if (typeExamen.contains("Rayon x")) {
            return new RadiographieRayon();
        } else if (typeExamen.contains("Radiographie irm")) {
            return new RadiographieIRM();
        } else if (typeExamen.contains("Endoscopie")) {
            return new Endoscopie();
        } else if (typeExamen.contains("Analyse d'urine")) {
            return new AnalyseUrine();
        } else if (typeExamen.contains("Myelogramme")) {
            return new Myelogramme();
        } else if (typeExamen.contains("Echographie")) {
            return new Echographie();
        } else if (typeExamen.contains("Anemie")) {
            return new Anemie();
        } else if (typeExamen.contains("Thyroide")) {
            return new Thyroide();
        } else {
            throw new IllegalArgumentException("Type d'examen inconnu: " + typeExamen);
        }
    }
}
