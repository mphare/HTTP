package com.whitehare.httpreceiver.test;

import java.util.Date;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.whitehare.httpreceiver.beans.CardSwipe;
import com.whitehare.httpreceiver.controller.CreateCardSwipe;

public class WhenUsingDatabase
{
  private static Logger logger = Logger.getLogger(WhenUsingDatabase.class);

  @Test
  public void shouldOpenDatabase()
  {

    logger.debug("About to open the database");

  }

  @Test
  public void shouldWriteDate()
  {
    String cardnumber = "987654321";
    String classroom = "210";
    Date swipeTime = new Date();
    logger.debug("shouldWriteData cardnumber:" + cardnumber + " classroom: " + classroom + " time: " + swipeTime);
    CardSwipe cs = new CardSwipe(cardnumber, classroom, swipeTime);
    CreateCardSwipe ccs = new CreateCardSwipe();
    long retVal = ccs.saveCardSwipe(cs);
  }

}
