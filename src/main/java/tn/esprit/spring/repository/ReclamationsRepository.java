package tn.spring.repository;


 import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tn.spring.entities.Employee;
import tn.spring.entities.Reclamations;
import tn.spring.entities.Status;


 


public interface ReclamationsRepository extends JpaRepository<Reclamations, Integer>{
	 
	  @Query("select m from Reclamations as m where m.status ='Refused' and m.user.id=:user  ")
	    List<Reclamations> findMealByStatus1(@Param("user") Long user);
	  @Query("select m from Reclamations as m where m.status  ='Waiting' and m.user.id=:user  ")
	    List<Reclamations> findMealByStatus2(@Param("user") Long user);
	  @Query("select m from Reclamations as m where m.status ='Accepted	' and m.user.id=:user ")
	    List<Reclamations> findMealByStatus0(@Param("user") Long user);
}
