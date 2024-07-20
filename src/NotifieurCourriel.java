/**
 * La classe NotifieurCourriel implémente l'interface Notifieur.
 * Elle représente un système de notification par courriel, avec des fonctionnalités
 * pour envoyer des notifications et enregistrer des événements.
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class NotifieurCourriel implements Notifieur {
    private static final long serialVersionUID = 1L;

    private String serviceName;

    /**
     * Constructeur de la classe NotifieurCourriel.
     *
     * @param serviceName le nom du service de notification
     */
    public NotifieurCourriel(String serviceName) {
        this.serviceName = serviceName;
    }

    /**
     * Envoie une notification par courriel à un destinataire spécifié.
     *
     * @param message      le message de la notification
     * @param destinataire le destinataire de la notification
     */
    @Override
    public void envoyerNotification(String message, String destinataire) {
        String notification = "[" + serviceName + "] Courriel envoyé à " + destinataire + ": " + message;
        System.out.println(notification);
        enregistrerNotification("Courriel", notification);
    }

    /**
     * Enregistre un événement avec un type et un message associés.
     *
     * @param type    le type de l'événement
     * @param message le message associé à l'événement
     */
    @Override
    public void enregistrerEvenement(String type, String message) {
        String evenement = "[" + serviceName + "] Événement " + type + ": " + message;
        System.out.println(evenement);
        enregistrerDansFichier("evenements.txt", evenement);
    }

    /**
     * Enregistre une notification dans un fichier de notifications.
     *
     * @param type         le type de la notification
     * @param notification le contenu de la notification
     */
    private void enregistrerNotification(String type, String notification) {
        enregistrerDansFichier("notifications.txt", "Notification " + type + ": " + notification);
    }

    /**
     * Enregistre un contenu spécifié dans un fichier donné.
     *
     * @param nomFichier le nom du fichier dans lequel enregistrer le contenu
     * @param contenu    le contenu à enregistrer
     */
    private void enregistrerDansFichier(String nomFichier, String contenu) {
        try (FileWriter fw = new FileWriter(nomFichier, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(contenu);
        } catch (IOException e) {
            System.err.println("Erreur lors de l'enregistrement dans le fichier " + nomFichier + ": " + e.getMessage());
        }
    }
}