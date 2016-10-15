package com.whitehare.java.rs;

import java.io.InputStream;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/test")
public class TestRestService
{
  @GET
  @Produces("application/xml")
  public String verifyEndpoint(InputStream incomingData)
  {
    String result = "The Test Endpoint was Hit";

    return "<ctofservice>" + "<celsius>" + "XYZZY" + "</celsius>" + "<ctofoutput>" + result + "</ctofoutput>"
        + "</ctofservice>";

  }

}
