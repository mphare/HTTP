package com.whitehare.attendance.server.test;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.whitehare.attendance.server.controller.CreateSwipe;

public class WhenTestingServerWrites
{
  private static Logger logger = Logger.getLogger(WhenTestingServerWrites.class);

  @Test
  public void shouldwWriteToDatabase()
  {

    CreateSwipe ce = new CreateSwipe();
    ce.saveCardClass("Crimson", "Stark");

  }

}
