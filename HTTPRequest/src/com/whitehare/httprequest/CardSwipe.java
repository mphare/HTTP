package com.whitehare.httprequest;

import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.log4j.Logger;

import com.whitehare.httprequest.properties.ConfigProperties;

public class CardSwipe
{
  private final String  USER_AGENT    = "Mozilla/5.0";
  private String        serverAddress = "http://localhost:8080";
  private String        classRoom     = "0000";
  private static Logger logger        = Logger.getLogger(CardSwipe.class);

  public void sendSwipedCard(String cardnumber, String classroom) throws Exception
  {

    ConfigProperties cfgProp = new ConfigProperties();

    cfgProp.getPropertyValues();

    serverAddress = cfgProp.getServerURI();
    logger.info("Server Address: " + serverAddress + " Class Room: " + classRoom);

    String url = serverAddress + "/AttendanceServer/web/send/swipe?cardnumber=" + cardnumber + "&classroom="
        + classroom;
    System.out.println("Swiping Card: card number: " + cardnumber + " classroom: " + classroom + " URL: " + url);
    URL obj = new URL(url);
    HttpURLConnection con = (HttpURLConnection) obj.openConnection();
    con.setRequestMethod("POST");
    con.setRequestProperty("User-Agent", USER_AGENT);
    con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
    int responseCode = con.getResponseCode();
    System.out.println("POST: Response Code : " + responseCode);
  }
}
