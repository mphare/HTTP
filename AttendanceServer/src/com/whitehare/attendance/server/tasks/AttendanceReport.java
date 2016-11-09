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

    // GetStudents getstudents = new GetStudents();
    // List<Students> students = getstudents.getAllStudents();
    //
    // for (Students student : students)
    // {
    // System.out.println("\nFirstname: " + student.getFirstName() + ";
    // Lastname: " + student.getLastName()
    // + "; Cardnumber: " + student.getCardNumber());
    //
    // }

    GetSwipes gs = new GetSwipes();
    List<CardSwipes> cardswipes = new ArrayList<CardSwipes>();

    Calendar calNow = Calendar.getInstance();
    Date endDate = calNow.getTime();

    calNow.add(Calendar.MINUTE, -5);
    Date startDate = calNow.getTime();
    cardswipes = gs.getRangeCardSwipes(startDate, endDate);

    System.out.print("\nGetting swipes from last 5 minutes: Now:" + endDate + "  started: " + startDate);
    for (CardSwipes cardswipe : cardswipes)
    {
      System.out.println("Card Number: " + cardswipe.getCardNumber() + " validated at " + cardswipe.getSwipeTime());
    }

    GetStudents getsalltudents = new GetStudents();
    List<Students> allstudents = getsalltudents.getAllStudents();

    for (Students student : allstudents)
    {
      System.out.println("Firstname: " + student.getFirstName() + " Lastname: " + student.getLastName()
          + " Cardnumber: " + student.getCardNumber());

    }

  }

}
