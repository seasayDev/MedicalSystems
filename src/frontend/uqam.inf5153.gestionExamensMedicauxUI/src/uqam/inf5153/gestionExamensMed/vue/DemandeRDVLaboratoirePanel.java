package uqam.inf5153.gestionExamensMed.vue;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import uqam.inf5153.gestionExamensMed.interf.IDemandeRDV;
import uqam.inf5153.gestionExamensMed.interf.ILaboratoire;
import uqam.inf5153.gestionExamensMed.interf.ILaboratoireController;
import javax.swing.border.TitledBorder;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

/**
 * Implémente le panneau qui contient la table des demandes de RDV 
 *  
 */
public class DemandeRDVLaboratoirePanel extends JPanel {
	static ArrayList<PredefinedRDV> predefinedRDVList = new  ArrayList<PredefinedRDV>() ; 

	static {
		initPredefList() ; 
	}

	private ILaboratoireController laboratoireController ; 

	private static final long serialVersionUID = 1L;
	private JTable demandeRDVtable;
	private JPanel panel;
	private JButton attribuerRDVButton;
	private JButton faireExamenButton;
	private JScrollPane scrollPane;

	/**
	 * Create the panel.
	 */
	public DemandeRDVLaboratoirePanel(ILaboratoireController laboratoireController) {
		this.laboratoireController = laboratoireController ;
		setLayout(new BorderLayout(0, 0));

		scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		// this.setViewportView(demandeRDVtable);


		demandeRDVtable = new JTable();
		// add(demandeRDVtable) ; //, BorderLayout.CENTER);
		demandeRDVtable.setModel(buildTableModel()) ; 
		// add(demandeRDVtable ,BorderLayout.SOUTH ) ; 


		scrollPane.setViewportView(demandeRDVtable);

		panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel.setBorder(new TitledBorder(null, "Traitements pr\u00E9d\u00E9finis", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(panel, BorderLayout.NORTH);

		attribuerRDVButton = new JButton("Attribuer RDV");
		attribuerRDVButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				attributionRDVPredefini() ; 
			}
		});
		panel.add(attribuerRDVButton);

		faireExamenButton = new JButton("Faire Examen");
		faireExamenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				faireExamenPredefini() ; 
			}
		});
		panel.add(faireExamenButton);

	}

	/**
	 * Construction du Model de la table des RDV 
	 * @return
	 */
	private DefaultTableModel buildTableModel() {
		DefaultTableModel res = new DefaultTableModel(); 

		res.addColumn("Laboratoire");
		res.addColumn("Demande RDV");
		res.addColumn("Date RDV (JJ-MM-AAAA)");
		res.addColumn("Heure RDV ( HH:MI)");
		res.addColumn("Examen (Oui/Non)");

		if (laboratoireController != null) {
			ArrayList<ILaboratoire> listLabs = laboratoireController.getListLaboratoire() ;

			int ind = 0 ; 
			for (ILaboratoire unLab : listLabs) {

				ArrayList<IDemandeRDV> listDemande = laboratoireController.listDemandeRDV(unLab.getCodeLaboratoire()) ; 

				if (listDemande != null) {
					for (IDemandeRDV uneDemande : listDemande) {
						Object[] row = new Object[5] ;

						DataRDV dataRDV = new DataRDV(uneDemande.getNumDemande() ,
								uneDemande.getCodePatient() , uneDemande.getNomPatient(), 
								uneDemande.getLabelExamen());

						row[0] = unLab.getNomLaboratoire() ; 
						row[1] = dataRDV  ; // Mettre un objet 
						row[2] = "" ; 
						row[3] = "" ;
						row[4] = "Non"  ; 
						res.insertRow(ind, row);
						ind++ ; 
					}
				}
			}	
		}
		return res ; 
	}

	/**
	 * 
	 */
	public void doTransmettreRDV() {
		ArrayList<String> RDVaTransmettre = new ArrayList<String>() ;  
		DefaultTableModel tableRDV = (DefaultTableModel) demandeRDVtable.getModel() ;

		int nbRows = tableRDV.getRowCount();
		int nbCols = tableRDV.getColumnCount() ;

		for (int i=0 ; i < nbRows ; i++) {
			String labName = (String)tableRDV.getValueAt(i, 0) ; 
			DataRDV dataRDV = (DataRDV)tableRDV.getValueAt(i, 1) ;
			String dateRDV = (String)tableRDV.getValueAt(i, 2) ;
			String hRDV    = (String)tableRDV.getValueAt(i, 3) ; 

			System.out.print ("Demande RDV : " + labName + "\t" + 
					"Desc. : " + dataRDV + "\t" + dateRDV ) ;

			if (dateRDV != null && dateRDV.length() != 0) {

				String unRDV = "codePatient = " + dataRDV.codePatient  + 
						" , numDemande = " + dataRDV.numDemande + 
						" , dateRDV = " + dateRDV + 
						" , heureRDV = " + hRDV ; 
				System.out.println ("#\t" + unRDV) ; 
				RDVaTransmettre.add(unRDV) ; 
			} 

		}
	}

	/**
	 * Callback du bouton  Attribuer RDV 
	 * 
	 * Attribut  des RDV (aléatoire) aux 80% des demandes    
	 * Attribuer des RDV 
	 * 
	 */
	private void attributionRDVPredefini() {
		DefaultTableModel tableRDV = (DefaultTableModel)demandeRDVtable.getModel() ;

		if (tableRDV != null ) {
			int nbreDemandeRDV = tableRDV.getRowCount() ; 
			if (nbreDemandeRDV != 0) {
				for (int i=0 ; i < nbreDemandeRDV ; i++) {

					// 80% des demandes de RDV auront un RDV 
					if (Math.random()>0.2) {
						PredefinedRDV rdv = rdvAleatoire() ; 

						tableRDV.setValueAt(rdv.date ,  i , 2 );
						tableRDV.setValueAt(rdv.heure , i , 3);
					}
				}
			}
		}

	}

	/**
	 *  Callback du bouton  Faire examen 
	 *  
	 */
	private void faireExamenPredefini() {
		DefaultTableModel tableRDV = (DefaultTableModel)demandeRDVtable.getModel() ;

		if (tableRDV != null ) {
			int nbreDemandeRDV = tableRDV.getRowCount() ; 
			for (int i=0 ; i < nbreDemandeRDV ; i++) {

				if (tableRDV.getValueAt(i, 2) != null &&  
						tableRDV.getValueAt(i, 2).toString().length()!=0)  {

					tableRDV.setValueAt("Oui" , i , 4 );

				}
			}
		}

	}

	/**
	 * Retourne un RDV prédéfini aléatoirement parmi 
	 * la liste des RDV 
	 * @return
	 */
	private static PredefinedRDV rdvAleatoire() {
		PredefinedRDV res ; 
		int nb = predefinedRDVList.size() ; 

		int ind = (int)(Math.random()*nb)  ; 
		res = predefinedRDVList.get(ind) ; 
		return res ; 
	}

	/**
	 * Méthode utilitaire pour créer des dates de RDV
	 * afin d'attribuer des RDV automatiquement  
	 */
	private static void initPredefList() {
		PredefinedRDV prefRDV ; 
		prefRDV = new PredefinedRDV("15-09-2024" , "10:45" ) ; 
		predefinedRDVList.add(prefRDV) ;

		prefRDV = new PredefinedRDV("19-09-2024" , "09:30" ) ; 
		predefinedRDVList.add(prefRDV) ;

		prefRDV = new PredefinedRDV("04-09-2024" , "09:00" ) ; 
		predefinedRDVList.add(prefRDV) ;

		prefRDV = new PredefinedRDV("05-10-2024" , "12:15" ) ; 
		predefinedRDVList.add(prefRDV) ; 

		prefRDV = new PredefinedRDV("07-10-2024" , "14:35" ) ; 
		predefinedRDVList.add(prefRDV) ;

		prefRDV = new PredefinedRDV("15-11-2024" , "15:20" ) ; 
		predefinedRDVList.add(prefRDV) ;

		prefRDV = new PredefinedRDV("13-11-2024" , "11:30" ) ; 
		predefinedRDVList.add(prefRDV) ; 

		prefRDV = new PredefinedRDV("01-12-2024" , "13:45" ) ; 
		predefinedRDVList.add(prefRDV) ; 

	}


	/**
	 * Classe locale pour stocker les data d'un RDV 
	 *  
	 */
	static class  DataRDV {
		private int numDemande ; 
		private String codePatient ; 
		private String nomPatien ;
		private String labelExamen ; 

		public DataRDV(int numDemande, String codePatient, String nomPatien , String labelExamen) {
			super();
			this.numDemande = numDemande;
			this.codePatient = codePatient;
			this.nomPatien = nomPatien;
			this.labelExamen = labelExamen ; 
		}
		@Override
		public String toString() {
			return  numDemande + " - " + labelExamen + " [" + codePatient + " - " + 
					nomPatien + 	"]" ;
		} 
	}
}
/**
 * Data class pour stocker des données d'un RDV 
 * 
 */
class PredefinedRDV { 
	String date ; 
	String heure ;

	public PredefinedRDV(String date, String heure) {
		this.date = date;
		this.heure = heure;
	} 


}
