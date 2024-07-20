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

    public void ajouterLaboratoire(Laboratoire laboratoire) {
        laboratoires.add(laboratoire);
    }

    public void ajouterPatient(Patient patient) {
        patients.add(patient);
    }

    public void ajouterMedecin(Medecin medecin) {
        medecins.add(medecin);
    }

    public void ajouterExamen(Examen examen) {
        examens.add(examen);
    }

    public void ajouterPrescription(Prescription prescription) {
        prescriptions.add(prescription);
    }

    public void ajouterDemandeRDV(DemandeRDV demande) {
        demandesRDV.add(demande);
    }

    public List<DemandeRDV> getDemandesRDV() {
        return demandesRDV;
    }

    public void creerPrescription(Patient patient, Medecin medecin, List<Examen> examens) {
        Prescription prescription = new Prescription(new Date(), prescriptions.size() + 1, examens);
        prescriptions.add(prescription);
        for (Examen examen : examens) {
            ajouterExamen(examen);
            DemandeRDV demande = new DemandeRDV(demandesRDV.size() + 1, new Date(), patient, examen, medecin);
            envoyerDemandeRDV(demande);
        }
    }




    public void envoyerDemandeRDV(DemandeRDV demande) {
        Laboratoire laboratoire = choisirLaboratoire(demande.getExamen());
        if (laboratoire != null) {
            String demandeString = "numDemande=" + demande.getNumero() + ",codePatient=" + demande.getPatient().getCode() + ",descriptionExamen=" + demande.getExamen().getDescription();
            laboratoire.recevoirDemandeRDV(demandeString);
        } else {
            System.err.println("Aucun laboratoire disponible pour l'examen: " + demande.getExamen().getNom());
        }
    }




    public void envoyerResultatExamen(DemandeRDV demande) {
        Laboratoire laboratoire = choisirLaboratoire(demande.getExamen());
        if (laboratoire != null) {
            String demandeString = "Resultat: " + demande.getNumero() + ", Pour le patient: " + demande.getPatient().getNom() + " ,URI: " + demande.getPatient().getCode()+".pdf";
            laboratoire.envoyerResultatExamen(demandeString);
        } else {
            System.err.println("Aucun laboratoire disponible pour donner les examen: " + demande.getExamen().getNom());
        }
    }

    public void RecevoirResultatExamen(Patient patient, Medecin medecin, List<Examen> examens) {
        Prescription prescription = new Prescription(new Date(), prescriptions.size() + 1, examens);
        prescriptions.add(prescription);
        for (Examen examen : examens) {
            ajouterExamen(examen);
            DemandeRDV demande = new DemandeRDV(demandesRDV.size() + 1, new Date(), patient, examen, medecin);
            envoyerResultatExamen(demande);
        }
    }






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

    public void resultatExamen(String resultat) {
        // Logique pour traiter les résultats d'examen et notifier le médecin et le service
        gestionnaireNotifications.enregistrerEvenement("Résultat-Examen", resultat);
    }



    public void sauvegarder() {
        GestionnaireDonnees.sauvegarderDonnees(this);
    }

    public static CentreDeSoin charger() {
        return (CentreDeSoin) GestionnaireDonnees.chargerDonnees();
    }

    public GestionnaireNotifications getGestionnaireNotifications() {
        return gestionnaireNotifications;
    }
}