package tn.esprit.spring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.SearchCritere;

@Repository
public interface SearchCritereRepository  extends JpaRepository<SearchCritere, Long> {

}
