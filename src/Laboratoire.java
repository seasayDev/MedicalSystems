/**
 * La classe Laboratoire représente un laboratoire médical avec ses informations
 * de contact et la liste des examens qu'il peut réaliser. Elle implémente l'interface
 * Serializable pour permettre la sérialisation des instances de cette classe.
 */
import java.io.Serializable;
import java.util.List;

public class Laboratoire implements Serializable {
    private static final long serialVersionUID = 1L;

    private String code;
    private String nom;
    private String adresse;
    private String telephone;
    private String courriel;
    private List<String> examensDisponibles;

    /**
     * Constructeur de la classe Laboratoire.
     *
     * @param code              le code unique du laboratoire
     * @param nom               le nom du laboratoire
     * @param adresse           l'adresse du laboratoire
     * @param telephone         le numéro de téléphone du laboratoire
     * @param courriel          l'adresse email du laboratoire
     * @param examensDisponibles la liste des examens disponibles dans le laboratoire
     */
    public Laboratoire(String code, String nom, String adresse, String telephone, String courriel, List<String> examensDisponibles) {
        this.code = code;
        this.nom = nom;
        this.adresse = adresse;
        this.telephone = telephone;
        this.courriel = courriel;
        this.examensDisponibles = examensDisponibles;
    }

    /**
     * Retourne le code unique du laboratoire.
     *
     * @return le code du laboratoire
     */
    public String getCode() {
        return code;
    }

    /**
     * Retourne le nom du laboratoire.
     *
     * @return le nom du laboratoire
     */
    public String getNom() {
        return nom;
    }

    /**
     * Retourne l'adresse du laboratoire.
     *
     * @return l'adresse du laboratoire
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     * Retourne le numéro de téléphone du laboratoire.
     *
     * @return le numéro de téléphone du laboratoire
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * Retourne l'adresse email du laboratoire.
     *
     * @return l'adresse email du laboratoire
     */
    public String getCourriel() {
        return courriel;
    }

    /**
     * Vérifie si le laboratoire peut réaliser un examen donné.
     *
     * @param examen l'examen à vérifier
     * @return true si le laboratoire peut réaliser l'examen, false sinon
     */
    public boolean peutFaireExamen(Examen examen) {
        return examensDisponibles.contains(examen.getNom());
    }

    /**
     * Reçoit une demande de rendez-vous et simule une réponse.
     *
     * @param demande la demande de rendez-vous sous forme de chaîne de caractères
     */
    public void recevoirDemandeRDV(String demande) {
        System.out.println("Demande de RDV reçue par " + nom + ": " + demande);
        // Simuler une réponse
        String reponse = "codePatient=" + demande.split(",")[1].split("=")[1] + ",numDemande=" + demande.split(",")[0].split("=")[1] + ",dateRDV=15-07-2024,heureRDV=14:30";
        SimulateurLaboratoire.repondreDemandeRDV(reponse);
    }

    /**
     * Envoie le résultat d'un examen et le simule.
     *
     * @param resultat le résultat de l'examen sous forme de chaîne de caractères
     */
    public void envoyerResultatExamen(String resultat) {
        System.out.println("Résultat d'examen envoyé par " + nom + ": " + resultat);
        SimulateurLaboratoire.envoyerResultatExamen(resultat);
    }
}