import java.util.ArrayList;
import java.util.Date;

public interface Examen {
    public String getNom();
    public Date getDatePrescription();
    public String getParametres();
    public void addParametre(String choisit);
    public void addParametres(ArrayList<String> parametres);

}