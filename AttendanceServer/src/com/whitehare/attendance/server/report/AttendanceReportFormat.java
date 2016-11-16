package com.whitehare.attendance.server.report;

import java.util.List;

import com.whitehare.attendance.server.persistence.CardSwipes;
import com.whitehare.attendance.server.persistence.Students;

public class AttendanceReportFormat
{
  String htmlReport = new String();

  public String htmlAttendanceReport()
  {
    String report = null;

    return report;
  }

  public void buildHTMLReport(List<Students> allstudents, List<CardSwipes> cardswipes, List<CardSwipes> tardycardswipes)
  {
    htmlReport = htmlAttendanceReport(allstudents, cardswipes, tardycardswipes);
  }

  public String htmlAttendanceReport(List<Students> allstudents, List<CardSwipes> cardswipes,
      List<CardSwipes> tardycardswipes)
  {
    // String htmlReport = "<h1>Attendance Report</h1><br><h2>Room: " +
    // cardswipes.get(0).getClassRoom();
    String htmlReport = "<table><tr><th>Card ID</th><th>First Name</th><th>Last Name</th><th>Status</th></tr>";
    String attendance;
    for (Students student : allstudents)
    {
      String cardID = student.getCardNumber();
      attendance = "Absent";

      for (CardSwipes cardswipe : cardswipes)
      {
        String swipeCardID = cardswipe.getCardNumber();
        if (cardID.equals(swipeCardID))
        {
          attendance = "Present";
          break;
        }
      }

      for (CardSwipes cardswipe : tardycardswipes)
      {
        String swipeCardID = cardswipe.getCardNumber();
        if (cardID.equals(swipeCardID))
        {
          attendance = "Tardy";
          break;
        }
      }
      htmlReport += "<tr><td>" + student.getCardNumber() + "</td><td>" + student.getFirstName() + "</td><td>"
          + student.getLastName() + "</td><td>" + attendance + "</td></tr>";

    }
    htmlReport += "</table>";

    return htmlReport;
  }

  public String getReport()
  {
    return htmlReport;
  }

}
