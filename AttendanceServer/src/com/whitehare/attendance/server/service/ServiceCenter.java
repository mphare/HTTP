package com.whitehare.attendance.server.service;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.whitehare.attendance.server.controller.CreateSwipe;

@Path("/send")
public class ServiceCenter
{
  private static Logger logger = Logger.getLogger(ServiceCenter.class);

  @Path("swipe")
  @POST
  @Produces(MediaType.TEXT_PLAIN)
  public String newCardSwipe(@QueryParam("cardnumber") String cardnumber, @QueryParam("classroom") String classroom)
  {
    // Date date = new Date();
    // CardSwipe cs = new CardSwipe(cardnum, classroom, date);
    // logger.debug("Card Swipe Detected. Cardnumber: " + cardnum + " Classroom:
    // " + classroom);

    CreateSwipe ccs = new CreateSwipe();
    // ccs.saveCardSwipe(cs);
    ccs.saveNameType(cardnumber, classroom);

    return "Card: " + cardnumber + " swipe detected in Classroom:" + classroom;
  }
}
