import java.util.ArrayList;
import java.util.Queue;
public class Laboratoire {
    private String code;
    private String nom;
    private String adresse;
    private String numTel;
    private String courriel;
    private ArrayList<String> examensOffert = new ArrayList<String>();
    private ArrayList<Rdv> rdvsApprouve = new ArrayList<Rdv>();
    

    public Laboratoire(String code, String nom, String adresse, String numTel, String courriel) {
        this.code = code;
        this.nom = nom;
        this.adresse = adresse;
        this.numTel = numTel;
        this.courriel = courriel;
    }

    public void addExamen(String examen){
        examensOffert.add(examen);
    }

    public ArrayList<String> getExamensOffert() {
        return examensOffert;
    }

    public String getCourriel() {
        return courriel;
    }

    public String getCode() {
        return code;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getNom() {
        return nom;
    }

    public String getNumTel() {
        return numTel;
    }






}