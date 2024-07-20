/**
 * L'interface Notifieur définit les méthodes pour envoyer des notifications
 * et enregistrer des événements. Elle étend l'interface Serializable pour permettre
 * la sérialisation des instances de classes implémentant cette interface.
 */
import java.io.Serializable;

public interface Notifieur extends Serializable {

    /**
     * Envoie une notification avec un message à un destinataire spécifié.
     *
     * @param message      le message de la notification
     * @param destinataire le destinataire de la notification
     */
    void envoyerNotification(String message, String destinataire);

    /**
     * Enregistre un événement avec un type et un message associés.
     *
     * @param type    le type de l'événement
     * @param message le message associé à l'événement
     */
    void enregistrerEvenement(String type, String message);
}