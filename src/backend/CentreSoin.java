//SINGLETON

import java.util.ArrayList;
public class CentreSoin {
    ArrayList <Service> services = new ArrayList<Service>();
    ArrayList <Patient> patients = new ArrayList<Patient>();
    ArrayList <Medecin> medecins = new ArrayList<Medecin>();
    ArrayList <ExamenElementaire> prescriptionExamElementaire= new ArrayList<ExamenElementaire>();
    ArrayList <ExamenCompose> prescriptionExamComposé= new ArrayList<ExamenCompose>();

   

    public CentreSoin() {
        services = new ArrayList<Service>();
        patients = new ArrayList<Patient>();
        medecins = new ArrayList<Medecin>();
    }

    public Patient findPatientByCode(String code){
        for (Patient p : patients){
            if (p.getCodePatient().equals(code)){
                return p;
            }
        }
        return null;
    }
    
}
