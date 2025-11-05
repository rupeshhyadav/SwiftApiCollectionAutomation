package com.dataproviders;

import java.util.Iterator;

import org.testng.annotations.DataProvider;

import com.api.request.model.Login;
import com.utils.ExcelReaderUtil;

public class dataProvider {

	@DataProvider(name = "loginApiExcelDataProvider")
	public static Iterator<Login> loginApiExcelDataProvider() {
		return ExcelReaderUtil.loadExcelData("testData/LoginSwiftApiTestData1.xlsx");
	}

}
