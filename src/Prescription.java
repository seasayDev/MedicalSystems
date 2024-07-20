/**
 * La classe Prescription représente une prescription médicale contenantune date de prescription,
 * un numéro unique et une liste d'examens.
 */

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Prescription implements Serializable {
    private static final long serialVersionUID = 1L;

    private Date date;
    private int numero;
    private List<Examen> examens;

    /**
     * Constructeur de la classe Prescription.
     *
     * @param date    la date de la prescription
     * @param numero  le numéro unique de la prescription
     * @param examens la liste des examens inclus dans la prescription
     */
    public Prescription(Date date, int numero, List<Examen> examens) {
        this.date = date;
        this.numero = numero;
        this.examens = examens;
    }

    /**
     * Retourne la date de la prescription.
     *
     * @return la date de la prescription
     */
    public Date getDate() {
        return date;
    }

    /**
     * Retourne le numéro unique de la prescription.
     *
     * @return le numéro unique de la prescription
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Retourne la liste des examens inclus dans la prescription.
     *
     * @return la liste des examens inclus dans la prescription
     */
    public List<Examen> getExamens() {
        return examens;
    }

    /**
     * Retourne une description complète de la prescription, incluant les descriptions
     * des examens inclus.
     *
     * @return la description de la prescription
     */
    public String getDescription() {
        StringBuilder description = new StringBuilder("Prescription: " + numero + ", Date: " + date);
        description.append(", Examens: ");
        for (Examen examen : examens) {
            description.append(examen.getDescription()).append("; ");
        }
        return description.toString();
    }
}