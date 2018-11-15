package com.javadevelopersguide.httpclient.examples;

import java.io.File;
import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * This example demonstrates the use of {@link HttpPost} request method.
 * And sending Multipart Form requests
 * @author Ramesh Fadatare
 */
public class HttpClientMultipartUploadExample {
	public static void main(String... args) throws IOException {

		try (CloseableHttpClient httpclient = HttpClients.createDefault()) {

			File file = new File("demo.png");
			String message = "This is a multipart post";

			// build multipart upload request
			HttpEntity data = MultipartEntityBuilder.create().setMode(HttpMultipartMode.BROWSER_COMPATIBLE)
					.addBinaryBody("upfile", file, ContentType.DEFAULT_BINARY, file.getName())
					.addTextBody("text", message, ContentType.DEFAULT_BINARY).build();

			// build http request and assign multipart upload data
			HttpUriRequest request = RequestBuilder.post("http://httpbin.org/post").setEntity(data).build();

			System.out.println("Executing request " + request.getRequestLine());

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
			String responseBody = httpclient.execute(request, responseHandler);
			System.out.println("----------------------------------------");
			System.out.println(responseBody);
		}
	}
}
