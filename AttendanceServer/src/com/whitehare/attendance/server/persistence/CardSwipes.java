package com.whitehare.attendance.server.persistence;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "CardSwipes")
@Table(name = "CardSwipes")
public class CardSwipes
{

  private long   swipeID;
  private String cardNumber;
  private String classRoom;
  private Date   swipeTime;

  public CardSwipes()
  {

  }

  @Id
  @GeneratedValue
  @Column(name = "SwipeID")
  public long getSwipeID()
  {
    return swipeID;
  }

  public void setSwipeID(long swipeID)
  {
    this.swipeID = swipeID;
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

  @Column(name = "ClassRoom")
  public String getClassRoom()
  {
    return classRoom;
  }

  public void setClassRoom(String classRoom)
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
