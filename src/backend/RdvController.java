import java.util.Queue;

public class RdvController {
    private Queue<String> fileRdvs;
    
    public Queue<String> getFileRdvs() {
        return fileRdvs;
    }

    public String getNextRdv(){
        return fileRdvs.poll();
    }

    public void addRdv(String rdv){
        fileRdvs.add(rdv);
    }

    public boolean isAvailable(Rdv rdv, Laboratoire laboratoire){
        for (Rdv approvedRdv : laboratoire.getRdvsApprouve()) {
            if (rdv.getTime().equals(approvedRdv.getTime()) && rdv.getDate().equals(approvedRdv.getDate())){
                return false;
            }
        }
        return true;
    }


    public void approveRdv(Rdv rdv, Laboratoire laboratoire){
        laboratoire.getRdvsApprouve().add(rdv);
    }
}
