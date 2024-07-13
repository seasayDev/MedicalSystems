package backend;
import java.util.Date;
public class Prescription {
    private String nomExamen;
    private Patient patient;
    Date date;
    private int uniqueId;
    private static int uidCounter = 0;

    public Prescription(String nomExamen, Date date,Patient patient) {
        this.nomExamen = nomExamen;
        this.patient = patient;
        this.date = date;
        this.uniqueId = uidCounter++;

    }

    public Patient getPatient() {
        return patient;
    }

    public String getNomExamen() {
        return nomExamen;
    }

    public Date getDate() {
        return date;
    }

    public String getUniqueId() {
        return String.valueOf(this.uniqueId);
    }
}

