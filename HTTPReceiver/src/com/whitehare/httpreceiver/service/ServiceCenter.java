package com.whitehare.httpreceiver.service;

import java.util.Date;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.whitehare.httpreceiver.beans.CardSwipe;
import com.whitehare.httpreceiver.controller.CreateCardSwipe;

@Path("/send")
public class ServiceCenter
{
  private static Logger logger = Logger.getLogger(ServiceCenter.class);

  @Path("swipe")
  @POST
  @Produces(MediaType.TEXT_PLAIN)
  public String newCardSwipe(@QueryParam("cardnumber") String cardnum, @QueryParam("classroom") String classroom)
  {
    Date date = new Date();
    CardSwipe cs = new CardSwipe(cardnum, classroom, date);
    logger.debug("Card Swipe Detected.  Cardnumber: " + cardnum + " Classroom: " + classroom);

    CreateCardSwipe ccs = new CreateCardSwipe();
    // ccs.saveCardSwipe(cs);

    return "Card: " + cardnum + " swipe detected in Classroom:" + classroom;
  }

}
