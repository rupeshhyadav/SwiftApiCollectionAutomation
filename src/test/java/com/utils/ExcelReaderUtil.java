package com.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.api.request.model.Login;

public class ExcelReaderUtil {

	public static Iterator<Login> loadExcelData(String filePath) {

		InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(filePath);
		XSSFWorkbook mywb = null;
		try {
			mywb = new XSSFWorkbook(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		XSSFSheet mysheet = mywb.getSheet("Sheet1");
		XSSFRow headerRow = mysheet.getRow(0);
		int usernameIndex = -1;
		int passwordIndex = -1;
		for (Cell cell : headerRow) {
			if (cell.getStringCellValue().equalsIgnoreCase("username")) {
				usernameIndex = cell.getColumnIndex();
			}
			if (cell.getStringCellValue().equalsIgnoreCase("password")) {
				passwordIndex = cell.getColumnIndex();
			}
		}
		// System.out.println(usernameIndex + "---" + passwordIndex);
		int lastRowIndex = mysheet.getLastRowNum();
		ArrayList<Login> userList = new ArrayList<Login>();
		XSSFRow myRow;
		Login login;
		for (int i = 1; i <= lastRowIndex; i++) {
			myRow = mysheet.getRow(i);
			if (myRow.getCell(usernameIndex) == null || myRow.getCell(passwordIndex) == null)
				continue;
			login = new Login(myRow.getCell(usernameIndex).toString(), myRow.getCell(passwordIndex).toString());
			userList.add(login);
		}
		return userList.iterator();

	}

}
