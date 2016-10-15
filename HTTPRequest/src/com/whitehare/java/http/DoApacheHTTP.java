package com.whitehare.java.http;

public class DoApacheHTTP
{
  public static void main(String[] args)
  {
    // TODO Auto-generated method stub
    ApacheHTTPConnection myHttp = new ApacheHTTPConnection();

    System.out.print("This is a Test");

    try
    {
      myHttp.sendGet();
    } catch (Exception e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
