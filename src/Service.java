import java.util.ArrayList;

public class Service {
    private String nomService;
    private String numTel;
    private String courriel;
    private ArrayList <Medecin> medecins = new ArrayList<Medecin>();

    public Service(String nomService, String numTel, String courriel) {
        this.nomService = nomService;
        this.numTel = numTel;
        this.courriel = courriel;
    }

    public String getNomService() {
        return nomService;
    }

    public void setNomService(String nomService) {
        this.nomService = nomService;
    }

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public String getCourriel() {
        return courriel;
    }

    public void setCourriel(String courriel) {
        this.courriel = courriel;
    }

    public void addMedecin(Medecin medecin){
        medecins.add(medecin);
    }

    public ArrayList<Medecin> getMedecins() {
        return medecins;
    }
}
