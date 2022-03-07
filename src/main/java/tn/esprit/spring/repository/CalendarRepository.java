package tn.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.spring.entities.Calendar;

public interface CalendarRepository extends JpaRepository<Calendar, Long> {

}
