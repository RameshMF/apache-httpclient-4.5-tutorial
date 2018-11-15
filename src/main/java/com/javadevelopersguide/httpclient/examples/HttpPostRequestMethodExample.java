package com.javadevelopersguide.httpclient.examples;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * This example demonstrates the use of {@link HttpPost} request method.
 */
public class HttpPostRequestMethodExample {

	public static void main(String[] args) throws IOException {
		postUser();
	}
    public static void post() throws IOException {
    	
        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
            HttpPost httpPost = new HttpPost("http://httpbin.org/post");
            httpPost.setEntity(new StringEntity("Hello, World"));

            System.out.println("Executing request " + httpPost.getRequestLine());

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
            String responseBody = httpclient.execute(httpPost, responseHandler);
            System.out.println("----------------------------------------");
            System.out.println(responseBody);
        }
    }
    
    public static void postUser() throws IOException {
        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
            HttpPost httpPost = new HttpPost("http://localhost:8080/api/v1/users");
            httpPost.setHeader("Accept", "application/json");
			httpPost.setHeader("Content-type", "application/json");
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
            httpPost.setEntity(stringEntity);

            System.out.println("Executing request " + httpPost.getRequestLine());

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
            String responseBody = httpclient.execute(httpPost, responseHandler);
            System.out.println("----------------------------------------");
            System.out.println(responseBody);
        }
    }
}