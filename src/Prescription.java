import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Prescription implements Serializable {
    private static final long serialVersionUID = 1L;

    private Date date;
    private int numero;
    private List<Examen> examens;

    public Prescription(Date date, int numero, List<Examen> examens) {
        this.date = date;
        this.numero = numero;
        this.examens = examens;
    }

    public Date getDate() {
        return date;
    }

    public int getNumero() {
        return numero;
    }

    public List<Examen> getExamens() {
        return examens;
    }

    public String getDescription() {
        StringBuilder description = new StringBuilder("Prescription: " + numero + ", Date: " + date);
        description.append(", Examens: ");
        for (Examen examen : examens) {
            description.append(examen.getDescription()).append("; ");
        }
        return description.toString();
    }
}