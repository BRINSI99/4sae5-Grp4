package tn.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.spring.entities.Doc;

public interface DocRepository extends JpaRepository<Doc,Integer> {

}
