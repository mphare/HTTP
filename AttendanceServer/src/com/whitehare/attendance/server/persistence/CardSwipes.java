package com.whitehare.attendance.server.persistence;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CardSwipes")
public class CardSwipes
{

  private long   swipeID;
  private String cardnumber;
  private String classRoom;
  private Date   swipeTime;

  public CardSwipes()
  {

  }

  @Id
  @GeneratedValue
  @Column(name = "SwipeID")
  public long getIndex()
  {
    return swipeID;
  }

  public void setIndex(long swipeID)
  {
    this.swipeID = swipeID;
  }

  @Column(name = "CardNumber")
  public String getName()
  {
    return cardnumber;
  }

  public void setName(String cardNumber)
  {
    this.cardnumber = cardNumber;
  }

  @Column(name = "ClassRoom")
  public String getType()
  {
    return classRoom;
  }

  public void setType(String classRoom)
  {
    this.classRoom = classRoom;
  }

  @Column(name = "SwipeTime")
  public Date getSwipeTime()
  {
    return swipeTime;
  }

  public void setSwipeTime(Date swipeTime)
  {
    this.swipeTime = swipeTime;
  }

}
