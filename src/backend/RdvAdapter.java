public class RdvAdapter {
    CentreSoin centreSoin = new CentreSoin();

    public RdvAdapter() {
    }

    public Rdv toRdv(String rdvString) {
        String[] rdvArray = rdvString.split("-");
        Patient patient = centreSoin.findPatientByCode(rdvArray[0]);
        String uniqueId = rdvArray[1];
        String date = rdvArray[2];
        String examen = rdvArray[3];
        String time = rdvArray[4];
        return new Rdv(patient, uniqueId, date, examen, time);
    }

    
    public String toRdvString(Rdv rdv) {
        return rdv.getPatient().getCodePatient()+"-"+rdv.getUniqueId()+"-"+rdv.getDate().toString()+"-"+rdv.getExamen().getNom()+"-"+rdv.getDate().toString()+"-"+rdv.getTime();
     }
    
}
