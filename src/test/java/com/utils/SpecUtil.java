package com.utils;

import org.apache.http.client.methods.RequestBuilder;
import org.hamcrest.Matchers;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecUtil {

	public static RequestSpecification requestSpec(Object payload) {
		RequestSpecification request = new RequestSpecBuilder()
				.setBaseUri(PropertiesUtil.readFromProperties("BASE_URI")).setContentType(ContentType.JSON)
				.setAccept(ContentType.JSON).log(LogDetail.ALL).setBody(payload).build();
		return request;

	}

	public static RequestSpecification requestSpec() {
		RequestSpecification request = new RequestSpecBuilder()
				.setBaseUri(PropertiesUtil.readFromProperties("BASE_URI")).setContentType(ContentType.JSON)
				.setAccept(ContentType.JSON).log(LogDetail.ALL).addHeader("Authorization", GetAuthToken.getToken())
				.build();
		return request;

	}

	public static ResponseSpecification responseSpec() {
		ResponseSpecification response = new ResponseSpecBuilder().expectContentType(ContentType.JSON)
				.expectStatusCode(200).expectResponseTime(Matchers.lessThan(1000L)).log(LogDetail.ALL).build();
		return response;

	}
}
