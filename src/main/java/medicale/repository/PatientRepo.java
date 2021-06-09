package medicale.repository;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import medicale.models.Patients;



public interface  PatientRepo  extends JpaRepository<Patients, Integer >  {
	
	
	
	
	@Query("select p from Patients p ")///@query associé une réquétte a une fonction
	public	List<Patients> getPatient();
	
	@Modifying
	@Query(value="insert into patients (nom,prenom,sex,datedenaissance,numcarte) value (:nom,:prenom,:sex,:datedenaissance,:numcarte) " ,nativeQuery = true)
   
	@Transactional
	public void insertPatient(@Param(value="nom") String nom,@Param(value="prenom") String prenom, @Param(value="sex") String sex,@Param(value="datedenaissance") Date datedenaissance,@Param(value="numcarte") String numcarte);
	
	@Modifying
	@Query(value=" update patients set nom=:nom where idpatients=:id ", nativeQuery = true)
    @Transactional 
	public void updatePatient(@Param(value = "id") int id,@Param(value = "nom") String nom);
	
	@Modifying
	@Query("delete from Patients p where p.numcarte=:numcarte")
	@Transactional ()
	public void delectPatient(@Param("numcarte") String numcarte);
	
	
	@Modifying
	@Query("delete from Patients p")
	@Transactional
	public void delectAllP() ;
		
		
	
	
	
	
	
	}