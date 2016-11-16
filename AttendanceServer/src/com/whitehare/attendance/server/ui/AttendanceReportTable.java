package com.whitehare.attendance.server.ui;

import java.util.List;

import com.whitehare.attendance.server.controller.GetStudents;
import com.whitehare.attendance.server.persistence.Students;

public class AttendanceReportTable
{

  public static String drawTable()
  {
    String retval = "This is from the Java Class";

    GetStudents getsalltudents = new GetStudents();
    List<Students> allstudents = getsalltudents.getAllStudents();

    retval += " Number: " + allstudents.size();
    return retval;
  }
}
