import java.io.*;

public class GestionnaireDonnees {
    private static final String FICHIER_DONNEES = "donnees_application.ser";

    public static void sauvegarderDonnees(Object donnees) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FICHIER_DONNEES))) {
            oos.writeObject(donnees);
        } catch (IOException e) {
            System.err.println("Erreur lors de la sauvegarde des données: " + e.getMessage());
        }
    }

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