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

    public checkAvailability(String rdv){
        
    }
    
}
