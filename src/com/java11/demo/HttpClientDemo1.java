package com.java11.demo;

import java.io.IOException;
import java.net.Authenticator;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Redirect;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

public class HttpClientDemo1 {
	public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Hello world!");
        post("https://postman-echo.com/get?uname=balaji&pwd=12131", "");
    }


    public static String post(String url, String data) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newBuilder().build();
        
        HttpRequest request =
                HttpRequest.newBuilder()
                        .uri(URI.create(url))
                        .GET()
                        .version(Version.HTTP_2)
                        .build();

        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        System.out.println(response.statusCode());
        System.out.println(response.body());
        
        if (response.statusCode() != 200) {
        	System.out.println(response.body());
            throw new IOException("HTTP response status: " + response.statusCode());
        }

        return response.body();
    }
    
    
    
    
    
    public void postAsync(
    	    String url, String data, Consumer<String> consumer, IntConsumer errorHandler) {
    	  HttpClient client = HttpClient.newHttpClient();

    	  HttpRequest request =
    	      HttpRequest.newBuilder()
    	          .uri(URI.create(url))
    	          .header("Content-Type", "application/json")
    	          .POST(BodyPublishers.ofString(data))
    	          .build();

    	  client
    	      .sendAsync(request, BodyHandlers.ofString())
    	      .thenAccept(
    	          response -> {
    	            if (response.statusCode() == 200) {
    	              consumer.accept(response.body());
    	            } else {
    	              errorHandler.accept(response.statusCode());
    	            }
    	          });
    	}

}
