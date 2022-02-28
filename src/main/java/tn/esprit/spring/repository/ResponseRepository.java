package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.entity.Response;

public interface ResponseRepository extends JpaRepository<Response, Long> {
}
