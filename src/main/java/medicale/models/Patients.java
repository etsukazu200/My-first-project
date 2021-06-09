package medicale.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="patients")
public class Patients {
	@Id       // obligatoire ds chaque model
    // @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name ="idpatients" )
	private int idpatients;
@Column(name ="nom" )//permet de présiser les informations des colommes ici par ex le nom
private String  patientnom;

@Column(name ="prenom" )
private String prenom;
@Column(name ="sex" )
private String sex;
@Column(name ="numcarte" )
private String numcarte;

	@Column(name ="datedenaissance" )
	private Date date;

	public String getPatientnom() {
		return patientnom;
	}

	public String getPrenom() {
		return prenom;
	}

	public Date getDate() {
		return date;
	}

	public void setPatientnom(String patientnom) {
		this.patientnom = patientnom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getNumcarte() {
		return numcarte;
	}

	public void setNumcarte(String numcarte) {
		this.numcarte = numcarte;
	}

	

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getIdpatients() {
		return idpatients;
	}

	public void setIdpatients(int idpatients) {
		this.idpatients = idpatients;
	}

}
