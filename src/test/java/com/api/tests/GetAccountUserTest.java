package com.api.tests;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.utils.SpecUtil;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.specification.RequestSpecification;

public class GetAccountUserTest {

	@Test(description = "to verify account details are coming correct in response for a valid user", groups = {
			"regression", "smoke" })
	public void getAccountUserTest() {
		RestAssured.given().spec(SpecUtil.requestSpec()).when().get("api/accounts/user").then()
				.spec(SpecUtil.responseSpec()).body("size()", Matchers.greaterThan(0))
				.body("status", Matchers.everyItem(Matchers.equalTo("ACTIVE")))
				.body("balance", Matchers.everyItem(Matchers.greaterThan(0.0f))).body(JsonSchemaValidator
						.matchesJsonSchemaInClasspath("Response-schema/accountUserResponseSchema.json"));

	}

}
