import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Random;

public class SimulateurLaboratoire {

    private static final Random random = new Random();

    public static void repondreDemandeRDV(String reponse) {
        // Simuler l'envoi de la réponse au centre de soin
        CentreDeSoin centre = CentreDeSoin.charger();
        if (centre != null) {
            centre.attributionRDV(reponse);
            centre.sauvegarder();
        }
    }

    public static void envoyerResultatExamen(String resultat) {
        // Simuler l'envoi des résultats d'examen au centre de soin
        CentreDeSoin centre = CentreDeSoin.charger();
        if (centre != null) {
            centre.resultatExamen(resultat);
            centre.sauvegarder();
        }
    }

    public static LocalDate generateRandomDate() {
        LocalDate startDate = LocalDate.now().minusMonths(1);
        LocalDate endDate = LocalDate.now().plusMonths(1);
        long days = ChronoUnit.DAYS.between(startDate, endDate);
        return startDate.plusDays(random.nextInt((int) days + 1));
    }

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