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

    public Laboratoire(String code, String nom, String adresse, String telephone, String courriel, List<String> examensDisponibles) {
        this.code = code;
        this.nom = nom;
        this.adresse = adresse;
        this.telephone = telephone;
        this.courriel = courriel;
        this.examensDisponibles = examensDisponibles;
    }

    public String getCode() {
        return code;
    }

    public String getNom() {
        return nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getCourriel() {
        return courriel;
    }

    public boolean peutFaireExamen(Examen examen) {
        return examensDisponibles.contains(examen.getNom());
    }

    public void recevoirDemandeRDV(String demande) {
        System.out.println("Demande de RDV reçue par " + nom + ": " + demande);
        // Simuler une réponse
        String reponse = "codePatient=" + demande.split(",")[1].split("=")[1] + ",numDemande=" + demande.split(",")[0].split("=")[1] + ",dateRDV=15-07-2024,heureRDV=14:30";
        SimulateurLaboratoire.repondreDemandeRDV(reponse);
    }

    public void envoyerResultatExamen(String resultat) {
        System.out.println("Résultat d'examen envoyé par " + nom + ": " + resultat);
        SimulateurLaboratoire.envoyerResultatExamen(resultat);
    }
}