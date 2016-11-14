package com.whitehare.httprequest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;

import com.whitehare.httprequest.properties.ConfigProperties;

public class DoHTTP
{
  private static Logger logger    = Logger.getLogger(DoHTTP.class);
  private static String classRoom = "1030";

  public static void main(String[] args)
  {
    String cardNumber = "00000000";

    CardSwipe cs = new CardSwipe();
    ConfigProperties cfgProp = new ConfigProperties();

    try
    {
      cfgProp.getPropertyValues();
    } catch (IOException e1)
    {
      e1.printStackTrace();
    }

    // Get the class room from the properties file
    classRoom = cfgProp.getClassRoom();

    logger.info("Starting Card Swipe Reader for: Classroom: " + classRoom);

    BufferedReader br = null;

    try
    {
      // open the connection to the card reader
      br = new BufferedReader(new InputStreamReader(System.in));

      while (true)
      {
        System.out.println("Card Number: ");

        // Read the card number from the card reader
        cardNumber = br.readLine();

        // enter the letter 'q' to quit reading
        if ("q".equals(cardNumber))
        {
          logger.info("Quit Reading Card Swipes for: Classroom: " + classRoom);
          System.out.println("Exit!");
          System.exit(0);
        }
        logger.info("Card Swipe Completed for: Cardnumber: " + cardNumber + " Classroom: " + classRoom);
        cs.sendSwipedCard(cardNumber, classRoom);
      }
    } catch (IOException e)
    {
      logger.info("Card Swipe Failed for: Classroom: " + classRoom);
      e.printStackTrace();
    } catch (Exception e)
    {
      e.printStackTrace();

    } finally
    {
      if (br != null)
      {
        try
        {
          br.close();
        } catch (Exception e)
        {
          e.printStackTrace();
        }
      }
    }
  }
}
