package com.javadevelopersguide.httpclient.examples;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * This example demonstrates the use of {@link HttpGet} request method.
 * @author Ramesh Fadatare
 */
public class HttpGetRequestMethodExample {

	public static void main(String[] args) throws IOException {
		getUsers();
		getUserById();
	}
    
    private static void getUsers() throws ClientProtocolException, IOException{
    	 try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
         	
         	//HTTP GET method
             HttpGet httpget = new HttpGet("http://localhost:8080/api/v1/users");
             System.out.println("Executing request " + httpget.getRequestLine());

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
             String responseBody = httpclient.execute(httpget, responseHandler);
             System.out.println("----------------------------------------");
             System.out.println(responseBody);
         }
    }
    
    private static void getUserById() throws IOException{
   	 try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
        	
        	//HTTP GET method
            HttpGet httpget = new HttpGet("http://localhost:8080/api/v1/users/5");
            System.out.println("Executing request " + httpget.getRequestLine());

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
            String responseBody = httpclient.execute(httpget, responseHandler);
            System.out.println("----------------------------------------");
            System.out.println(responseBody);
        }
   }
}
