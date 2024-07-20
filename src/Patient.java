/**
 * La classe Patient représente un patient contenant des informations personnelles.
 */

import java.io.Serializable;

public class Patient implements Serializable {
    private String code;
    private String nom;
    private String prenom;
    private String telephone;
    private String courriel;

    /**
     * Constructeur de la classe Patient.
     *
     * @param code      l'identifiant unique du patient
     * @param nom       le nom de famille du patient
     * @param prenom    le prénom du patient
     * @param telephone le numéro de téléphone du patient
     * @param courriel  l'adresse email du patient
     */
    public Patient(String code, String nom, String prenom, String telephone, String courriel) {
        this.code = code;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.courriel = courriel;
    }

    /**
     * Retourne l'identifiant unique du patient.
     *
     * @return le code du patient
     */
    public String getCode() {
        return code;
    }

    /**
     * Retourne le nom de famille du patient.
     *
     * @return le nom du patient
     */
    public String getNom() {
        return nom;
    }

    /**
     * Retourne le prénom du patient.
     *
     * @return le prénom du patient
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Retourne le numéro de téléphone du patient.
     *
     * @return le téléphone du patient
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * Retourne l'adresse email du patient.
     *
     * @return le courriel du patient
     */
    public String getCourriel() {
        return courriel;
    }
}