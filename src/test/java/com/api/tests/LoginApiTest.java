package com.api.tests;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.api.request.model.Login;
import com.utils.PropertiesUtil;
import com.utils.SpecUtil;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;

public class LoginApiTest {
	Login login = new Login("Rupesh", "Rup0101**");

	@Test(description = "to verify the login api", groups = { "regression", "smoke" })
	public void loginApiTest() {
		RestAssured.given().spec(SpecUtil.requestSpec(login))
		.when().post("api/auth/login")
		.then().spec(SpecUtil.responseSpec())
		.and()
		.body("username", Matchers.equalTo(login.getUsername()))
		.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("Response-schema/loginResponseSchema.json"))
		.body("id", Matchers.notNullValue());
	}

}
