import java.sql.Date;

public class Prescription {
    private String nom;
    private Patient patient;
    Date date;
    private int uniqueId;
    private static int uidCounter = 0;

    public Prescription(String nom, Date date,Patient patient) {
        this.nom = nom;
        this.patient = patient;
        this.date = date;
        this.uniqueId = uidCounter++;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getNom() {
        return nom;
    }

    public Date getDate() {
        return date;
    }

    public int getUniqueId() {
        return uniqueId;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }   

    public void setDate(Date date) {
        this.date = date;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }
}

