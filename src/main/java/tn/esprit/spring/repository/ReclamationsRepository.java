package tn.spring.repository;


 import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tn.spring.entities.Employee;
import tn.spring.entities.Reclamations;
import tn.spring.entities.Status;


 


public interface ReclamationsRepository extends JpaRepository<Reclamations, Integer>{
	 
	  @Query(value ="select * from Reclamations m where m.status like '%1%' and user_id=?1  ", nativeQuery = true)
	    List<Reclamations> findMealByStatus1(Long user_id);
	  @Query(value ="select * from Reclamations m where m.status like '%2%' and user_id=?1 ", nativeQuery = true)
	    List<Reclamations> findMealByStatus2(Long user_id);
	  @Query(value ="select * from Reclamations m where m.status like '%0%' and user_id=?1 ", nativeQuery = true)
	    List<Reclamations> findMealByStatus0(Long user_id);
}
