package com.whitehare.attendance.server.persistence;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * The idea here is this is a basic CardSwipes SELECT, 
 * joined with the Students to provide First and Last Name
 */

@Entity(name = "TestJoins")
@Table(name = "CardSwipes")
public class TestJoin
{
  private long   indexCardSwipe;
  private String cardnumber;
  private String classRoom;
  private Date   swipeTime;

  public TestJoin()
  {

  }

  @Id
  @GeneratedValue
  @Column(name = "index_cardswipe")
  public long getSwipeID()
  {
    return indexCardSwipe;
  }

  public void setSwipeID(long indexCardSwipe)
  {
    this.indexCardSwipe = indexCardSwipe;
  }

  @Column(name = "CardNumber")
  public String getCardNumber()
  {
    return cardnumber;
  }

  public void setCardNumber(String cardNumber)
  {
    this.cardnumber = cardNumber;
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
