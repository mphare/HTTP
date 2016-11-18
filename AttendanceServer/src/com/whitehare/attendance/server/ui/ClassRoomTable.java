package com.whitehare.attendance.server.ui;

import java.util.List;

import com.whitehare.attendance.server.controller.ClassRoomsCont;
import com.whitehare.attendance.server.persistence.ClassRooms;

public class ClassRoomTable
{
  public static String drawClassRoomTable()
  {
    ClassRoomsCont cr = new ClassRoomsCont();
    List<ClassRooms> classroomList = cr.getAllClassRooms();
    String retval = "<table><tr><th>ClassRoom</th></tr>";

    int rowStyleId = 0;
    for (ClassRooms classroom : classroomList)
    {
      String rowStyle = "odd";
      rowStyleId++;
      if ((rowStyleId % 2) == 0)
      {
        rowStyle = "even";
      }
      retval += "<tr class=\"" + rowStyle + "\"><td>" + classroom.getClassRoom() + "</td></tr>";

    }
    retval += "</table>";
    return retval;

  }

}
