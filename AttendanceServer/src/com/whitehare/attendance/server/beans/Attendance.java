package com.whitehare.attendance.server.beans;

import java.util.Date;

public class Attendance
{
  private String cardNumber;
  private String firstName;
  private String lastName;
  private String attendanceStatus;
  private Date   cardReadTime;

  public String getCardNumber()
  {
    return cardNumber;
  }

  public void setCardNumber(String cardNumber)
  {
    this.cardNumber = cardNumber;
  }

  public String getFirstName()
  {
    return firstName;
  }

  public void setFirstName(String firstName)
  {
    this.firstName = firstName;
  }

  public String getLastName()
  {
    return lastName;
  }

  public void setLastName(String lastName)
  {
    this.lastName = lastName;
  }

  public String getAttendanceStatus()
  {
    return attendanceStatus;
  }

  public void setAttendanceStatus(String attendanceStatus)
  {
    this.attendanceStatus = attendanceStatus;
  }

  public Date getCardReadTime()
  {
    return cardReadTime;
  }

  public void setCardReadTime(Date cardReadTime)
  {
    this.cardReadTime = cardReadTime;
  }
}
