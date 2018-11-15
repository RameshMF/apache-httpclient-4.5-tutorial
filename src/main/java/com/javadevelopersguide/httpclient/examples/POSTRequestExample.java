package com.javadevelopersguide.httpclient.examples;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.auth.AuthenticationException;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

public class POSTRequestExample {
	private static final String SAMPLE_URL = "http://localhost:8082/spring-rest/users";
	private static final String URL_SECURED_BY_BASIC_AUTHENTICATION = "http://browserspy.dk/password-ok.php";
	private static final String DEFAULT_USER = "test";
	private static final String DEFAULT_PASS = "test";

	private static void sendPostRequestWithAuthorizationUsingHttpClient() throws IOException {
		// create the http client
		try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
			final HttpPost httpPost = new HttpPost(SAMPLE_URL + "/detail");

			final String json = "{\"id\":1,\"name\":\"John\"}";
			final StringEntity entity = new StringEntity(json);
			httpPost.setEntity(entity);
			httpPost.setHeader("Accept", "application/json");
			httpPost.setHeader("Content-type", "application/json");

			final CloseableHttpResponse response = httpclient.execute(httpPost);
			System.out.println(response.getStatusLine().getStatusCode());
		}
	}

	private static void sendPostJsonUsingHttpClient() throws IOException {
		// create the http client
		try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
			final HttpPost httpPost = new HttpPost(URL_SECURED_BY_BASIC_AUTHENTICATION);

			httpPost.setEntity(new StringEntity("test post"));
			final UsernamePasswordCredentials creds = new UsernamePasswordCredentials(DEFAULT_USER, DEFAULT_PASS);
			try {
				httpPost.addHeader(new BasicScheme().authenticate(creds, httpPost, null));
			} catch (AuthenticationException e) {
				e.printStackTrace();
			}

			final CloseableHttpResponse response = httpclient.execute(httpPost);
			System.out.println(response.getStatusLine().getStatusCode());
		}
	}

	private static void sendPostRequestUsingHttpClient() throws IOException {
		// create the http client
		try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
			// send basic POST request
			final HttpPost httpPost = new HttpPost(SAMPLE_URL);

			final List<NameValuePair> params = new ArrayList<NameValuePair>();
			params.add(new BasicNameValuePair("username", DEFAULT_USER));
			params.add(new BasicNameValuePair("password", DEFAULT_PASS));

			httpPost.setEntity(new UrlEncodedFormEntity(params));
			final CloseableHttpResponse response = httpclient.execute(httpPost);
			System.out.println(response.getStatusLine().getStatusCode());
		}
	}

	public void whenSendMultipartRequestUsingHttpClient_thenCorrect() throws IOException {
		try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
			final HttpPost httpPost = new HttpPost(SAMPLE_URL + "/multipart");

			final MultipartEntityBuilder builder = MultipartEntityBuilder.create();
			builder.addTextBody("username", DEFAULT_USER);
			builder.addTextBody("password", DEFAULT_PASS);
			builder.addBinaryBody("file", new File("src/test/resources/test.in"), ContentType.APPLICATION_OCTET_STREAM,
					"file.ext");
			final HttpEntity multipart = builder.build();

			httpPost.setEntity(multipart);

			final CloseableHttpResponse response = httpclient.execute(httpPost);
			System.out.println(response.getStatusLine().getStatusCode());
		}
	}

	public void whenUploadFileUsingHttpClient_thenCorrect() throws IOException {
		// create the http client
		try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
			final HttpPost httpPost = new HttpPost(SAMPLE_URL + "/upload");

			final MultipartEntityBuilder builder = MultipartEntityBuilder.create();
			builder.addBinaryBody("file", new File("src/test/resources/test.in"), ContentType.APPLICATION_OCTET_STREAM,
					"file.ext");
			final HttpEntity multipart = builder.build();

			httpPost.setEntity(multipart);

			final CloseableHttpResponse response = httpclient.execute(httpPost);
			System.out.println(response.getStatusLine().getStatusCode());
		}
	}

}
