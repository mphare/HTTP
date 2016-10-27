package com.whitehare.attendance.server.test;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.whitehare.attendance.server.controller.CreateSwipe;
import com.whitehare.attendance.server.controller.GetStudents;
import com.whitehare.attendance.server.persistence.Students;
import com.whitehare.attendance.server.service.test.RestEndpointTest;

public class WhenTestingServer
{
  private static Logger logger = Logger.getLogger(RestEndpointTest.class);

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
    List<Students> students = gs.getAllStudents();

    for (Students student : students)
    {
      logger.debug("Firstname: " + student.getFirstName() + " Lastname: " + student.getLastName() + " Cardnumber: "
          + student.getCardNumber());

    }
  }
}
