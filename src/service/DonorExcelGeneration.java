package service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;

import modal.Donor;

public class DonorExcelGeneration {

	public void createExcel(List<Donor> donors) throws IOException {
		String[] col = { "UserID", "FirstName", "LastName", "Age", "Weight", "Phonenumber", "City", "Available" };
		// donors = (List<Donor>) donors.get(0);
		int rowNumber = 1;

		try (// create blank workbook
				Workbook wb = new HSSFWorkbook()) {
			// create sheet
			org.apache.poi.ss.usermodel.Sheet sheet = wb.createSheet("Donors");

			// creating Row
			Row row_header = sheet.createRow(0);

			for (int i = 0; i < col.length; i++) {
				Cell cell = row_header.createCell(i);
				cell.setCellValue(col[i]);
			}
			for (Donor donor1 : donors) {
				Row row = sheet.createRow(rowNumber++);
				row.createCell(0).setCellValue(donor1.getUserID());
				row.createCell(1).setCellValue(donor1.getFirstName());
				row.createCell(2).setCellValue(donor1.getLastName());
				row.createCell(3).setCellValue(donor1.getAge());
				row.createCell(4).setCellValue(donor1.getWeight());
				row.createCell(5).setCellValue(donor1.getphonenumber());
				row.createCell(6).setCellValue(donor1.getCity());
				row.createCell(7).setCellValue(donor1.getAvailable());
			}
			OutputStream fileOut = new FileOutputStream("firstprogram.xls");
			wb.write(fileOut);
			fileOut.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Successfully Donor Record has been Created.");
	}
}