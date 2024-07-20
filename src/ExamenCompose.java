import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ExamenCompose implements Examen, Serializable {
    private static final long serialVersionUID = 1L;

    private String nom;
    private Date datePrescription;
    private List<ExamenElementaire> examens;

    public ExamenCompose(String nom, Date datePrescription, List<ExamenElementaire> examens) {
        this.nom = nom;
        this.datePrescription = datePrescription;
        this.examens = examens;
    }

    @Override
    public String getNom() {
        return nom;
    }

    @Override
    public Date getDatePrescription() {
        return datePrescription;
    }

    @Override
    public String getDescription() {
        StringBuilder description = new StringBuilder("Examen: " + nom + ", Date de prescription: " + datePrescription);
        description.append(", Examens élémentaires: ");
        for (ExamenElementaire examen : examens) {
            description.append(examen.getDescription()).append("; ");
        }
        return description.toString();
    }
}