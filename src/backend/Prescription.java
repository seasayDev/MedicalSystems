import java.util.Date;
public class Prescription {
    private Patient patient;
    Date date;
    private int uniqueId;
    private static int uidCounter = 0;
    private String nom;

    public Prescription(Patient patient,String nom) {
        this.patient = patient;
        this.date = new Date();
        this.uniqueId = uidCounter++;
        this.nom=nom;

    }

    public String getNom() {
        return nom;
    }

    public Patient getPatient() {
        return patient;
    }

    public String getNomExamen() {
        return nom;
    }

    public Date getDate() {
        return date;
    }

    public String getUniqueId() {
        return String.valueOf(this.uniqueId);
    }
}

