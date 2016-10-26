package com.whitehare.httpreceiver.test;

import org.junit.Test;

import com.whitehare.httpreceiver.service.ServiceCenter;

public class WhenReceivingCardSwipe
{
  @Test
  public void shouldSendCardnumberAndClassroom()
  {
    String cardnum = "2224446668";
    String classroom = "202";

    ServiceCenter sc = new ServiceCenter();

    sc.newCardSwipe(cardnum, classroom);
  }

}
