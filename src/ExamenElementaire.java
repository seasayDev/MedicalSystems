/**
 * La classe ExamenElementaire implémente l'interface Examen.
 * Elle représente un examen élémentaire avec des informations sur son nom, la date de prescription
 * et des paramètres spécifiques.
 */

import java.io.Serializable;
import java.util.Date;

public class ExamenElementaire implements Examen, Serializable {
    private static final long serialVersionUID = 1L;

    private String nom;
    private Date datePrescription;
    private String parametres;

    /**
     * Constructeur de la classe ExamenElementaire.
     *
     * @param nom              le nom de l'examen
     * @param datePrescription la date de prescription de l'examen
     * @param parametres       les paramètres spécifiques de l'examen
     */
    public ExamenElementaire(String nom, Date datePrescription, String parametres) {
        this.nom = nom;
        this.datePrescription = datePrescription;
        this.parametres = parametres;
    }

    /**
     * Retourne le nom de l'examen.
     *
     * @return le nom de l'examen
     */
    @Override
    public String getNom() {
        return nom;
    }

    /**
     * Retourne la date de prescription de l'examen.
     *
     * @return la date de prescription de l'examen
     */
    @Override
    public Date getDatePrescription() {
        return datePrescription;
    }

    /**
     * Retourne une description complète de l'examen.
     *
     * @return la description de l'examen
     */
    @Override
    public String getDescription() {
        return "Examen: " + nom + ", Date de prescription: " + datePrescription + ", Paramètres: " + parametres;
    }
}