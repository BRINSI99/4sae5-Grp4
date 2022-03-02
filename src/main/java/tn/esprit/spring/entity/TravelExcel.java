package tn.esprit.spring.entity;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;





public class TravelExcel {
	private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<TravelPlanning> travelplanning;
    
 
	
	
	public TravelExcel(List<TravelPlanning> travelplanning) {
		this.travelplanning=travelplanning;
		workbook = new XSSFWorkbook();
		
	}

    
    private void writeHeaderLine() {
        sheet = workbook.createSheet("Travels");
         
        Row row = sheet.createRow(0);
         
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);
       
        createCell(row, 0, "Destination", style);  
        createCell(row, 1, "Duration", style);  
        createCell(row, 2, "StartDate", style);    
        createCell(row, 3, "EndDate", style);
        createCell(row, 4, "missionType", style);  
        createCell(row, 5, "reservations", style);  
    }
     
    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        }else {
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(style);
    }


	public void export(HttpServletResponse response) {
		//writeHeaderLine();
	//writeDataLines();
		//workbook.write(outputStream);
		//workbook.close();
	//	outputStream.close();
		
	}


	
   

}
