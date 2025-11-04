package com.utils;

import com.api.request.model.Login;

import io.restassured.RestAssured;

public class GetAuthToken {

	private GetAuthToken() {

	}

	public static String getToken() {
		Login login = new Login("Rupesh", "Rup0101**");
		String token = RestAssured.given().spec(SpecUtil.requestSpec(login)).when().post("api/auth/login").then()
				.spec(SpecUtil.responseSpec()).extract().jsonPath().getString("token");
		token = "Bearer " + token;
		return token;
	}

}
