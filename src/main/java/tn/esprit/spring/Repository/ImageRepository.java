package tn.esprit.spring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.spring.entity.Image;



public interface ImageRepository extends JpaRepository<Image, Long>  {

}
