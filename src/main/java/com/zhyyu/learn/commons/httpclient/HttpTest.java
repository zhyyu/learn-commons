package com.zhyyu.learn.commons.httpclient;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

/**
 * test https
 * @see <a href="https://hc.apache.org/httpcomponents-client-4.5.x/quickstart.html">httpcomponents</a>
 * 
 * @author Administrator
 *
 */
public class HttpTest {

	private static final String HOST = "http://www.baeldung.com/";
	
	public static void main(String[] args) throws IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(HOST);
		CloseableHttpResponse response1 = httpclient.execute(httpGet);
		// The underlying HTTP connection is still held by the response object
		// to allow the response content to be streamed directly from the network socket.
		// In order to ensure correct deallocation of system resources
		// the user MUST call CloseableHttpResponse#close() from a finally clause.
		// Please note that if response content is not fully consumed the underlying
		// connection cannot be safely re-used and will be shut down and discarded
		// by the connection manager. 
		try {
		    System.out.println(response1.getStatusLine());
		    
		    HttpEntity entity1 = response1.getEntity();
		    // do something useful with the response body
		    // and ensure it is fully consumed
		    InputStream inputStream = entity1.getContent();
		    
		    FileUtils.copyToFile(inputStream, new File("F:\\baeldung.html"));
		} finally {
		    response1.close();
		}

	}
	
}
