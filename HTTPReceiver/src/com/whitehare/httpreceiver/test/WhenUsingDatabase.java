package com.whitehare.httpreceiver.test;

import org.junit.Test;

import com.whitehare.httpreceiver.controller.CreateCardSwipe;

public class WhenUsingDatabase
{

  @Test
  public void shouldWriteDate()
  {
    String cardnumber = "987654321";
    String classroom = "210";
    CreateCardSwipe ccs = new CreateCardSwipe();
    ccs.saveCardClass(cardnumber, classroom);
  }

}
