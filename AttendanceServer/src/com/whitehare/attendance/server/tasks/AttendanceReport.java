package com.whitehare.attendance.server.tasks;

import org.apache.log4j.Logger;

public class AttendanceReport
{
  private static Logger logger = Logger.getLogger(AttendanceReport.class);

  public void generateAttendanceReport()
  {
    logger.info("About to generate the Attendance Report");
  }

}
