package medicale.models;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="rendezvou")
public class Rendezvous {
	@Id       // obligatoire ds chaque model
	@Column(name ="idRendezvous" )
	private int idRendezvous;
@Column(name ="nompatient" )//permet de présiser les informations des colommes ici par ex le nom
private String  patientnom;
@Column(name ="dateheure" )
private Timestamp dateheure;
@Column(name ="motif" )
private String motif;
@Column(name ="numcarte" )
private String numcarte;

	public int getIdRendezvous() {
	return idRendezvous;
}

public void setIdRendezvous(int idRendezvous) {
	this.idRendezvous = idRendezvous;
}

public String getPatientnom() {
	return patientnom;
}

public void setPatientnom(String patientnom) {
	this.patientnom = patientnom;
}

public String getMotif() {
	return motif;
}

public void setMotif(String motif) {
	this.motif = motif;
}

public String getNumcarte() {
	return numcarte;
}

public void setNumcarte(String numcarte) {
	this.numcarte = numcarte;
}

public Timestamp getDateheure() {
	return  dateheure;
}

public void setDateheure(Timestamp dateheure) {
	this.dateheure = dateheure;
}

	
}



	

	

