package com.whitehare.attendance.server.test;

import org.junit.Test;

import com.whitehare.attendance.server.controller.CreateSwipe;

public class WhenTestingServer
{
  @Test
  public void shouldwWriteToDatabase()
  {

    CreateSwipe ce = new CreateSwipe();
    ce.saveNameType("Crimson", "Stark");

  }
}
