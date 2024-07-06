import java.sql.Date;

public class Prescription {
    private String nom;
    private Patient patient;
    Date date;
    private String uniqueId;

    public Prescription(String nom, Date date,Patient patient, String uniqueId) {
        this.nom = nom;
        this.patient = patient;
        this.date = date;
        this.uniqueId = uniqueId;
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

    public String getUniqueId() {
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

