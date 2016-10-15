package com.whitehare.java.rs;

import java.io.InputStream;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/test")
public class TestRestService
{
  @GET
  @Path("/verify")
  @Produces("application/xml")
  public String verifyEndpoint(InputStream incomingData)
  {
    String result = "The Test Endpoint was Hit";

    return "<ctofservice>" + "<celsius>" + "XYZZY" + "</celsius>" + "<ctofoutput>" + result + "</ctofoutput>"
        + "</ctofservice>";

  }

  @GET
  @Path("/verify2")
  @Produces(MediaType.TEXT_PLAIN)
  public String verifyEndpoint2(InputStream incomingData)
  {
    String result = "The 2nd Test Endpoint was Hit";

    return "<ctofservice>" + "<celsius>" + "ABC123" + "</celsius>" + "<ctofoutput>" + result + "</ctofoutput>"
        + "</ctofservice>";

  }

  @Path("add")
  @PUT
  @Produces(MediaType.TEXT_PLAIN)
  public String modifyNameTypeRS(@QueryParam("cardnum") String cardnum, @QueryParam("classroom") String classroom)
  {
    // UpdateEntry ue = new UpdateEntry();
    // ue.updateNameType(idx, name, type);
    return "Card: " + cardnum + " swipe detected in Classroom:" + classroom;
  }

  @Path("delete")
  @DELETE
  @Produces(MediaType.TEXT_PLAIN)
  public String deleteTest(@QueryParam("studentid") String studentid)
  {
    return "Deleted " + studentid;
  }
}
