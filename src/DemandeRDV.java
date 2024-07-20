/**
 * La classe DemandeRDV représente une demande de rendez-vous médical.
 * Elle implémente l'interface Serializable pour permettre la sérialisation des instances de cette classe.
 */
import java.io.Serializable;
import java.util.Date;

public class DemandeRDV implements Serializable {
    private int numero;
    private Date date;
    private Patient patient;
    private Examen examen;
    private Medecin medecin;

    /**
     * Constructeur de la classe DemandeRDV.
     *
     * @param numero   le numéro de la demande de rendez-vous
     * @param date     la date du rendez-vous
     * @param patient  le patient concerné par le rendez-vous
     * @param examen   l'examen associé au rendez-vous
     * @param medecin  le médecin en charge du rendez-vous
     */
    public DemandeRDV(int numero, Date date, Patient patient, Examen examen, Medecin medecin) {
        this.numero = numero;
        this.date = date;
        this.patient = patient;
        this.examen = examen;
        this.medecin = medecin;
    }

    /**
     * Retourne le numéro de la demande de rendez-vous.
     *
     * @return le numéro de la demande de rendez-vous
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Retourne la date du rendez-vous.
     *
     * @return la date du rendez-vous
     */
    public Date getDate() {
        return date;
    }

    /**
     * Retourne le patient concerné par le rendez-vous.
     *
     * @return le patient concerné par le rendez-vous
     */
    public Patient getPatient() {
        return patient;
    }

    /**
     * Retourne l'examen associé au rendez-vous.
     *
     * @return l'examen associé au rendez-vous
     */
    public Examen getExamen() {
        return examen;
    }

    /**
     * Retourne le médecin en charge du rendez-vous.
     *
     * @return le médecin en charge du rendez-vous
     */
    public Medecin getMedecin() {
        return medecin;
    }
}