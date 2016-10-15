package com.whitehare.java.http;

public class DoHTTP
{

  public static void main(String[] args)
  {
    // TODO Auto-generated method stub
    HttpURLConnectionExample myHttp = new HttpURLConnectionExample();

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
