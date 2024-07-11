public class RdvAdapter {
    CentreSoin centreSoin = new CentreSoin();

    public RdvAdapter() {
    }

    public Rdv toRdv(String rdvString) {
        String[] rdvArray = rdvString.split("-");
        Patient p= centreSoin.findPatientByCode(rdvString.charAt(0));
        
        Rdv rdv = new Rdv(p,rdvArray[1],rdvArray[2],new Examen(rdvArray[3],rdvArray[4],rdvArray[5]),rdvArray[6]);
        return rdv;
    }

    

    public String toRdvString(Rdv rdv) {
        return rdv.getPatient().getCodePatient()+"-"+rdv.getUniqueId()+"-"+rdv.getDate().toString()+"-"+rdv.getExamen().getNom()+"-"+rdv.getDate().toString()+"-"+rdv.getTime();
     }
    
}
