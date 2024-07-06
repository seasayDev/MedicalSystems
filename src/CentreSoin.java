import java.util.ArrayList;
import java.util.Queue;

public class CentreSoin {
    ArrayList <Service> services = new ArrayList<Service>();
    ArrayList <Laboratoire> laboratoires = new ArrayList<Laboratoire>();
    ArrayList <Patient> patients = new ArrayList<Patient>();
    ArrayList <Rdv> rdvs = new ArrayList<Rdv>();
    ArrayList <Medecin> medecins = new ArrayList<Medecin>();
    ArrayList <String> prescriptionExamElementaire= new ArrayList<String>();

    public CentreSoin() {
        prescriptionExamElementaire.add("Analyses de sang");
        prescriptionExamElementaire.add("Radiographie rayon X");
        prescriptionExamElementaire.add("Radiographie IRM");
        prescriptionExamElementaire.add("Endoscopie");
        prescriptionExamElementaire.add("Analyse d/'urine");
        prescriptionExamElementaire.add("Myélogramme");
        prescriptionExamElementaire.add("Échographie");
    }
}
