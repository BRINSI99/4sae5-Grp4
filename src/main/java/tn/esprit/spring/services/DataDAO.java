package tn.spring.services;

 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.spring.entities.Data;

@Repository
public interface DataDAO extends JpaRepository<Data, Integer>{

}
