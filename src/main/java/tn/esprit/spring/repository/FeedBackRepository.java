package tn.spring.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

 
import tn.spring.entities.FeedBack;
import tn.spring.entities.Reclamations;

@Repository
public interface FeedBackRepository extends JpaRepository<FeedBack, Long> {
	@Query(value ="select * from FeedBack m where m.companies_id=?1  ", nativeQuery = true)
    List<FeedBack> findByCompanies(Long companies_id );

 }
