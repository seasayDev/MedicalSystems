package backend;
import java.util.Date;

public class Rdv {
    private String uniqueId;
    private Date date;
    private Examen examen;
    private Laboratoire laboratoire;
    private Patient patient;
    private static int uidCounter = 0;

    public Rdv(Date date, Examen examen, Laboratoire laboratoire, Patient patient) {
        this.date = date;
        this.examen = examen;
        this.laboratoire = laboratoire;
        this.patient = patient;
        this.uniqueId = String.valueOf(uidCounter++);
    }
}
