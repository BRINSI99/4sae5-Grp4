package tn.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

 
import tn.spring.entities.FeedBack;

@Repository
public interface FeedBackRepository extends JpaRepository<FeedBack, Long> {
	 
}
