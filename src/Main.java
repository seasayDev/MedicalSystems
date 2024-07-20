
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.io.*;

public class Main {
    public static void main(String[] args) {

        for (int i = 0; i< 2; i++) {
            // Charger les données existantes ou initialiser un nouveau centre de soin
            CentreDeSoin centre = CentreDeSoin.charger();
            if (centre == null) {
                centre = new CentreDeSoin("Centre de Santé", "123 Rue de la Santé", "0123456789", "contact@centredesante.com");
            }


            // Ajouter des laboratoires
            Laboratoire labo1 = new Laboratoire("L001", "Labo1", "Adresse1", "0123456789", "labo1@exemple.com", Arrays.asList("Analyse de sang", "Radiographie rayon X"));
            Laboratoire labo2 = new Laboratoire("L002", "Labo2", "Adresse2", "0123456789", "labo2@exemple.com", Arrays.asList("Examen thyroïde"));
            Laboratoire labo3 = new Laboratoire("L003", "Labo3", "Adresse3", "4555555", "labo3@exemple.com", Arrays.asList("Échographie"));

            centre.ajouterLaboratoire(labo1);
            centre.ajouterLaboratoire(labo2);
            centre.ajouterLaboratoire(labo3);

            // Ajouter des patients et des médecins
            Patient patient = new Patient("P001", "Dupont", "Jean", "0687654321", "jean.dupont@email.com");
            Medecin medecin = new Medecin("M001", "Martin", "Sophie", "0654321987", "sophie.martin@hopital.com");
            centre.ajouterPatient(patient);
            centre.ajouterMedecin(medecin);

            // Ajouter des notifieurs
            centre.getGestionnaireNotifications().ajouterNotifieur(new NotifieurSMS("Patient"));

            centre.getGestionnaireNotifications().ajouterNotifieur(new NotifieurCourriel("Medecin"));
            centre.getGestionnaireNotifications().ajouterNotifieur(new NotifieurSMS("Service"));


            // Créer des examens
            ExamenElementaire examen1 = new ExamenElementaire("Analyse de sang", new Date(), "Base, FSC, HDL, TSH");
            ExamenElementaire examen2 = new ExamenElementaire("Radiographie rayon X", new Date(), "Thorax");
            ExamenElementaire examen3 = new ExamenElementaire("Échographie", new Date(), "Cerveau");

            ExamenCompose examenCompose = new ExamenCompose("Examen thyroïde", new Date(), Arrays.asList(examen1, examen2));

            // Créer une prescription
            List<Examen> examens = new ArrayList<>();
            examens.add(examen1);
            examens.add(examenCompose);
            examens.add(examen3);

            centre.creerPrescription(patient, medecin, examens);

            // Simuler le traitement des examens et l'envoi des résultats
            SimulateurLaboratoire.traiterExamens(centre);

            // Simuler resultat des examens

            centre.RecevoirResultatExamen(patient, medecin, examens);


            // Afficher les résultats
            afficherResultats();

            // Sauvegarder les données à la fin de l'exécution
            centre.sauvegarder();

        }
    }

    private static void afficherResultats() {
        System.out.println("\n##############-* Événèments *-##############-*");
        afficherContenuFichier("evenements.txt");

        System.out.println("\n***************Notifications********************");
        System.out.println("\n---------------------------------------------\n----------------------Patient----------------\n---------------------------------------------\n");
        afficherContenuFichier("notifications.txt", "Patient");

        System.out.println("\n---------------------------------------------\n----------------------Service----------------\n---------------------------------------------\n");
        afficherContenuFichier("notifications.txt", "Service");

        System.out.println("\n---------------------------------------------\n----------------------Medecin----------------\n---------------------------------------------\n");
        afficherContenuFichier("notifications.txt", "Medecin");
    }

    private static void afficherContenuFichier(String nomFichier) {
        try (BufferedReader br = new BufferedReader(new FileReader(nomFichier))) {
            String ligne;
            while ((ligne = br.readLine()) != null) {
                System.out.println(ligne);
            }
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier " + nomFichier + ": " + e.getMessage());
        }
    }

    private static void afficherContenuFichier(String nomFichier, String filtre) {
        try (BufferedReader br = new BufferedReader(new FileReader(nomFichier))) {
            String ligne;
            while ((ligne = br.readLine()) != null) {
                if (ligne.contains(filtre)) {
                    System.out.println(ligne);
                }
            }
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier " + nomFichier + ": " + e.getMessage());
        }
    }
}