import java.util.Date;
public class Prescription {
    private Patient patient;
    Date date;
    private int uniqueId;
    private static int uidCounter = 0;
    private Examen examen;

    public Prescription( Date date,Patient patient,Examen examen) {
        this.patient = patient;
        this.date = new Date();
        this.uniqueId = uidCounter++;
        this.examen = examen;

    }

    public Examen getExamen() {
        return examen;
    }

    public Patient getPatient() {
        return patient;
    }

    public String getNomExamen() {
        return examen.getNom();
    }

    public Date getDate() {
        return date;
    }

    public String getUniqueId() {
        return String.valueOf(this.uniqueId);
    }
}

