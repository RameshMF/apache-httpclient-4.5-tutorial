package com.javadevelopersguide.httpclient.examples;

import java.io.IOException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class GETRequestExample {
	private static final String SAMPLE_URL = "http://www.github.com";

	public static void main(final String[] args) throws IOException {
		try (CloseableHttpClient httpclient = HttpClients.createDefault();) {
			final HttpGet httpget = new HttpGet(SAMPLE_URL);
			final CloseableHttpResponse response = httpclient.execute(httpget);

			// get the Status Code of the HTTP Response
			final int statusCode = response.getStatusLine().getStatusCode();
			// get the Media Type of the response
			final String contentMimeType = ContentType.getOrDefault(response.getEntity()).getMimeType();
			// get the body of the response

			System.out.println("statusCode ::" + statusCode);
			System.out.println("contentMimeType ::" + contentMimeType);
			//System.out.println("bodyAsString :: " + bodyAsString);
		}
	}

}
