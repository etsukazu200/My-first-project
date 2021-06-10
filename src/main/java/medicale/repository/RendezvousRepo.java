package medicale.repository;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;


import medicale.models.Rendezvous;

public interface RendezvousRepo  extends JpaRepository<Rendezvous, Integer >{

	@Query("select r from Rendezvous r ")///@query associé une réquétte a une fonction
	public	List<Rendezvous> getRendezvous() ;

	@Query("select r from Rendezvous r where numcarte=:numcarte")
	public  Rendezvous getrendezvousParnumero(@Param(value = "numcarte") String numcarte); 
	
	
	@Modifying
	@Query(value="insert into rendezvou (dateheure,motif,nompatient,numcarte) value (:dateheure,:motif,:nompatient,:numcarte) " ,nativeQuery = true)
   
	@Transactional
	public void inserRendezvous(@Param(value="dateheure") Timestamp dateheure,@Param(value="motif") String motif,@Param(value="nompatient") String nompatient,@Param(value="numcarte") String numcarte);
	
	@Modifying
	@Query(" delete  from Rendezvous r ")
	@Transactional
	public void deletAll();
	@Modifying
	@Query(" delete  from Rendezvous r where r.numcarte=:numcarte")
	@Transactional
	public void deletRendezvous(@Param(value="numcarte") String numcarte);
}
