package com.javadevelopersguide.httpclient.examples;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * This example demonstrates the use of {@link HttpDelete} request method.
 * 
 * @author Ramesh Fadatare
 */
public class DELETERequestExample {
	public static void main(String[] args) throws IOException {
		delete();
	}

	public static void delete() throws IOException {
		try (CloseableHttpClient httpclient = HttpClients.createDefault()) {

			HttpDelete httpDelete = new HttpDelete("http://httpbin.org/delete");

			System.out.println("Executing request " + httpDelete.getRequestLine());

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
			String responseBody = httpclient.execute(httpDelete, responseHandler);
			System.out.println("----------------------------------------");
			System.out.println(responseBody);
		}
	}
}
