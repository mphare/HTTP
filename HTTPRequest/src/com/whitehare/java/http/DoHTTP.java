package com.whitehare.java.http;

import org.apache.log4j.Logger;

public class DoHTTP
{
  private static Logger logger = Logger.getLogger(DoHTTP.class);

  public static void main(String[] args)
  {
    // TODO Auto-generated method stub
    HttpURLConnectionExample myHttp = new HttpURLConnectionExample();

    System.out.print("This is a Test\n");

    try
    {
      System.out.println("\nAbout to GET");
      logger.debug("Client Get Test 1");
      myHttp.sendGet();
    } catch (Exception e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    try
    {
      System.out.println("\nAbout to POST");
      myHttp.sendPost();
    } catch (Exception e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    try
    {
      System.out.println("\nAbout to PUT");
      myHttp.sendPut();
    } catch (Exception e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    try
    {
      System.out.println("\nAbout to DELETE");
      myHttp.sendDelete();
    } catch (Exception e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

}
