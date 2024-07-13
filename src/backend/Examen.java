package backend;
import java.util.ArrayList;
import java.util.Date;

public interface Examen {
    
    public String getNomExamen();
    public void setNomExamen(String nomExamen);
    public void addParametre(String choisit);
    public void addParametres(ArrayList<String> parametres);
}
