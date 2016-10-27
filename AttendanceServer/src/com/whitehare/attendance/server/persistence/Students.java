package com.whitehare.attendance.server.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Students")
public class Students
{

  private long   studentID;
  private String firstName;
  private String lastName;
  private String cardNumber;

  public Students()
  {

  }

  @Id
  @GeneratedValue
  @Column(name = "StudentID")
  public long getStudentID()
  {
    return studentID;
  }

  public void setStudentID(long studentID)
  {
    this.studentID = studentID;
  }

  @Column(name = "FirstName")
  public String getFirstName()
  {
    return firstName;
  }

  public void setFirstName(String firstName)
  {
    this.firstName = firstName;
  }

  @Column(name = "LastName")
  public String getLastName()
  {
    return lastName;
  }

  public void setLastName(String lastName)
  {
    this.lastName = lastName;
  }

  @Column(name = "CardNumber")
  public String getCardNumber()
  {
    return cardNumber;
  }

  public void setCardNumber(String cardNumber)
  {
    this.cardNumber = cardNumber;
  }

}