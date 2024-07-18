import java.io.Serializable;
import java.util.Date;

public class ExamenElementaire implements Examen, Serializable {
    private static final long serialVersionUID = 1L;

    private String nom;
    private Date datePrescription;
    private String parametres;

    public ExamenElementaire(String nom, Date datePrescription, String parametres) {
        this.nom = nom;
        this.datePrescription = datePrescription;
        this.parametres = parametres;
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
        return "Examen: " + nom + ", Date de prescription: " + datePrescription + ", Paramètres: " + parametres;
    }
}