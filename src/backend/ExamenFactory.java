public class ExamenFactory {
    
    ExamenFactory(){}

    public static Examen createExamen(String nom) {
        if (type.equals("Sang")) {
            return new Examen(nom);
        } else if (type.equals("Urine")) {
            return new ExamenUrine(nom);
        } else {
            return new Examen(nom);
        }
    }
    
}
