import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class NotifieurCourriel implements Notifieur {
    private static final long serialVersionUID = 1L;

    private String serviceName;

    public NotifieurCourriel(String serviceName) {
        this.serviceName = serviceName;
    }

    @Override
    public void envoyerNotification(String message, String destinataire) {
        String notification = "[" + serviceName + "] Courriel envoyé à " + destinataire + ": " + message;
        System.out.println(notification);
        enregistrerNotification("Courriel", notification);
    }

    @Override
    public void enregistrerEvenement(String type, String message) {
        String evenement = "[" + serviceName + "] Événement " + type + ": " + message;
        System.out.println(evenement);
        enregistrerDansFichier("evenements.txt", evenement);
    }

    private void enregistrerNotification(String type, String notification) {
        enregistrerDansFichier("notifications.txt", "Notification " + type + ": " + notification);
    }

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