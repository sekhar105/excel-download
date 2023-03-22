package com.excel.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excel.entity.Marks;
import com.excel.entity.Student;
import com.excel.repository.MarksRepository;
import com.excel.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private MarksRepository marksRepository;
	
	
	public void generate(HttpServletResponse httpServletResponse) throws IOException {
		
		List<Marks> listo=marksRepository.findAll();
		System.out.println(listo);
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet =workbook.createSheet("student marks");
		HSSFRow Row = sheet.createRow(0);
		Row.createCell(0).setCellValue("id");
		Row.createCell(2).setCellValue("studentName");
		Row.createCell(1).setCellValue("english");
		Row.createCell(3).setCellValue("maths");
		Row.createCell(4).setCellValue("telugu");
		Row.createCell(5).setCellValue("science");
		Row.createCell(6).setCellValue("social");
		
		int datarowindex=1;
		for(Marks ls:listo) {
			HSSFRow daRow = sheet.createRow(datarowindex);
			daRow.createCell(0).setCellValue(ls.getId());
			daRow.createCell(2).setCellValue(ls.getStudentName());
			daRow.createCell(3).setCellValue(ls.getEnglish());
			daRow.createCell(4).setCellValue(ls.getMaths());
			daRow.createCell(5).setCellValue(ls.getTelugu());
			daRow.createCell(6).setCellValue(ls.getScience());
			daRow.createCell(7).setCellValue(ls.getSocial());
			datarowindex++;
		}
		
		ServletOutputStream outputStream = httpServletResponse.getOutputStream();
		workbook.write(outputStream);
		workbook.close();
		outputStream.close();
		
		
	}
	
}
