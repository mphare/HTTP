package com.whitehare.httprequest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpURLConnectionExample
{

  private final String USER_AGENT = "Mozilla/5.0";

  public void sendGet() throws Exception
  {
    String url = "http://localhost:8080/HTTPReceiver/test/get2";
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

  public void sendPut() throws Exception
  {
    String url = "http://localhost:8080/HTTPReceiver/test/put?cardnum=1234&classroom=Math";
    URL obj = new URL(url);
    HttpURLConnection con = (HttpURLConnection) obj.openConnection();
    con.setRequestMethod("PUT");
    con.setRequestProperty("User-Agent", USER_AGENT);
    con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
    int responseCode = con.getResponseCode();
    System.out.println("\nPUT: Response Code : " + responseCode);
  }

  public void sendPost() throws Exception
  {
    String url = "http://localhost:8080/HTTPReceiver/test/post?studentid=55543";
    URL obj = new URL(url);
    HttpURLConnection con = (HttpURLConnection) obj.openConnection();
    con.setRequestMethod("POST");
    con.setRequestProperty("User-Agent", USER_AGENT);
    con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
    int responseCode = con.getResponseCode();
    System.out.println("\nPOST: Response Code : " + responseCode);
  }

  public void sendDelete() throws Exception
  {
    String url = "http://localhost:8080/HTTPReceiver/test/delete?studentid=373737373";
    URL obj = new URL(url);
    HttpURLConnection con = (HttpURLConnection) obj.openConnection();
    con.setRequestMethod("DELETE");
    con.setRequestProperty("User-Agent", USER_AGENT);
    con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
    int responseCode = con.getResponseCode();
    System.out.println("\nDELETE: Response Code : " + responseCode);

  }

}
