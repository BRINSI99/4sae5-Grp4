package tn.esprit.spring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Reservation;



@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
