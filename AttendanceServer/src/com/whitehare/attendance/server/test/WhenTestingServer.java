package com.whitehare.attendance.server.test;

import org.junit.Test;

import com.whitehare.attendance.server.controller.CreateSwipe;
import com.whitehare.attendance.server.controller.GetStudents;

public class WhenTestingServer
{
  @Test
  public void shouldwWriteToDatabase()
  {

    CreateSwipe ce = new CreateSwipe();
    ce.saveNameType("Crimson", "Stark");

  }

  @Test
  public void shouldRetrieveStudents()
  {
    GetStudents gs = new GetStudents();
    String results = gs.getAllStudents();
    System.out.println("Student: " + results);
  }
}
