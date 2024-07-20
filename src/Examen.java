/**
 * L'interface Examen représente un examen médical avec des informations sur son nom,
 * la date de prescription et une description de l'examen.
 */

import java.util.Date;

public interface Examen {

    /**
     * Retourne le nom de l'examen.
     *
     * @return le nom de l'examen
     */
    String getNom();

    /**
     * Retourne la date de prescription de l'examen.
     *
     * @return la date de prescription de l'examen
     */
    Date getDatePrescription();

    /**
     * Retourne la description de l'examen.
     *
     * @return la description de l'examen
     */
    String getDescription();
}