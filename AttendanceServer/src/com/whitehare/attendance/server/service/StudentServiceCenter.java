package com.whitehare.attendance.server.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.whitehare.attendance.server.controller.GetStudents;

@Path("/students")
public class StudentServiceCenter
{

  @Path("list")
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String getAllStudents()
  {
    GetStudents gs = new GetStudents();

    return "XXX";
  }

}
