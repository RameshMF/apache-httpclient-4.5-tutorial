package com.javadevelopersguide.httpclient.examples;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * This example demonstrates the use of {@link HttpPut} request method.
 * @author Ramesh Fadatare
 */

public class PUTRequestExample {
	
	public static void main(String[] args) throws IOException {
		putUser();
	}
	public static void put() throws IOException {
		try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
			HttpPut httpPut = new HttpPut("http://httpbin.org/put");
			httpPut.setEntity(new StringEntity("Hello, World"));

			System.out.println("Executing request " + httpPut.getRequestLine());

			// Create a custom response handler
			ResponseHandler<String> responseHandler = response -> {
				int status = response.getStatusLine().getStatusCode();
				if (status >= 200 && status < 300) {
					HttpEntity entity = response.getEntity();
					return entity != null ? EntityUtils.toString(entity) : null;
				} else {
					throw new ClientProtocolException("Unexpected response status: " + status);
				}
			};
			String responseBody = httpclient.execute(httpPut, responseHandler);
			System.out.println("----------------------------------------");
			System.out.println(responseBody);
		}
	}
	
	 public static void putUser() throws IOException {
	        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
	        	HttpPut httpPut = new HttpPut("http://localhost:8080/api/v1/users/5");
	            httpPut.setHeader("Accept", "application/json");
				httpPut.setHeader("Content-type", "application/json");
	            String json = "{\r\n" + 
	    				"  \"firstName\": \"Ram\",\r\n" + 
	    				"  \"lastName\": \"Jadhav\",\r\n" + 
	    				"  \"emailId\": \"ramesh1234@gmail.com\",\r\n" + 
	    				"  \"createdAt\": \"2018-09-11T11:19:56.000+0000\",\r\n" + 
	    				"  \"createdBy\": \"Ramesh\",\r\n" + 
	    				"  \"updatedAt\": \"2018-09-11T11:26:31.000+0000\",\r\n" + 
	    				"  \"updatedby\": \"Ramesh\"\r\n" + 
	    				"}";
	            StringEntity stringEntity = new StringEntity(json);
	            httpPut.setEntity(stringEntity);

	            System.out.println("Executing request " + httpPut.getRequestLine());

	            // Create a custom response handler
	            ResponseHandler<String> responseHandler = response -> {
	                int status = response.getStatusLine().getStatusCode();
	                if (status >= 200 && status < 300) {
	                    HttpEntity entity = response.getEntity();
	                    return entity != null ? EntityUtils.toString(entity) : null;
	                } else {
	                    throw new ClientProtocolException("Unexpected response status: " + status);
	                }
	            };
	            String responseBody = httpclient.execute(httpPut, responseHandler);
	            System.out.println("----------------------------------------");
	            System.out.println(responseBody);
	        }
	    }
}
