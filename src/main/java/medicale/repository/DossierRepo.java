package medicale.repository;

import java.sql.Date;
import java.sql.Timestamp;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import medicale.models.Dossiermedicale;


public interface DossierRepo extends JpaRepository<Dossiermedicale, Integer >{
	
	
	@Query("select d from Dossiermedicale d where idpatients=:idpatients")
	public Dossiermedicale getdossierParnumero(@Param(value = "idpatients") int idpatients);
	
	@Query(value="insert into dossiermedicale (idpatients,datecreation,observation) value (:idpatients,:datecreation,:observation) " ,nativeQuery = true)
	@Transactional
	public void inserdossier(@Param(value="idpatients") int idpatients,@Param(value="datecreation") Date datecreation,@Param(value="observation") String observation);
	
	
	
	@Modifying
	@Query(" delete  from Dossiermedicale  d where d.idpatients=:idpatients")
	@Transactional
	public void deletdossier(@Param(value="idpatients") int idpatients);
	
	
	

}
