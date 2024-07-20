/**
 * La classe Medecin représente un médecin.
 */

import java.io.Serializable;

public class Medecin implements Serializable {
    private String matricule;
    private String nom;
    private String prenom;
    private String telephone;
    private String courriel;

    /**
     * Constructeur de la classe Medecin.
     *
     * @param matricule l'identifiant unique du médecin
     * @param nom       le nom de famille du médecin
     * @param prenom    le prénom du médecin
     * @param telephone le numéro de téléphone du médecin
     * @param courriel  l'adresse email du médecin
     */
    public Medecin(String matricule, String nom, String prenom, String telephone, String courriel) {
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.courriel = courriel;
    }

    /**
     * Retourne l'identifiant unique du médecin.
     *
     * @return le matricule du médecin
     */
    public String getMatricule() {
        return matricule;
    }

    /**
     * Retourne le nom de famille du médecin.
     *
     * @return le nom du médecin
     */
    public String getNom() {
        return nom;
    }

    /**
     * Retourne le prénom du médecin.
     *
     * @return le prénom du médecin
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Retourne le numéro de téléphone du médecin.
     *
     * @return le téléphone du médecin
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * Retourne l'adresse email du médecin.
     *
     * @return le courriel du médecin
     */
    public String getCourriel() {
        return courriel;
    }
}