package com.whitehare.attendance.server.ui;

import java.util.Date;
import java.util.List;

import com.whitehare.attendance.server.beans.Attendance;
import com.whitehare.attendance.server.tasks.AttendanceReport;

public class AttendanceReportTable
{

  private static List<Attendance> calculateAttendance()
  {

    Date date = new Date();
    AttendanceReport ar = new AttendanceReport();
    List<Attendance> attendance = ar.generateAttendanceReport(date);

    return attendance;
  }

  public static String drawAttendanceTable()
  {
    List<Attendance> attendanceList = calculateAttendance();
    String retval = "<table><tr><th>Card Number</th><th>Last</th><th>First</th><th>Attendance</th></tr>";

    int rowStyleId = 0;
    for (Attendance attendance : attendanceList)
    {
      String rowStyle = "odd";
      rowStyleId++;
      if ((rowStyleId % 2) == 0)
      {
        rowStyle = "even";
      }
      retval += "<tr class=\"" + rowStyle + "\"><td>" + attendance.getCardNumber() + "</td><td>"
          + attendance.getLastName() + "</td><td>" + attendance.getFirstName() + "</td><td>"
          + attendance.getAttendanceStatus() + "</td></tr>";

    }

    retval += "</table>";
    return retval;
  }
}
