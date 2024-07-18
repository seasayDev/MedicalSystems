
public class Rdv {
    private String uniqueId;
    private String date;
    private String time;
    private Examen examen;
    private Laboratoire laboratoire;
    private Patient patient;
    private static int uidCounter = 0;
    
    
    public Rdv(String date, Examen examen, Laboratoire laboratoire, Patient patient, String time) {
        this.date = date;
        this.time = time;
        this.examen = examen;
        this.laboratoire = laboratoire;
        this.patient = patient;
        this.uniqueId = String.valueOf(uidCounter++);
    }

    public Rdv(){}

    public String getTime() {
        return time;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public String getDate() {
        return date;
    }

    public Examen getExamen() {
        return examen;
    }

    public Laboratoire getLaboratoire() {
        return laboratoire;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setExamen(Examen exam)
    {
        this.examen = exam;
    }

    public void setLaboratoire(Laboratoire laboratoire) {
        this.laboratoire = laboratoire;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getNomExamen() {
        return examen.getNom();
    }

    public String getNomLaboratoire() {
        return laboratoire.getNom();
    }

    public String getNomPatient() {
        return patient.getNom();
    }
}
