package com.whitehare.attendance.server.tasks;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.whitehare.attendance.server.beans.Attendance;
import com.whitehare.attendance.server.controller.StudentsCont;
import com.whitehare.attendance.server.controller.GetSwipes;
import com.whitehare.attendance.server.persistence.CardSwipes;
import com.whitehare.attendance.server.persistence.Students;
import com.whitehare.attendance.server.report.EmailAttendanceReportFormat;
import com.whitehare.attendance.server.sendmail.SendMail;

public class AttendanceReport
{
  private static Logger logger = Logger.getLogger(AttendanceReport.class);

  public List<Attendance> generateAttendanceReport(Date date)
  {
    logger.info("About to generate the Attendance Report for " + date.toString());

    List<Attendance> attendanceList = new ArrayList<Attendance>();

    GetSwipes getSwipes = new GetSwipes();
    List<CardSwipes> cardswipes = new ArrayList<CardSwipes>();
    List<CardSwipes> tardycardswipes = new ArrayList<CardSwipes>();

    Calendar calNow = Calendar.getInstance();
    Date endDate = calNow.getTime();

    calNow.add(Calendar.MINUTE, -2);
    Date tardyDate = calNow.getTime();

    calNow.add(Calendar.MINUTE, -1);
    Date startDate = calNow.getTime();

    logger.info("Tardy start time: " + tardyDate + " to " + endDate);
    tardycardswipes = getSwipes.getRangeCardSwipes(tardyDate, endDate);
    logger.info("Present start time: " + startDate + " to " + tardyDate);
    cardswipes = getSwipes.getRangeCardSwipes(startDate, tardyDate);

    if (cardswipes.size() > 0)
    {
      logger.info("Getting swipes in the last 5 minutes: Time of report is:" + endDate + "  Time class started is: "
          + startDate);

      StudentsCont getsalltudents = new StudentsCont();
      List<Students> allstudents = getsalltudents.getAllStudents();

      for (Students student : allstudents)
      {
        String cardID = student.getCardNumber();

        String attendanceStatus = "Absent";
        Date swipeTime = null;

        for (CardSwipes cardswipe : cardswipes)
        {
          String swipeCardID = cardswipe.getCardNumber();
          if (cardID.equals(swipeCardID))
          {
            attendanceStatus = "Present";
            swipeTime = cardswipe.getSwipeTime();
            break;
          }
        }

        for (CardSwipes cardswipe : tardycardswipes)
        {
          String swipeCardID = cardswipe.getCardNumber();
          if (cardID.equals(swipeCardID))
          {
            attendanceStatus = "Tardy";
            swipeTime = cardswipe.getSwipeTime();
            break;
          }
        }

        Attendance attendance = new Attendance();
        attendance.setFirstName(student.getFirstName());
        attendance.setLastName(student.getLastName());
        attendance.setCardNumber(student.getCardNumber());
        attendance.setAttendanceStatus(attendanceStatus);
        attendance.setCardReadTime(swipeTime);

        attendanceList.add(attendance);

        logger.info("Firstname: " + student.getFirstName() + ", Lastname: " + student.getLastName() + ", Cardnumber: "
            + student.getCardNumber() + ", Attendance: " + attendanceStatus);

      }
    } else
    {
      logger.info("No card swipes for this time period");
    }

    return attendanceList;
  }

  public void processAttendanceReport(Date date)
  {
    List<Attendance> attendanceList = generateAttendanceReport(date);

    EmailAttendanceReportFormat htmlReport = new EmailAttendanceReportFormat();
    htmlReport.buildEmailHTMLReport(attendanceList);
    SendMail sendMail = new SendMail();
    sendMail.sendHTMLEmail(htmlReport);

  }

}
