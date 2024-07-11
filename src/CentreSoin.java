import java.util.ArrayList;


public class CentreSoin {
    ArrayList <Service> services;
    ArrayList <Laboratoire> laboratoires;
    ArrayList <Patient> patients;
    ArrayList <Rdv> rdvs;
    ArrayList <Medecin> medecins;
    ArrayList <ExamenElementaire> prescriptionExamElementaire;
    ArrayList <ExamenCompose> prescriptionExamComposé;

    public CentreSoin() {
        services = new ArrayList<Service>();
        laboratoires = new ArrayList<Laboratoire>();
        patients = new ArrayList<Patient>();
        rdvs = new ArrayList<Rdv>();
        medecins = new ArrayList<Medecin>();
        prescriptionExamElementaire= new ArrayList<ExamenElementaire>();
        prescriptionExamComposé= new ArrayList<ExamenCompose>();
    }


    public Laboratoire getRandomLabo(){
        return laboratoires.get((int)(Math.random()*laboratoires.size()));
    }

    
}
