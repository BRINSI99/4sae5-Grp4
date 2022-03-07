package tn.spring.repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import tn.spring.entities.CalendarEvent;

public interface CalendarEventRepository extends JpaRepository<CalendarEvent, Long>{
    @Transactional
    @Query("select a from CalendarEvent a  where a.eventDateTime >=:creationDateDebut  and  a.eventDateTime <= :creationDateFin ")
    
    List<CalendarEvent> findAllWithCreationDateTimeBefore( @Param("creationDateDebut") LocalDateTime creationDate,@Param("creationDateFin") LocalDateTime creationDate2);
 
}
