package com.whitehare.httprequest;

import java.net.HttpURLConnection;
import java.net.URL;

public class CardSwipe
{
  private final String USER_AGENT = "Mozilla/5.0";

  public void sendSwipedCard(String cardnumber, String classroom) throws Exception
  {
    String url = "http://localhost:8080/HTTPReceiver/send/swipe?cardnumber=" + cardnumber + "&classroom=" + classroom;
    System.out.println("\nSwiping Card: card number: " + cardnumber + " classroom: " + classroom + " URL: " + url);
    URL obj = new URL(url);
    HttpURLConnection con = (HttpURLConnection) obj.openConnection();
    con.setRequestMethod("POST");
    con.setRequestProperty("User-Agent", USER_AGENT);
    con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
    int responseCode = con.getResponseCode();
    System.out.println("\nPOST: Response Code : " + responseCode);
  }
}
