public interface Notifieur {
    void notifier(String message, String destinataire);
    void enregistrerEvenement(String type, String message);
}