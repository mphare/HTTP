package com.whitehare.httprequest;

import org.apache.log4j.Logger;

public class DoHTTP
{
  private static Logger logger    = Logger.getLogger(DoHTTP.class);
  private static String classRoom = "1030";

  public static void main(String[] args)
  {
    String cardNumber = "1020304";
    // TODO Auto-generated method stub
    // HttpURLConnectionExample myHttp = new HttpURLConnectionExample();
    CardSwipe cs = new CardSwipe();

    logger.debug("Testing a Card Swipe for: Cardnumber: " + cardNumber + " Classroom: " + classRoom);
    try
    {
      System.out.println("\nAbout to POST a Swiped Card");
      cs.sendSwipedCard(cardNumber, classRoom);
      logger.debug("Card Swipe Completed for: Cardnumber: " + cardNumber + " Classroom: " + classRoom);
    } catch (Exception e)
    {
      // TODO Auto-generated catch block
      logger.debug("Card Swipe Failed for: Cardnumber: " + cardNumber + " Classroom: " + classRoom);
      e.printStackTrace();
    }

  }

}
