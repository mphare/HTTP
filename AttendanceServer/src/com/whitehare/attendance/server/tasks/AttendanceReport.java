package com.whitehare.attendance.server.tasks;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.whitehare.attendance.server.controller.GetStudents;
import com.whitehare.attendance.server.controller.GetSwipes;
import com.whitehare.attendance.server.persistence.CardSwipes;
import com.whitehare.attendance.server.persistence.Students;

public class AttendanceReport
{
  private static Logger logger = Logger.getLogger(AttendanceReport.class);

  public void generateAttendanceReport(Date date)
  {
    logger.info("About to generate the Attendance Report for " + date.toString());

    GetSwipes getSwipes = new GetSwipes();
    List<CardSwipes> cardswipes = new ArrayList<CardSwipes>();

    Calendar calNow = Calendar.getInstance();
    Date endDate = calNow.getTime();

    calNow.add(Calendar.MINUTE, -5);
    Date startDate = calNow.getTime();
    cardswipes = getSwipes.getRangeCardSwipes(startDate, endDate);

    if (cardswipes.size() > 0)
    {
      System.out.println("\nGetting swipes in the last 5 minutes: Time of report is:" + endDate
          + "  Time class started is: " + startDate);
      for (CardSwipes cardswipe : cardswipes)
      {
        System.out
            .println("Card Number: " + cardswipe.getCardNumber() + " was validated at " + cardswipe.getSwipeTime());
      }

      GetStudents getsalltudents = new GetStudents();
      List<Students> allstudents = getsalltudents.getAllStudents();

      for (Students student : allstudents)
      {
        String cardID = student.getCardNumber();
        System.out.print("Firstname: " + student.getFirstName() + ", Lastname: " + student.getLastName()
            + ", Cardnumber: " + student.getCardNumber());

        String attendance = "Absent";

        for (CardSwipes cardswipe : cardswipes)
        {
          String swipeCardID = cardswipe.getCardNumber();
          if (cardID.equals(swipeCardID))
          {
            attendance = "Present";
            break;
          }
        }

        System.out.println(", Attendance: " + attendance);

      }
    }

  }

}
