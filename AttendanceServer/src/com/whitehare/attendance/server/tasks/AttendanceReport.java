package com.whitehare.attendance.server.tasks;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.whitehare.attendance.server.controller.GetStudents;
import com.whitehare.attendance.server.controller.GetSwipes;
import com.whitehare.attendance.server.persistence.Students;
import com.whitehare.attendance.server.persistence.TestJoin;

public class AttendanceReport
{
  private static Logger logger = Logger.getLogger(AttendanceReport.class);

  public void generateAttendanceReport(Date date)
  {
    logger.info("About to generate the Attendance Report for " + date.toString());

    GetStudents getstudents = new GetStudents();
    List<Students> students = getstudents.getAllStudents();

    for (Students student : students)
    {
      System.out.println("\nFirstname: " + student.getFirstName() + "; Lastname: " + student.getLastName()
          + "; Cardnumber: " + student.getCardNumber());

    }

    GetSwipes gs = new GetSwipes();
    List<TestJoin> testjoins = new ArrayList<TestJoin>();

    Calendar calNow = Calendar.getInstance();
    Date endDate = calNow.getTime();

    calNow.add(Calendar.MINUTE, -5);
    Date startDate = calNow.getTime();
    testjoins = gs.getRangeCardSwipes(startDate, endDate);

    System.out.print("\n\nGetting last 5 minute swipes: Now:" + endDate + "  started: " + startDate);
    for (TestJoin testjoin : testjoins)
    {
      System.out.println("\nCard Number: " + testjoin.getCardNumber() + " validated at " + testjoin.getSwipeTime());
    }

    GetStudents getsalltudents = new GetStudents();
    List<Students> allstudents = getsalltudents.getAllStudents();

    for (Students student : allstudents)
    {
      System.out.println("\nFirstname: " + student.getFirstName() + " Lastname: " + student.getLastName()
          + " Cardnumber: " + student.getCardNumber());

    }

  }

}
