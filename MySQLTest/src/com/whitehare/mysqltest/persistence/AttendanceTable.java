package com.whitehare.mysqltest.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CardSwipes")
public class AttendanceTable
{

  private long   swipeid;
  private String cardnumber;
  private String classroom;

  public AttendanceTable()
  {

  }

  @Id
  @GeneratedValue
  @Column(name = "SWIPEID")
  public long getSwipeID()
  {
    return swipeid;
  }

  public void setSwipeID(long index)
  {
    this.swipeid = index;
  }

  @Column(name = "CARDNUMBER")
  public String getCardNumber()
  {
    return cardnumber;
  }

  public void setCardNumber(String name)
  {
    this.cardnumber = name;
  }

  @Column(name = "CLASSROOM")
  public String getClassRoom()
  {
    return classroom;
  }

  public void setClassRoom(String type)
  {
    this.classroom = type;
  }

}
