package com.whitehare.httprequest.test;

import org.junit.Test;

import com.whitehare.httprequest.CardSwipe;

public class WhenSendingCardSwipe
{
  @Test
  public void shouldSendCardnumberAndClassroom()
  {
    String cardnumber = "12345678";
    String classroom = "100";

    CardSwipe cs = new CardSwipe();

    try
    {
      cs.sendSwipedCard(cardnumber, classroom);
    } catch (Exception e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }
}
