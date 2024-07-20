import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GestionnaireNotifications implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<Notifieur> notifieurs = new ArrayList<>();

    public void ajouterNotifieur(Notifieur notifieur) {
        notifieurs.add(notifieur);
    }

    public void notifier(String event, List<String> destinataires) {
        for (Notifieur notifieur : notifieurs) {
            for (String destinataire : destinataires) {
                notifieur.envoyerNotification(event, destinataire);
            }
        }
    }

    public void enregistrerEvenement(String type, String message) {
        for (Notifieur notifieur : notifieurs) {
            notifieur.enregistrerEvenement(type, message);
        }
    }
}