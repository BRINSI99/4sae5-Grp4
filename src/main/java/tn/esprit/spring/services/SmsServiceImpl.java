package tn.spring.services;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

 
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.spring.entities.Employee;
import tn.spring.entities.Send;
import tn.spring.repository.SendRepository;

 
 
public class SmsServiceImpl implements ISend {
	@Autowired
	private SendRepository SendRepo;
	 
	 
	 

 





	@Override
	public void addSms(Send p) {
 
	SendRepo.save(p);
	 
	}
	@Override
	public List<Send> getAllSms()
	{
		return SendRepo.findAll();
	}
 
 
}
