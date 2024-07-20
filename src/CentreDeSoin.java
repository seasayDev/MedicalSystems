/**
 * La classe CentreDeSoin représente un centre de soins médical avec ses informations
 * de contact et les gestionnaires pour les notifications, les laboratoires, les patients,
 * les médecins, les examens, les prescriptions et les demandes de rendez-vous.
 * Elle implémente l'interface Serializable pour permettre la sérialisation des instances de cette classe.
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;


public class CentreDeSoin implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nom;
    private String adresse;
    private String telephone;
    private String courriel;
    private GestionnaireNotifications gestionnaireNotifications;
    private List<Laboratoire> laboratoires;
    private List<Patient> patients;
    private List<Medecin> medecins;
    private List<Examen> examens;
    private List<Prescription> prescriptions;
    private List<DemandeRDV> demandesRDV;

    /**
     * Constructeur de la classe CentreDeSoin.
     *
     * @param nom       le nom du centre de soins
     * @param adresse   l'adresse du centre de soins
     * @param telephone le numéro de téléphone du centre de soins
     * @param courriel  l'adresse email du centre de soins
     */
    public CentreDeSoin(String nom, String adresse, String telephone, String courriel) {
        this.nom = nom;
        this.adresse = adresse;
        this.telephone = telephone;
        this.courriel = courriel;
        this.gestionnaireNotifications = new GestionnaireNotifications();
        this.laboratoires = new ArrayList<>();
        this.patients = new ArrayList<>();
        this.medecins = new ArrayList<>();
        this.examens = new ArrayList<>();
        this.prescriptions = new ArrayList<>();
        this.demandesRDV = new ArrayList<>();
    }

    /**
     * Ajoute un laboratoire à la liste des laboratoires associés.
     *
     * @param laboratoire le laboratoire à ajouter
     */
    public void ajouterLaboratoire(Laboratoire laboratoire) {
        laboratoires.add(laboratoire);
    }

    /**
     * Ajoute un patient à la liste des patients.
     *
     * @param patient le patient à ajouter
     */
    public void ajouterPatient(Patient patient) {
        patients.add(patient);
    }

    /**
     * Ajoute un médecin à la liste des médecins.
     *
     * @param medecin le médecin à ajouter
     */
    public void ajouterMedecin(Medecin medecin) {
        medecins.add(medecin);
    }

    /**
     * Ajoute un examen à la liste des examens.
     *
     * @param examen l'examen à ajouter
     */
    public void ajouterExamen(Examen examen) {
        examens.add(examen);
    }

    /**
     * Ajoute une prescription à la liste des prescriptions.
     *
     * @param prescription la prescription à ajouter
     */
    public void ajouterPrescription(Prescription prescription) {
        prescriptions.add(prescription);
    }

    /**
     * Ajoute une demande de rendez-vous à la liste des demandes de rendez-vous.
     *
     * @param demande la demande de rendez-vous à ajouter
     */
    public void ajouterDemandeRDV(DemandeRDV demande) {
        demandesRDV.add(demande);
    }

    /**
     * Retourne la liste des demandes de rendez-vous.
     *
     * @return la liste des demandes de rendez-vous
     */
    public List<DemandeRDV> getDemandesRDV() {
        return demandesRDV;
    }

    /**
     * Crée une prescription pour un patient par un médecin, incluant des examens.
     *
     * @param patient  le patient pour lequel la prescription est faite
     * @param medecin  le médecin qui fait la prescription
     * @param examens  la liste des examens inclus dans la prescription
     */
    public void creerPrescription(Patient patient, Medecin medecin, List<Examen> examens) {
        Prescription prescription = new Prescription(new Date(), prescriptions.size() + 1, examens);
        prescriptions.add(prescription);
        for (Examen examen : examens) {
            ajouterExamen(examen);
            DemandeRDV demande = new DemandeRDV(demandesRDV.size() + 1, new Date(), patient, examen, medecin);
            envoyerDemandeRDV(demande);
        }
    }

    /**
     * Envoie une demande de rendez-vous à un laboratoire.
     *
     * @param demande la demande de rendez-vous à envoyer
     */
    public void envoyerDemandeRDV(DemandeRDV demande) {
        Laboratoire laboratoire = choisirLaboratoire(demande.getExamen());
        if (laboratoire != null) {
            String demandeString = "numDemande=" + demande.getNumero() + ",codePatient=" + demande.getPatient().getCode() + ",descriptionExamen=" + demande.getExamen().getDescription();
            laboratoire.recevoirDemandeRDV(demandeString);
        } else {
            System.err.println("Aucun laboratoire disponible pour l'examen: " + demande.getExamen().getNom());
        }
    }

    /**
     * Envoie le résultat d'un examen à un laboratoire.
     *
     * @param demande la demande de rendez-vous liée à l'examen
     */
    public void envoyerResultatExamen(DemandeRDV demande) {
        Laboratoire laboratoire = choisirLaboratoire(demande.getExamen());
        if (laboratoire != null) {
            String demandeString = "Resultat: " + demande.getNumero() + ", Pour le patient: " + demande.getPatient().getNom() + " ,URI: " + demande.getPatient().getCode()+".pdf";
            laboratoire.envoyerResultatExamen(demandeString);
        } else {
            System.err.println("Aucun laboratoire disponible pour donner les examen: " + demande.getExamen().getNom());
        }
    }

    /**
     * Reçoit les résultats d'examens pour un patient.
     *
     * @param patient le patient pour lequel les résultats sont reçus
     * @param medecin le médecin qui a prescrit les examens
     * @param examens la liste des examens dont les résultats sont reçus
     */
    public void RecevoirResultatExamen(Patient patient, Medecin medecin, List<Examen> examens) {
        Prescription prescription = new Prescription(new Date(), prescriptions.size() + 1, examens);
        prescriptions.add(prescription);
        for (Examen examen : examens) {
            ajouterExamen(examen);
            DemandeRDV demande = new DemandeRDV(demandesRDV.size() + 1, new Date(), patient, examen, medecin);
            envoyerResultatExamen(demande);
        }
    }

    /**
     * Choisit un laboratoire capable de réaliser un examen donné.
     *
     * @param examen l'examen pour lequel un laboratoire est choisi
     * @return le laboratoire choisi ou null si aucun laboratoire n'est disponible
     */
    private Laboratoire choisirLaboratoire(Examen examen) {
        List<Laboratoire> laboratoiresCompatibles = new ArrayList<>();
        for (Laboratoire laboratoire : laboratoires) {
            if (laboratoire.peutFaireExamen(examen)) {
                laboratoiresCompatibles.add(laboratoire);
            }
        }
        if (laboratoiresCompatibles.isEmpty()) {
            return null;
        }
        Random random = new Random();
        return laboratoiresCompatibles.get(random.nextInt(laboratoiresCompatibles.size()));
    }

    /**
     * Attribue un rendez-vous en fonction de la réponse d'un laboratoire.
     *
     * @param reponse la réponse du laboratoire contenant les détails du rendez-vous
     */
    public void attributionRDV(String reponse) {
        String[] pairs = reponse.split(",");
        String codePatient = null;
        int numDemande = 0;
        String dateRDV = null;
        String heureRDV = null;

        for (String pair : pairs) {
            String[] keyValue = pair.split("=");
            switch (keyValue[0].trim()) {
                case "codePatient":
                    codePatient = keyValue[1].trim();
                    break;
                case "numDemande":
                    numDemande = Integer.parseInt(keyValue[1].trim());
                    break;
                case "dateRDV":
                    dateRDV = keyValue[1].trim();
                    break;
                case "heureRDV":
                    heureRDV = keyValue[1].trim();
                    break;
            }
        }

        if (codePatient != null && numDemande != 0 && dateRDV != null && heureRDV != null) {
            // Logique pour traiter la réponse et notifier le patient et le service
            String message = "Votre RDV est confirmé pour le " + dateRDV + " à " + heureRDV;
            List<String> destinataires = new ArrayList<>();
            destinataires.add(codePatient); // Supposons que le code du patient soit son numéro de téléphone
            gestionnaireNotifications.notifier(message, destinataires);
            gestionnaireNotifications.enregistrerEvenement("Attribution-RDV", reponse);
        } else {
            System.err.println("Réponse de RDV invalide: " + reponse);
        }
    }

    /**
     * Traite les résultats d'examen et notifie le médecin et le service.
     *
     * @param resultat le résultat de l'examen
     */
    public void resultatExamen(String resultat) {
        // Logique pour traiter les résultats d'examen et notifier le médecin et le service
        gestionnaireNotifications.enregistrerEvenement("Résultat-Examen", resultat);
    }

    /**
     * Sauvegarde les données du centre de soins.
     */
    public void sauvegarder() {
        GestionnaireDonnees.sauvegarderDonnees(this);
    }

    /**
     * Charge les données du centre de soins.
     *
     * @return une instance de CentreDeSoin avec les données chargées
     */
    public static CentreDeSoin charger() {
        return (CentreDeSoin) GestionnaireDonnees.chargerDonnees();
    }

    /**
     * Retourne le gestionnaire de notifications.
     *
     * @return le gestionnaire de notifications
     */
    public GestionnaireNotifications getGestionnaireNotifications() {
        return gestionnaireNotifications;
    }
}