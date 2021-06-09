package medicale.controleur;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import medicale.models.Patients;
import medicale.models.Rendezvous;
import medicale.repository.PatientRepo;
import medicale.repository.RendezvousRepo;

@CrossOrigin // anotation de sécurité permet la connexion à partir de la méme machine qui héberge l'application
@RestController
public class Controleur {

	

	@Autowired
	private PatientRepo pat;
	@Autowired
	private RendezvousRepo visite;
	 
	 
	
	@RequestMapping("/patient")
	 public List<Patients> affiche() {
		
       return   pat.findAll();
       
   } 
	
	 
	 
	
	@RequestMapping("/rendezvous")
	 public List<Rendezvous> affich() {
		
       return   visite.getRendezvous();
       
   } 
	
	@RequestMapping("/rendezvousParnum/{numcarte}")
	public Rendezvous afficherParnum(@PathVariable("numcarte") String numcarte) {
		     Rendezvous vit=visite.getrendezvousParnumero(numcarte);
	       return vit;  
	}
	//fonction inserser

		@RequestMapping("/inserPatient/{nom}/{prenom}/{sex}/{datedenaissance}/{numcarte}")                          
		public  Patients getpatientParnum(@PathVariable("nom") String nom,@PathVariable("prenom") String prenom,@PathVariable("sex") String sex,@PathVariable("datedenaissance") Date datedenaissance,@PathVariable("numcarte") String numcarte) {   /// @PathVariabl récupére les paramétre du lien( nom) ..et l'associé à l'argument de la fonction ( num)
			//Integer id2=Integer.getInteger(id);//conversion id de string vers integer id2
			Patients patient=new Patients();
			//patient.setIdpatients(idpatients);
			patient.setPatientnom(nom);
			patient.setPrenom(prenom);
			patient.setSex(sex);
			patient.setDate(datedenaissance);
			patient.setNumcarte(numcarte);
			patient=pat.save(patient);
			
		
			
			System.out.println("l'insertion de  "+nom+" "+prenom+" "+sex+" "+datedenaissance+" "+numcarte );
		return patient;
		}
		
		@RequestMapping("/inserRendezvous/{dateheure}/{motif}/{patientnom}/{numcarte}")
		public  Rendezvous getRendezparmum(@PathVariable("dateheure") Timestamp dateheure,@PathVariable("motif") String motif,@PathVariable("patientnom") String patientnom,@PathVariable("numcarte") String numcarte) {   /// @PathVariabl récupére les paramétre du lien( nom) ..et l'associé à l'argument de la fonction ( num)
			//Integer id2=Integer.getInteger(id);//conversion id de string vers integer id2
			Rendezvous rendez=new Rendezvous();
			//patient.setIdpatients(idpatients);
			rendez.setDateheure(dateheure);
			rendez.setMotif(motif);
			rendez.setPatientnom(patientnom);
			rendez.setNumcarte(numcarte);
			rendez=visite.save(rendez);
			
		
			
			System.out.println("l'insertion de  "+dateheure+" "+motif+" "+" "+patientnom+" "+numcarte );
		return rendez;
		}
	
		@RequestMapping("/updatePatienttParnum/{id}/{nom}")
		public void updatePatientparnum(@PathVariable("id") int id,@PathVariable("nom") String nom) {
			
			   pat.updatePatient(id,nom);
			// String dip;
			 
			// dip = dep.getDepartement_nom();
			//dep.setDepartement_nom("jilali");
			
			
			
		}
	
	
		@RequestMapping("/delect/{numcarte}")
		public void delectParcode(@PathVariable("numcarte") String numcarte) {
		
		 pat.delectPatient(numcarte);
		 
		System.out.println("  le patient de numero carte "+numcarte+"supprimer");
		}
	@RequestMapping("/delectvousrendez/{numcarte}")
	public void delectparnum(@PathVariable("numcarte") String numcarte) {
		
		visite.deletRendezvous(numcarte);
		System.out.println("  le rendezvous du patient de numero carte "+numcarte+" "+"supprimer");
		
	}
	
	@RequestMapping("/delectAllpatients")
	public void deletePatiens() {
		pat.delectAllP();
		System.out.println(" tous les patiens sont supprimer");
	}
	@RequestMapping("/deletAll")
	public void deleterendezvous() {
		visite.deletAll();
		System.out.println(" les rendezvous sont supprimer");
	}
}
