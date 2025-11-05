package com.utils;

import java.util.List;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAccountNumberForTxn {

	private GetAccountNumberForTxn() {

	}

	public static void main(String[] args) {
		Response response = RestAssured.given().spec(SpecUtil.requestSpec()).when().get("api/accounts/user").then()
				.spec(SpecUtil.responseSpec()).extract().response();
		List<String> accountNumbers = response.path("accountNumber");
		List<String> createdDates = response.path("createdAt");
		System.out.println(accountNumbers);
		List<Map<String, Object>> accounts = response.jsonPath().getList("$");
		System.out.println(accounts);

	}

}
