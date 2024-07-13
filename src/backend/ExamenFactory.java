package backend;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExamenFactory {

    public static String getNomExamen(String nomExamen) {
        if (nomExamen.contains(":")) {
            return nomExamen.split(":")[0].trim();
        }
        return nomExamen.trim();
    }

    public static ArrayList<String> getParametreExamen(String nomExamen) {
        ArrayList<String> parametre = new ArrayList<>();
        if (nomExamen.contains(":")) {
            String coupure = nomExamen.split(":")[1].trim();
            if (!coupure.isEmpty()) {
                String[] elementsParametre = coupure.split("et");
                for (String param : elementsParametre) {
                    parametre.add(param.trim());
                }
            }
        }
        return parametre;
    }
    public static Examen creerExamen(String typeExamen) {

        ArrayList<String> parametre = getParametreExamen(typeExamen);

        if (typeExamen.contains("Analyse de sang")) {
            AnalyseSang analyseSang = new AnalyseSang();
            analyseSang.addParametres(parametre);
            return  analyseSang;
        } else if (typeExamen.contains("Rayon x")) {
            RadiographieRayon rayonX = new RadiographieRayon();
            rayonX.addParametres(parametre);
            return rayonX;
        } else if (typeExamen.contains("Radiographie irm")) {
            RadiographieIRM irm = new RadiographieIRM();
            irm.addParametres(parametre);
            return irm;
        } else if (typeExamen.contains("Endoscopie")) {
            Endoscopie endoscopie = new Endoscopie();
            endoscopie.addParametres(parametre);
            return endoscopie;
        } else if (typeExamen.contains("Analyse d'urine")) {
            AnalyseUrine analyseUrine = new AnalyseUrine();
            analyseUrine.addParametres(parametre);
            return analyseUrine;
        } else if (typeExamen.contains("Myelogramme")) {
            return new Myelogramme();
        } else if (typeExamen.contains("Echographie")) {
            Echographie echographie = new Echographie();
            echographie.addParametres(parametre);
            return echographie;
        } else if (typeExamen.contains("Anemie")) {
            return new Anemie();
        } else if (typeExamen.contains("Thyroide")) {
            return new Thyroide();
        } else {
            throw new IllegalArgumentException("Type d'examen inconnu: " + typeExamen);
        }
    }

}
