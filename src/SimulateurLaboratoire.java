/**
 * La classe SimulateurLaboratoire simule les opérations d'un laboratoire médical,
 * telles que la réponse à une demande de rendez-vous, l'envoi des résultats d'examens,
 * et la génération de dates aléatoires pour les examens.
 */
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Random;

public class SimulateurLaboratoire {

    private static final Random random = new Random();

    /**
     * Simule la réponse à une demande de rendez-vous en envoyant une réponse au centre de soin.
     *
     * @param reponse la réponse du laboratoire contenant les détails du rendez-vous
     */
    public static void repondreDemandeRDV(String reponse) {
        // Simuler l'envoi de la réponse au centre de soin
        CentreDeSoin centre = CentreDeSoin.charger();
        if (centre != null) {
            centre.attributionRDV(reponse);
            centre.sauvegarder();
        }
    }

    /**
     * Simule l'envoi des résultats d'examen au centre de soin.
     *
     * @param resultat le résultat de l'examen sous forme de chaîne de caractères
     */
    public static void envoyerResultatExamen(String resultat) {
        // Simuler l'envoi des résultats d'examen au centre de soin
        CentreDeSoin centre = CentreDeSoin.charger();
        if (centre != null) {
            centre.resultatExamen(resultat);
            centre.sauvegarder();
        }
    }

    /**
     * Génère une date aléatoire entre un mois passé et un mois futur à partir de la date actuelle.
     *
     * @return une date aléatoire
     */
    public static LocalDate generateRandomDate() {
        LocalDate startDate = LocalDate.now().minusMonths(1);
        LocalDate endDate = LocalDate.now().plusMonths(1);
        long days = ChronoUnit.DAYS.between(startDate, endDate);
        return startDate.plusDays(random.nextInt((int) days + 1));
    }

    /**
     * Traite les examens en cours pour un centre de soin donné, en générant des résultats d'examens
     * et en les envoyant au centre de soin.
     *
     * @param centre le centre de soin dont les examens doivent être traités
     */
    public static void traiterExamens(CentreDeSoin centre) {
        for (DemandeRDV demande : centre.getDemandesRDV()) {
            LocalDate dateExamen = generateRandomDate();
            String resultatExamen = String.format("codePatient=%s,numRDV=%d,dateExamen=%s,URI=resultat%d.pdf",
                    demande.getPatient().getCode(), demande.getNumero(), dateExamen, demande.getNumero());
            envoyerResultatExamen(resultatExamen);
            centre.sauvegarder();
        }
    }
}