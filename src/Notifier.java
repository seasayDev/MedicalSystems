
//Cette classe est un singleton qui permet de notifier les clients de l'arrivée de nouveaux messages
public class Notifier {
private static Notifier instance;

public static Notifier getInstance() {
    if (instance == null) {
        instance = new Notifier();
    }
    return instance;
}

}
