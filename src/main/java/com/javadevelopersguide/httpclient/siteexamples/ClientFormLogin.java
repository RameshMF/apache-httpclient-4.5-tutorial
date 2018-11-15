package com.javadevelopersguide.httpclient.siteexamples;

import java.net.URI;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

/**
 * A example that demonstrates how HttpClient APIs can be used to perform
 * form-based logon.
 */	
public class ClientFormLogin {

    public static void main(String[] args) throws Exception {
        BasicCookieStore cookieStore = new BasicCookieStore();
        try(CloseableHttpClient httpclient = HttpClients.custom()
                .setDefaultCookieStore(cookieStore)
                .build()){
            HttpUriRequest login = RequestBuilder.post()
                    .setUri(new URI("http://localhost:8080/login"))
                    .addParameter("username", "ramesh24fadatare@gmail.com")
                    .addParameter("password", "Pass@123")
                    .build();
            try(CloseableHttpResponse response = httpclient.execute(login)){
           
                HttpEntity entity = response.getEntity();
                
                System.out.println(entity);
                System.out.println("Login form get: " + response.getStatusLine());

                System.out.println("Post logon cookies:");
                List<Cookie> cookies = cookieStore.getCookies();
                if (cookies.isEmpty()) {
                    System.out.println("None");
                } else {
                    for (int i = 0; i < cookies.size(); i++) {
                        System.out.println("- " + cookies.get(i).toString());
                    }
                }
            }
        }
    }
}