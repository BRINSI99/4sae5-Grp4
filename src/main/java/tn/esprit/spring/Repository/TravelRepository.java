package tn.esprit.spring.Repository;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.TravelPlanning;


@Repository
public interface TravelRepository extends JpaRepository<TravelPlanning, Long>  {

	
}
