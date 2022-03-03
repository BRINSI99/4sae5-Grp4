package tn.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.spring.entities.DatabaseFile;

 

@Repository
public interface DatabaseFileRepository extends JpaRepository<DatabaseFile, String> {

	DatabaseFile  findByfileName(String fileId);

}