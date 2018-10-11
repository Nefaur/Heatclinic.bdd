package com.heatclinic.utilities;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.heatclinic.framework.PropertyReader;


public class ExcelReader{
	
	private FileInputStream file;
	private XSSFWorkbook wb;
	
	public String readExcel(int rownum) throws Exception {
		File excel=new File(PropertyReader.getInstance().getProperty("excelfilepath"));
		FileInputStream file=new FileInputStream(excel);
		this.file=file;
		XSSFWorkbook wb=new XSSFWorkbook(file);
		this.wb=wb;
		XSSFSheet userdata=wb.getSheet("User");
		String data=userdata.getRow(rownum).getCell(1).getStringCellValue();
		return data;
	}
	
	public void close_Excel() throws Exception {
			wb.close();
			file.close();
	}
	
	public CharSequence[] getData(int rownum) {
		try {
			readExcel(rownum);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			close_Excel();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}

	
	
	
	
