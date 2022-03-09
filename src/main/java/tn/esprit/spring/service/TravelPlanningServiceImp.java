package tn.esprit.spring.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.itextpdf.text.DocumentException;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.Repository.TravelRepository;
import tn.esprit.spring.entity.TravelPlanning;

@Service
@Slf4j
public class TravelPlanningServiceImp implements ITravelPlanningService {
	


@Autowired
TravelRepository travelRepository;

	@Override
	public List<TravelPlanning> getAllTravelPlanning() {
	List<TravelPlanning> TravelPlannings =  travelRepository.findAll();
	return TravelPlannings;
		
	}

	@Override
	public TravelPlanning addTravelPlanning(TravelPlanning t)  {
	
		try   
		{  
		//declare file name to be create   
		String filename = "C:\\Users\\PC\\Desktop\\PdfFiles\\TravelPlanning.xls";  
		//creating an instance of HSSFWorkbook class  
		HSSFWorkbook workbook = new HSSFWorkbook();  
		//invoking creatSheet() method and passing the name of the sheet to be created   
		HSSFSheet sheet = workbook.createSheet("TravelPlanning");   
		//creating the 0th row using the createRow() method  
		HSSFRow rowhead = sheet.createRow((short)0);  
		//creating cell by using the createCell() method and setting the values to the cell by using the setCellValue() method  
		rowhead.createCell(0).setCellValue("Destination");  
		rowhead.createCell(1).setCellValue("Duration");  
		rowhead.createCell(2).setCellValue("Start_Date");  
		rowhead.createCell(3).setCellValue("End_Date");  
 
		//creating the 1st row  
		HSSFRow row = sheet.createRow((short)1);  
		//inserting data in the first row
		
	
		
		row.createCell(0).setCellValue(t.getDestination());  
		row.createCell(1).setCellValue(t.getDuration());  
		row.createCell(2).setCellValue(t.getStartDate());  
		row.createCell(3).setCellValue(t.getEndDate());  
		
		FileOutputStream fileOut = new FileOutputStream(filename);  
		workbook.write(fileOut);  
		//closing the Stream  
		fileOut.close();  
		//closing the workbook  
		workbook.close();  
		//prints the message on the console  
		System.out.println("Excel file has been generated successfully.");  
		}   
		catch (Exception e)   
		{  
		e.printStackTrace();  
		}  
		//prints the message on the console  
		System.out.println("Excel file has been generated successfully.");  
		
		return travelRepository.save(t);
		

	
}

	@Override
	public TravelPlanning updateTravelPlanning(TravelPlanning t) {
		return travelRepository.save(t);
	}

	@Override
	public TravelPlanning getTravelPlanningById(long Id) {
		return travelRepository.findById(Id).get();
	}

	@Override
	public void deleteTravelPlanningById(long Id) {
		this.travelRepository.deleteById(Id);
		
	}



	

}
