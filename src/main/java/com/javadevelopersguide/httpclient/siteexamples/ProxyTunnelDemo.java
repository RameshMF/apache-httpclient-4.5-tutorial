package com.javadevelopersguide.httpclient.siteexamples;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;

import org.apache.http.HttpHost;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.impl.client.ProxyClient;
import org.apache.http.protocol.HTTP;

/**
 * Example code for using {@link ProxyClient} in order to establish a tunnel through an HTTP proxy.
 */
public class ProxyTunnelDemo {

    public final static void main(String[] args) throws Exception {

        ProxyClient proxyClient = new ProxyClient();
        HttpHost target = new HttpHost("www.yahoo.com", 80);
        HttpHost proxy = new HttpHost("localhost", 8888);
        UsernamePasswordCredentials credentials = new UsernamePasswordCredentials("user", "pwd");
        Socket socket = proxyClient.tunnel(proxy, target, credentials);
        try {
            Writer out = new OutputStreamWriter(socket.getOutputStream(), HTTP.DEF_CONTENT_CHARSET);
            out.write("GET / HTTP/1.1\r\n");
            out.write("Host: " + target.toHostString() + "\r\n");
            out.write("Agent: whatever\r\n");
            out.write("Connection: close\r\n");
            out.write("\r\n");
            out.flush();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream(), HTTP.DEF_CONTENT_CHARSET));
            String line = null;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
        } finally {
            socket.close();
        }
    }

}
