package com.whitehare.attendance.server.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.whitehare.attendance.server.controller.GetStudents;
import com.whitehare.attendance.server.controller.GetSwipes;
import com.whitehare.attendance.server.persistence.Students;
import com.whitehare.attendance.server.persistence.TestJoin;

public class WhenTestingServerReads
{
  private static Logger logger = Logger.getLogger(WhenTestingServerReads.class);

  // @Test
  public void shouldRetrieveCardSwipes()
  {
    logger.info("About to shouldRetrieveCardSwipes");
    GetSwipes gs = new GetSwipes();
    List<TestJoin> testjoins = new ArrayList<TestJoin>();

    testjoins = gs.getAllCardSwipes();

    logger.info("Size: " + testjoins.size() + " Number(1) " + testjoins.get(0).getCardNumber().toString());

    for (TestJoin testjoin : testjoins)
    {
      logger.info("[][]> " + testjoin.getCardNumber());
    }
  }

  @Test
  public void shouldRetrieveStudents()
  {
    logger.info("About to shouldRetrieveStudents");
    GetStudents gs = new GetStudents();
    List<Students> students = gs.getAllStudents();

    for (Students student : students)
    {
      logger.info("Firstname: " + student.getFirstName() + " Lastname: " + student.getLastName() + " Cardnumber: "
          + student.getCardNumber());

    }
  }
}
