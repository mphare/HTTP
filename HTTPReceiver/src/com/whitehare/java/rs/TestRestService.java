package com.whitehare.java.rs;

import java.io.InputStream;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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
}
