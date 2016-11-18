package com.whitehare.attendance.server.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ClassRooms")
public class ClassRooms
{
  @Id
  @GeneratedValue
  @Column(name = "index_claddroom")
  private long   indexClassRoom;

  @Column(name = "ClassRoom")
  private String classRoom;

  public long getIndexClassRoom()
  {
    return indexClassRoom;
  }

  public void setIndexClassRoom(long indexClassRoom)
  {
    this.indexClassRoom = indexClassRoom;
  }

  public String getClassRoom()
  {
    return classRoom;
  }

  public void setClassRoom(String classRoom)
  {
    this.classRoom = classRoom;
  }

}
