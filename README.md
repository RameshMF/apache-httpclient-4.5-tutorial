<div dir="ltr" style="text-align: left;" trbidi="on">
<style>
.font-family-page {
    font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Helvetica, Arial, sans-serif, "Apple Color Emoji", "Segoe UI Emoji", "Segoe UI Symbol";
}
a {
    font-weight: bold;
}
</style>

<div class="font-family-page">
This tutorial describes how to use the Apache HttpClient library for accessing HTTP resources. This tutorial is based on Apache HttpClient 4.5+.<br>
<h2 style="text-align: left;">
HttpClient Overview</h2>
As we know that&nbsp;<i>java.net</i> package provides basic functionality for accessing resources via HTTP, it doesn't provide the full flexibility or functionality needed by many applications. <i>HttpClient</i> seeks to fill this void by providing an efficient, up-to-date, and feature-rich package implementing the client side of the most recent HTTP standards and recommendations.<br>
<br>
Designed for extension while providing robust support for the base HTTP protocol, <i>HttpClient</i> may be of interest to anyone building HTTP-aware client applications such as web browsers, web service clients, or systems that leverage or extend the HTTP protocol for distributed communication.<br>
<h2 style="text-align: left;">
Apache HttpClient Usage and Examples</h2>
<div>
<ul style="text-align: left;">
<li><a href="http://www.javaguides.net/2018/10/apache-httpclient-get-http-request-example.html" target="_blank">Apache HttpClient GET HTTP Request Example</a></li>
In this quick article, we will discuss step by step how to use Apache HttpClient 4.5 to make an Http GET request.<br>
<br>
<li><a href="http://www.javaguides.net/2018/10/apache-httpclient-post-http-request-example.html" target="_blank">Apache HttpClient POST HTTP Request Example</a></li>
In this quick article, we will discuss step by step how to use Apache HttpClient 4.5 to make an HTTP POST request. The HTTP POST request method requests that the server accepts the entity enclosed in the request as a new subordinate of the web resource identified by the URI.</ul>
</div>
<div>
<ul style="text-align: left;">
<li><a href="http://www.javaguides.net/2018/10/apache-httpclient-put-http-request-example.html" target="_blank">Apache HttpClient PUT HTTP Request Example</a></li>
In this quick article, we will discuss step by step how to use Apache HttpClient 4.5 to make an HTTP PUT request.<br>
<br>
<li><a href="http://www.javaguides.net/2018/10/apache-httpclient-delete-http-request-example.html" target="_blank">Apache HttpClient DELETE HTTP Request Example</a></li>
In this quick article, we will discuss step by step how to use Apache HttpClient 4.5 to make an HTTP DELETE request. The HTTP DELETE Request Method requests delete the resource specified by the URI.</ul>
<ul style="text-align: left;">
<li><a href="http://www.javaguides.net/2018/10/apache-httpclient-html-form-post-request-example.html" target="_blank">Apache HttpClient HTML Form POST Request Example</a></li>
This tutorial will illustrate how to configure Basic Authentication on the Apache HttpClient 4.5+.</ul>
<ul style="text-align: left;">
<li><a href="http://www.javaguides.net/2018/10/apache-httpclient-basic-authentication-exammples.html" target="_blank">Apache HttpClient Basic Authentication Examples</a></li>
This tutorial will illustrate how to configure Basic Authentication on the Apache HttpClient 4.5+.</ul>
<ul style="text-align: left;">
<li><a href="http://www.javaguides.net/2018/10/apache-httpclient-upload-file-example.html" target="_blank">Apache HttpClient Upload File Example</a></li>
In this article, we will illustrate how to do a multipart upload operation using Apache HttpClient 4.5+.</ul>
<ul style="text-align: left;">
<li><a href="http://www.javaguides.net/2018/10/apache-httpclient-get-post-put-and-delete-methods-example.html" target="_blank">Apache HttpClient GET, POST, PUT and DELETE Methods Tutorial</a></li>
In this tutorial, we will discuss how to use Apache HttpClient 4.5 to make an HTTP GET, POST, PUT and DELETE requests.<br>

</ul>
</div>
<div>
<h2 style="text-align: left;">
Apache HttpClient Features</h2>
<ul style="text-align: left;">
<li>Standards-based, pure Java, implementation of HTTP versions 1.0 and 1.1</li>
<li>Full implementation of all HTTP methods (GET, POST, PUT, DELETE, HEAD, OPTIONS, and TRACE) in an extensible OO framework.</li>
<li>Supports encryption with HTTPS (HTTP over SSL) protocol.</li>
<li>Transparent connections through HTTP proxies.</li>
<li>Tunneled HTTPS connections through HTTP proxies, via the CONNECT method.</li>
<li>Basic, Digest, NTLMv1, NTLMv2, NTLM2 Session, SNPNEGO, Kerberos authentication schemes.</li>
<li>Plug-in mechanism for custom authentication schemes.</li>
<li>Pluggable secure socket factories, making it easier to use third-party solutions</li>
<li>Connection management support for use in multi-threaded applications. Supports setting the maximum total connections as well as the maximum connections per host. Detects and closes stale connections.</li>
<li>Automatic Cookie handling for reading Set-Cookie: headers from the server and sending them back out in a Cookie: header when appropriate.</li>
<li>Plug-in mechanism for custom cookie policies.</li>
<li>Request output streams to avoid buffering any content body by streaming directly to the socket to the server.</li>
<li>Response input streams to efficiently read the response body by streaming directly from the socket to the server.</li>
<li>Persistent connections using KeepAlive in HTTP/1.0 and persistence in HTTP/1.1</li>
<li>Direct access to the response code and headers sent by the server.</li>
<li>The ability to set connection timeouts.</li>
<li>Support for HTTP/1.1 response caching.</li>
<li>The source code is freely available under the Apache License.</li>
</ul>
<h2 style="text-align: left;">
Useful Links and Resources</h2>
<ul>
<li><a href="https://www.baeldung.com/httpclient-ssl">HttpClient with SSL</a> (popular)</li>
<li><a href="https://www.baeldung.com/unshorten-url-httpclient">Unshorten URLs with HttpClient</a></li>
<li><a href="https://www.baeldung.com/httpclient-4-cookies">Send a Custom Cookie</a></li>
<li><a href="https://www.baeldung.com/httpclient-redirect-on-http-post">Follow Redirects for POST Requests</a></li>
<li><a href="https://www.baeldung.com/httpasyncclient-tutorial">HttpAsyncClient Tutorial</a></li>
<li><a href="https://www.baeldung.com/httpclient-connection-management">HttpClient Connection Management</a></li>
<li><a href="https://hc.apache.org/httpcomponents-client-4.5.x/tutorial/html/index.html" target="_blank">HttpClient Tutorial</a>&nbsp;// Apache HttpClient official tutorial</li>
<li><a href="https://hc.apache.org/httpcomponents-client-4.5.x/examples.html" target="_blank">HttpClient Examples</a>&nbsp;// Apache HttpClient Examples</li>
<li><a href="https://hc.apache.org/httpcomponents-client-4.5.x/index.html" target="_blank">Apache HttpClient Documentation</a>&nbsp;// Apache HttpClient Documentation</li>
</ul>
<h2 style="text-align: left;">
References</h2>
<div style="text-align: left;">
</div>
</div>
<div>
<ul>
<li><a href="https://hc.apache.org/httpcomponents-client-4.5.x/tutorial/html/index.html" target="_blank">HttpClient Tutorial</a>&nbsp;// Apache HttpClient official tutorial</li>
<li><a href="https://hc.apache.org/httpcomponents-client-4.5.x/examples.html" target="_blank">HttpClient Examples</a>&nbsp;// Apache HttpClient Examples</li>
<li><a href="https://hc.apache.org/httpcomponents-client-4.5.x/index.html" target="_blank">Apache HttpClient Documentation</a>&nbsp;// Apache HttpClient Documentation</li>
</ul>
</div>
</div>
</div>
