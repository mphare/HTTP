package com.whitehare.attendance.server.tasks;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.whitehare.attendance.server.controller.GetStudents;
import com.whitehare.attendance.server.persistence.Students;

public class AttendanceReport
{
  private static Logger logger = Logger.getLogger(AttendanceReport.class);

  public void generateAttendanceReport(Date date)
  {
    logger.info("About to generate the Attendance Report for " + date.toString());

    GetStudents gs = new GetStudents();
    List<Students> students = gs.getAllStudents();

    for (Students student : students)
    {
      System.out.println("Firstname: " + student.getFirstName() + " Lastname: " + student.getLastName()
          + " Cardnumber: " + student.getCardNumber());

    }

  }

}
