import java.util.ArrayList;

public class LaboratoireController {
    ArrayList <Laboratoire> completeListLaboratoires = new ArrayList<Laboratoire>();

    public LaboratoireController() {
        completeListLaboratoires = new ArrayList<Laboratoire>();
    }

    public void addLaboratoire(Laboratoire laboratoire){
        completeListLaboratoires.add(laboratoire);
    }

    public Laboratoire getRandomLaboFromList(ArrayList<Laboratoire> laboratoires){
        return laboratoires.get((int)(Math.random()*laboratoires.size()));
    }

    public ArrayList<Laboratoire> getCompleteListLaboratoires() {
        return completeListLaboratoires;
    }

    public ArrayList<Laboratoire> filterLabByExam(String examen){
        ArrayList<Laboratoire> laboAvecExam = new ArrayList<Laboratoire>();
        for (Laboratoire l : this.completeListLaboratoires){
            if (l.getExamensOffert().contains(examen)){
                laboAvecExam.add(l);
            }
        }
        return laboAvecExam;
    }

    

    public Laboratoire getLabForExam(String examen){
        ArrayList<Laboratoire> laboAvecExam = filterLabByExam(examen);
        return getRandomLaboFromList(laboAvecExam);
    }
}
