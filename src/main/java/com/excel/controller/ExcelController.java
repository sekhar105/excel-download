package com.excel.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.excel.entity.Marks;
import com.excel.entity.Student;
import com.excel.repository.MarksRepository;
import com.excel.repository.StudentRepository;
import com.excel.service.StudentService;

@RestController
public class ExcelController {
	@Autowired
	private StudentRepository  studentRepository;
	@Autowired
	private MarksRepository marksRepository;
	@Autowired
	private StudentService studentService;
//
//	@RequestMapping(value = "/convertFlatFileToExcel.do", method = RequestMethod.POST)
//	public HttpEntity<byte[]> convertFlatFileToExcel(@RequestParam(value="file") MultipartFile file,@RequestParam(value="jobid") String jobid) throws IOException {
//	        ByteArrayOutputStream archivo = new ByteArrayOutputStream();
//	        XSSFWorkbook workbook = new XSSFWorkbook();
//	        workbook.write(archivo);
//	        if(null!=workbook && null!=archivo) {
//	            workbook.close();
//	                        archivo.close();
//	        }
//	    byte[] documentContent = archivo.toByteArray();
//	    HttpHeaders headers = new HttpHeaders();
//	    headers.setContentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"));
//	    headers.set(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"myexcelfile.xls\"");
//	    headers.setContentLength(documentContent.length);
//	return     new ResponseEntity<byte[]>(documentContent, headers, HttpStatus.OK);
//	}
	
//	 @GetMapping(value="/downloadTemplate")
//	    public HttpEntity<ByteArrayResource> createExcelWithTaskConfigurations() throws IOException {
//	        byte[] excelContent = excelService.createExcel();
//
//	        HttpHeaders header = new HttpHeaders();
//	        header.setContentType(new MediaType("application", "force-download"));
//	        header.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=my_file.xlsx");
//
//
//	        return new HttpEntity<>(new ByteArrayResource(excelContent), header);	
//	 
@PostMapping("/add")
	public HttpEntity<?> addStudent(@RequestBody Student student){
		return new ResponseEntity<>(studentRepository.save(student),HttpStatus.OK);
	}
@PostMapping("/addmarks")
public HttpEntity<?> addmarks(@RequestBody Marks marks){
	return new ResponseEntity<>(marksRepository.save(marks),HttpStatus.OK);
}
@GetMapping("/excel")
public void generateExcelReport(HttpServletResponse httpServletResponse) throws IOException {
	httpServletResponse.setContentType("application/octet-stream");
	httpServletResponse.setHeader("Content-Disposition", "attachment;filename=marks.xls");
	
	studentService.generate(httpServletResponse);
}


}
