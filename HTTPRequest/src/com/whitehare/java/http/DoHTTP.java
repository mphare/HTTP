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
      System.out.println("About to GET\n");
      logger.debug("Client Get Test 1");
      myHttp.sendGet();
    } catch (Exception e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    try
    {
      System.out.println("About to POST\n");
      myHttp.sendPost();
    } catch (Exception e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    try
    {
      System.out.println("About to PUT\n");
      myHttp.sendPut();
    } catch (Exception e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    try
    {
      System.out.println("About to DELETE\n");
      myHttp.sendDelete();
    } catch (Exception e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

}
