//SINGLETON
package backend;


import java.util.ArrayList;
public class CentreSoin {
    ArrayList <Service> services = new ArrayList<Service>();
    ArrayList <Laboratoire> laboratoires = new ArrayList<Laboratoire>();
    ArrayList <Patient> patients = new ArrayList<Patient>();
    ArrayList <Rdv> rdvs = new ArrayList<Rdv>();
    ArrayList <Medecin> medecins = new ArrayList<Medecin>();
    ArrayList <ExamenElementaire> prescriptionExamElementaire= new ArrayList<ExamenElementaire>();
    ArrayList <ExamenCompose> prescriptionExamComposé= new ArrayList<ExamenCompose>();

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
