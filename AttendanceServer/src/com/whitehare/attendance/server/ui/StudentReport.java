package com.whitehare.attendance.server.ui;

import java.util.List;

import com.whitehare.attendance.server.controller.StudentsCont;
import com.whitehare.attendance.server.persistence.Students;

public class StudentReport
{
  public static String drawTable()
  {
    String retval = "This is from the Java Class";

    StudentsCont getsalltudents = new StudentsCont();
    List<Students> allstudents = getsalltudents.getAllStudents();

    retval += " Number: " + allstudents.size();
    return retval;
  }

}