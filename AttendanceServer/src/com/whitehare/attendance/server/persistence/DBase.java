package com.whitehare.attendance.server.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CardSwipes")
public class DBase
{

  private long   index;
  private String name;
  private String type;

  public DBase()
  {

  }

  @Id
  @GeneratedValue
  @Column(name = "SWIPEID")
  public long getIndex()
  {
    return index;
  }

  public void setIndex(long index)
  {
    this.index = index;
  }

  @Column(name = "CARDNUMBER")
  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  @Column(name = "CLASSROOM")
  public String getType()
  {
    return type;
  }

  public void setType(String type)
  {
    this.type = type;
  }

}