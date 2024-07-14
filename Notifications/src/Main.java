
public class Main {
    public static void main(String[] args) {


        //Déclaration des variables
        Notifieur notifieurSMS = new NotifieurSMS("Service SMS");
        Notifieur notifieurCourriel = new NotifieurCourriel("Service Courriel");

        //Exemple d'utilisation pour la notification
        notifieurSMS.notifier("Votre rendez-vous est confirmé", "0123456789");
        notifieurCourriel.notifier("Vos résultats sont disponibles", "patient@example.com");

        //Exemple d'utilisation pour l'écoute des  evenements
        notifieurSMS.enregistrerEvenement("Attribution-RDV", "Nouveau RDV attribué");
        notifieurCourriel.enregistrerEvenement("Résultat-Examen", "Nouveaux résultats d'examen disponibles");
    }
}