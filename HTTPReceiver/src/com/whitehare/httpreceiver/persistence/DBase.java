package com.whitehare.httpreceiver.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CardSwipes")
public class DBase
{
  private String cardnumber;
  private String classroom;
  private long   index;

  public DBase()
  {

  }

  @Id
  @GeneratedValue
  @Column(name = "SwipeID")
  public long getIndex()
  {
    return index;
  }

  public void setIndex(long index)
  {
    this.index = index;
  }

  @Column(name = "CardNumber")
  public String getCardNumber()
  {
    return cardnumber;
  }

  public void setCardnumber(String cardnumber)
  {
    this.cardnumber = cardnumber;
  }

  @Column(name = "ClassRoom")
  public String getClassRoom()
  {
    return classroom;
  }

  public void setClassRoom(String classroom)
  {
    this.classroom = classroom;
  }
}
