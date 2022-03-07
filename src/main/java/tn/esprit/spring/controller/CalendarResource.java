package tn.spring.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.spring.services.CalendarService;
 import tn.spring.entities.Calendar;
import tn.spring.entities.CalendarEvent;
 

@RestController
 
public class CalendarResource {

	@Autowired
	private CalendarService calendarService;

	

	@GetMapping("/calendars/{id}")
	public Calendar retrieveCalendar(@PathVariable long id)  
	{
		Calendar calendar = calendarService.retrieveCalendar(id);
		if(calendar != null)
		{
 		
			return calendar;
		}
		return calendar;
	}

	@GetMapping("/calendars")
	@ResponseBody
	public List<Calendar> retrieveAllCalendars() {
		return calendarService.retrieveAllCalendars();
	}

	@PostMapping(value = "/calendars/add")
	public Calendar addCalendar(@RequestBody Calendar calendar)  
	{
		if(calendar.getUser() != null)
		{
			return calendarService.addCalendar(calendar);			
		}
		return calendar;
	 
	}
	
	@PutMapping(value = "/calendars/update")
	public Calendar updateCalendar(@RequestBody Calendar calendar) 
	{
		Calendar updated = calendarService.updateCalendar(calendar);
		if(updated != null)
		{
			return updated;
		}
		return updated;
		 
	}
	
	@DeleteMapping(value = "/calendars/delete")
	public void deleteCalendar(@RequestBody Calendar calendar) {
		calendarService.deleteCalendar(calendar);
	}
	
	@PostMapping("/calendars/search")
	public List<CalendarEvent> searchEvents(@RequestParam  String start,@RequestParam  String end) 
	{
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		 
			String startDateTime = start;
			String endDateTime = end;
			
			 
				LocalDateTime start1 = LocalDateTime.parse(startDateTime, formatter);
				LocalDateTime end1 = LocalDateTime.parse(endDateTime, formatter);
				List<CalendarEvent> calendarEvents = calendarService.findByEventDateTimeBetween(start1, end1);
 				return calendarEvents;
	}
}