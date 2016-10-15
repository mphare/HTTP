package com.whitehare.java.http;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpURLConnectionExample
{

  private final String USER_AGENT = "Mozilla/5.0";

  public void sendGet() throws Exception
  {
    String url = "http://whitehare.com";
    URL obj = new URL(url);

    HttpURLConnection con = (HttpURLConnection) obj.openConnection();

    con.setRequestMethod("GET");
    con.setRequestProperty("User-Agent", USER_AGENT);

    int responseCode = con.getResponseCode();

    System.out.println("\nSending: GET request to url : " + url);
    System.out.println("\nResponse Code : " + responseCode);

    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
    String inputLine;
    StringBuffer response = new StringBuffer();
    while ((inputLine = in.readLine()) != null)
    {
      response.append(inputLine);
    }
    in.close();

    System.out.println(response.toString());
  }
}
