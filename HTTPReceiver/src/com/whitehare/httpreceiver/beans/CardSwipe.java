package com.whitehare.httpreceiver.beans;

import java.util.Date;

public class CardSwipe
{
  String cardNumber;
  String classRoom;
  Date   swipeTime = new Date();

  public CardSwipe(String cardNumber, String classRoom, Date swipeTime)
  {
    this.cardNumber = cardNumber;
    this.classRoom = classRoom;
    this.swipeTime = swipeTime;
  }

  public String getCardNumber()
  {
    return cardNumber;
  }

  public void setCardNumber(String cardNumber)
  {
    this.cardNumber = cardNumber;
  }

  public String getClassRoom()
  {
    return classRoom;
  }

  public void setClassRoom(String classRoom)
  {
    this.classRoom = classRoom;
  }

  public Date getSwipeTime()
  {
    return swipeTime;
  }

  public void setSwipeTime(Date swipeTime)
  {
    this.swipeTime = swipeTime;
  }

}
