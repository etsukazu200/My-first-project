package medicale.repository;



import java.sql.Timestamp;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import medicale.models.Rendezvous;
import medicale.models.Visites;

public interface VisiteRepo extends JpaRepository<Visites, Integer >{
	@Query("select v from Visites v ")///@query associ? une r?qu?tte ? une fonction
	public	List<Visites> getvisite() ;

	@Query("select v from Visites v where numcarte=:numcarte")
	public Visites getVisiteParnumero(@Param(value = "numcarte") String numcarte);
	
	@Query("select v from Visites v where idpatients=:idpatients")
	
	 public List<Visites> getVisiteParid(@Param(value = "idpatients") int idpatients);

	//@Query(value="insert into visites (nompatient,prenompatient,typevisite,numcarte,motif,datevisite) value (:nompatient,:prenompatient,:typevisite,:numcarte,:motif,:datevisite) " ,nativeQuery = true)
	//@Transactional
	@Query(value="insert into visite (idpatients,typevisite,motif,datevisite) value (:idpatients,:typevisite,:motif,:datevisite) " ,nativeQuery = true)
	@Transactional
	public void inserVisite(@Param(value="idpatients") int idpatients,@Param(value="typevisite") String typevisite,@Param(value="motif") String motif,@Param(value="datevisite") Timestamp datevisite);
	
	//public void inserVisite(@Param(value="nompatient") String nompatient,@Param(value="prenompatient") String prenompatient,@Param(value="typevisite") String typevisite,@Param(value="numcarte") String numcarte,@Param(value="motif") String motif,@Param(value="datevisite") Timestamp datevisite);
	
	
	             //@Query(" delete  from Visites v where v.numcarte=:numcarte")
	@Modifying
	@Query(" delete  from Visites v where v.idpatients=:idpatients")
	@Transactional
	public void deletVisites(@Param(value="idpatients") int idpatients);

	
}
