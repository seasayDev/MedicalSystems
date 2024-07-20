import java.io.Serializable;

public interface Notifieur extends Serializable {
    void envoyerNotification(String message, String destinataire);
    void enregistrerEvenement(String type, String message);
}