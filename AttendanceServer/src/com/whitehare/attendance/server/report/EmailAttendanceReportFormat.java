package com.whitehare.attendance.server.report;

import java.util.List;

import com.whitehare.attendance.server.beans.Attendance;

public class EmailAttendanceReportFormat
{
  String htmlReport = new String();

  public String htmlAttendanceReport()
  {
    String report = null;

    return report;
  }

  public void buildEmailHTMLReport(List<Attendance> attendanceList)
  {
    htmlReport = htmlEmailAttendanceReport(attendanceList);
  }

  public String htmlEmailAttendanceReport(List<Attendance> attendanceList)
  {
    String htmlReport = "<table><tr><th>Card ID</th><th>First Name</th><th>Last Name</th><th>Status</th></tr>";
    for (Attendance attendance : attendanceList)
    {
      htmlReport += "<tr><td>" + attendance.getCardNumber() + "</td><td>" + attendance.getFirstName() + "</td><td>"
          + attendance.getLastName() + "</td><td>" + attendance.getAttendanceStatus() + "</td></tr>";

    }
    htmlReport += "</table>";

    return htmlReport;
  }

  public String getReport()
  {
    return htmlReport;
  }

}
