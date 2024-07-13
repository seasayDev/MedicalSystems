package backend;
//Cette classe est un singleton qui permet de notifier les clients de l'arrivée de nouveaux messages
public class Notifier {
private static final Notifier INSTANCE = new Notifier();

private Notifier() {}

public static Notifier getInstance() {
    return INSTANCE;
}
}
