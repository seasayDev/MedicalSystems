import java.io.Serializable;
import java.util.Date;

public class DemandeRDV implements Serializable {
    private int numero;
    private Date date;
    private Patient patient;
    private Examen examen;
    private Medecin medecin;

    public DemandeRDV(int numero, Date date, Patient patient, Examen examen, Medecin medecin) {
        this.numero = numero;
        this.date = date;
        this.patient = patient;
        this.examen = examen;
        this.medecin = medecin;
    }

    public int getNumero() {
        return numero;
    }

    public Date getDate() {
        return date;
    }

    public Patient getPatient() {
        return patient;
    }

    public Examen getExamen() {
        return examen;
    }

    public Medecin getMedecin() {
        return medecin;
    }
}