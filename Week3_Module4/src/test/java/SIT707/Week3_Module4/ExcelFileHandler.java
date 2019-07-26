package SIT707.Week3_Module4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ExcelFileHandler {
	public List<List<String>> readFromFile(String fileName){ 
		List<List<String>> table = new ArrayList<List<String>>(); //2D Array to represent column, row
		try {
			FileInputStream file = new FileInputStream(new File(fileName));
			HSSFWorkbook workbook = new HSSFWorkbook(file);
			HSSFSheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rowIterator = sheet.iterator();
			while(rowIterator.hasNext()) {
				List<String> rowData = new ArrayList<String>();
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					switch(cell.getCellType()) {
					case Cell.CELL_TYPE_BOOLEAN:
						rowData.add(String.valueOf(cell.getBooleanCellValue()));
						break;
					case Cell.CELL_TYPE_NUMERIC:
						rowData.add(String.valueOf(cell.getNumericCellValue()));
						break;
					case Cell.CELL_TYPE_STRING:
						rowData.add(cell.getStringCellValue());
						break;
					}
			
				}
				table.add(rowData);
			}
			
		} catch(FileNotFoundException e) {
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return table;		
	}
	
	public void writeToFile(String fileName, List<String> results) {
		try {
			FileInputStream file = new FileInputStream(new File(fileName));
			HSSFWorkbook workbook = new HSSFWorkbook(file);
			HSSFSheet sheet = workbook.getSheetAt(0);
			Cell cell = null;
			
			for (int i = 0; i < results.size(); i++ ) {
				cell = sheet.getRow(i).getCell(2);
				cell.setCellValue(results.get(i)); //write the value into the cell
			}
			file.close();
			FileOutputStream updateFile = new FileOutputStream(new File("Update" + fileName));
			workbook.write(updateFile);
			updateFile.close();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
