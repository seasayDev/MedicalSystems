/**
 * La classe ExamenCompose implémente l'interface Examen. Elle représente un examen composé
 * de plusieurs examens élémentaires, avec des informations
 * sur son nom, la date de prescription et la liste des examens élémentaires associés.
 */

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ExamenCompose implements Examen, Serializable {
    private static final long serialVersionUID = 1L;

    private String nom;
    private Date datePrescription;
    private List<ExamenElementaire> examens;

    /**
     * Constructeur de la classe ExamenCompose.
     *
     * @param nom              le nom de l'examen composé
     * @param datePrescription la date de prescription de l'examen composé
     * @param examens          la liste des examens élémentaires associés
     */
    public ExamenCompose(String nom, Date datePrescription, List<ExamenElementaire> examens) {
        this.nom = nom;
        this.datePrescription = datePrescription;
        this.examens = examens;
    }

    /**
     * Retourne le nom de l'examen composé.
     *
     * @return le nom de l'examen composé
     */
    @Override
    public String getNom() {
        return nom;
    }

    /**
     * Retourne la date de prescription de l'examen composé.
     *
     * @return la date de prescription de l'examen composé
     */
    @Override
    public Date getDatePrescription() {
        return datePrescription;
    }

    /**
     * Retourne une description complète de l'examen composé, incluant les descriptions
     * des examens élémentaires associés.
     *
     * @return la description de l'examen composé
     */
    @Override
    public String getDescription() {
        StringBuilder description = new StringBuilder("Examen: " + nom + ", Date de prescription: " + datePrescription);
        description.append(", Examens élémentaires: ");
        for (ExamenElementaire examen : examens) {
            description.append(examen.getDescription()).append("; ");
        }
        return description.toString();
    }
}