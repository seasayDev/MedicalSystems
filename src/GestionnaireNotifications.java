/**
 * La classe GestionnaireNotifications gère l'envoi de notifications et l'enregistrement d'événements
 * via une liste de notifieurs. Elle implémente l'interface Serializable pour permettre la sérialisation
 * des instances de cette classe.
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GestionnaireNotifications implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<Notifieur> notifieurs = new ArrayList<>();

    /**
     * Ajoute un notifieur à la liste des notifieurs.
     *
     * @param notifieur le notifieur à ajouter
     */
    public void ajouterNotifieur(Notifieur notifieur) {
        notifieurs.add(notifieur);
    }

    /**
     * Envoie une notification pour un événement donné à une liste de destinataires.
     *
     * @param event         l'événement pour lequel la notification est envoyée
     * @param destinataires la liste des destinataires de la notification
     */
    public void notifier(String event, List<String> destinataires) {
        for (Notifieur notifieur : notifieurs) {
            for (String destinataire : destinataires) {
                notifieur.envoyerNotification(event, destinataire);
            }
        }
    }

    /**
     * Enregistre un événement de type donné avec un message associé.
     *
     * @param type    le type de l'événement
     * @param message le message associé à l'événement
     */
    public void enregistrerEvenement(String type, String message) {
        for (Notifieur notifieur : notifieurs) {
            notifieur.enregistrerEvenement(type, message);
        }
    }
}