package com.whitehare.attendance.server.ui;

import java.util.List;

import com.whitehare.attendance.server.controller.GetStudents;
import com.whitehare.attendance.server.persistence.Students;

public class AttendanceReportTable
{

  public static String drawTable()
  {
    String retval = "<table><tr><th>Card Number</th><th>Last</th><th>First</th></tr>";

    GetStudents getsalltudents = new GetStudents();
    List<Students> allstudents = getsalltudents.getAllStudents();

    int rowStyleId = 0;
    for (Students student : allstudents)
    {
      String rowStyle = "odd";
      rowStyleId++;
      if ((rowStyleId % 2) == 0)
      {
        rowStyle = "even";
      }
      retval += "<tr class=\"" + rowStyle + "\"><td>" + student.getCardNumber() + "</td><td>" + student.getLastName()
          + "</td><td>" + student.getFirstName() + "</td></tr>";

    }

    retval += "</table>";
    return retval;
  }
}
