package medicale.models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="visite")
public class Visites {
	@Id       // obligatoire dans chaque model
	
	@Column(name ="idvisite" )
	private int idvisite;
	public int getIdvisite() {
		return idvisite;
	}
	public void setIdvisite(int idvisite) {
		this.idvisite = idvisite;
	}
	@Column(name ="idpatients" )
	private int idpatients;
public int getIdpatiens() {
		return idpatients;
	}
	public void setIdpatiens(int idpatiens) {
		this.idpatients = idpatiens;
	}
//@Column(name ="nompatient" )//permet de pr?siser les informations des colommes ici par ex le nom
//private String  nompatient;
//@Column(name ="prenompatient" )//permet de pr?siser les informations des colommes ici par ex le nom
//private String  prenompatient;
@Column(name ="typevisite" )//permet de pr?siser les informations des colommes ici par ex le nom
private String  typevisite;
public String getTypevisite() {
	return typevisite;
}
public void setTypevisite(String typevisite) {
	this.typevisite = typevisite;
}
@Column(name ="datevisite" )
private Timestamp datevisite;
public Timestamp getDatevisite() {
	return datevisite;
}
public void setDatevisite(Timestamp datevisite) {
	this.datevisite = datevisite;
}
@Column(name ="motif" )
private String motif;

public int getIdvisites() {
	return idvisite;
}
public void setIdvisites(int idvisites) {
	this.idvisite = idvisites;
}




//public String getNompatient() {
	//return nompatient;
//}
//public void setNompatient(String nompatient) {
	//this.nompatient = nompatient;
//}
//public String getPrenompatient() {
	//return prenompatient;
//}
//public void setPrenompatient(String prenompatient) {
//	this.prenompatient = prenompatient;
//}




public String getMotif() {
	return motif;
}
public void setMotif(String motif) {
	this.motif = motif;
}
//public String getNumcarte() {
//	return numcarte;
//}
//public void setNumcarte(String numcarte) {
//	this.numcarte = numcarte;
//}
//@Column(name ="numcarte" )
//private String numcarte;
@Column(name ="remarque" )
private String remarque;
public String getRemarque() {
	return remarque;
}
public void setRemarque(String remarque) {
	this.remarque = remarque;
}
	
	
	
	
	
	
	
	
}
