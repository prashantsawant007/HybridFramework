package com.excelread;

	import java.io.FileInputStream;
	import java.util.Iterator;

	import org.apache.poi.ss.usermodel.Cell;
	import org.apache.poi.ss.usermodel.CellType;
	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;

	public class xls_Reader {
		public static void main(String[] args) {
			try {
				FileInputStream fis=new FileInputStream("C:\\Users\\Lenovo\\OneDrive\\Desktop\\PSA material\\HybridFramework.xlsx");
				XSSFWorkbook workBook = new XSSFWorkbook(fis);
				XSSFSheet sheetAt = workBook.getSheetAt(0);
				Iterator<Row> iterator = sheetAt.iterator();
				while(iterator.hasNext()) {
					Row row = iterator.next();
					Iterator<Cell> cellIterator = row.cellIterator();
					while(cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if(cell.getCellType()==CellType.STRING) {
						System.out.println(cell.getStringCellValue());
						}
						else if(cell.getCellType()==CellType.NUMERIC) {
							System.out.println(cell.getNumericCellValue());
						}
						
					}
					}
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

		public String getCellData(String string, String string2) {
			// TODO Auto-generated method stub
			return null;
		}

		public String getCellData1(String string, String string2) {
			// TODO Auto-generated method stub
			return null;
		}

		

	
		}
	



