package medicale.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="dossiermedicale")

public class Dossiermedicale {

	@Id       // obligatoire ds chaque model
	@Column(name ="idpatients" )
	private int idpatients;
	
	

	@Column(name ="iddossiermedicale" )
	private int iddossiermedicale;
	@Column(name ="observation" )
	private String observation;
	
	
	@Column(name ="datecreation" )
	private Date datecreation;


	public int getIdpatiens() {
		return idpatients;
	}


	public void setIdpatiens(int idpatiens) {
		this.idpatients = idpatiens;
	}


	public int getIddossiermedicale() {
		return iddossiermedicale;
	}


	public void setIddossiermedicale(int iddossiermedicale) {
		this.iddossiermedicale = iddossiermedicale;
	}


	public String getObservation() {
		return observation;
	}


	public void setObservation(String observation) {
		this.observation = observation;
	}


	public Date getDatecreation() {
		return datecreation;
	}


	public void setDatecreation(Date datecreation) {
		this.datecreation = datecreation;
	}
	
}
