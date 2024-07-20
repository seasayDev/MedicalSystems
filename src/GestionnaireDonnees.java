/**
 * La classe GestionnaireDonnees fournit des méthodes pour sauvegarder et charger des données
 * à partir d'un fichier sérialisé. Elle utilise la sérialisation pour stocker les objets dans un fichier
 * et les lire ensuite.
 */
import java.io.*;

public class GestionnaireDonnees {
    private static final String FICHIER_DONNEES = "donnees_application.ser";

    /**
     * Sauvegarde les données sérialisées dans un fichier.
     *
     * @param donnees les données à sauvegarder, qui doivent être sérialisables
     */
    public static void sauvegarderDonnees(Object donnees) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FICHIER_DONNEES))) {
            oos.writeObject(donnees);
        } catch (IOException e) {
            System.err.println("Erreur lors de la sauvegarde des données: " + e.getMessage());
        }
    }

    /**
     * Charge les données sérialisées à partir d'un fichier.
     *
     * @return les données chargées, ou null si le fichier n'existe pas ou s'il y a une erreur de lecture
     */
    public static Object chargerDonnees() {
        if (new File(FICHIER_DONNEES).exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FICHIER_DONNEES))) {
                return ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                System.err.println("Erreur lors du chargement des données: " + e.getMessage());
            }
        }
        return null;
    }
}