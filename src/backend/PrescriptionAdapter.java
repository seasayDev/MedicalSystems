import java.util.ArrayList;

public class PrescriptionAdapter {
    public ArrayList <Rdv> toRdv(Prescription prescription){
        ArrayList <Rdv> rdvs = new ArrayList<Rdv>();
        Examen e = prescription.getExamens();
           
        return rdvs;
    }

    public ArrayList <Examen> toExamens(Prescription prescription){
        ArrayList <Examen> examens = new ArrayList<Examen>();
        Examen e = prescription.getExamen();
        if (Examen.class.isInstance(ExamenCompose)) {
            
        }
        examens.add(e);
        return examens;
    }
}

