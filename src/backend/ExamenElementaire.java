import java.util.ArrayList;

public abstract class ExamenElementaire {
    protected ArrayList<String> parametrePossible;
    protected ArrayList<String> parametreChoisis;

    public ExamenElementaire() {
        parametrePossible = new ArrayList<>();
        parametreChoisis = new ArrayList<>();
    }

    public void addParametre(String choisit) {
        if (parametrePossible.contains(choisit)) {
            parametreChoisis.add(choisit);
        } else {
            System.out.println("Le parametre entre n'est pas valide!");
        }
    }
}
