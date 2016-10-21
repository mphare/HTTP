package com.whitehare.httpreceiver.controller;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.whitehare.httpreceiver.beans.CardSwipe;
import com.whitehare.httpreceiver.persistence.DBase;
import com.whitehare.httpreceiver.persistence.util.HibernateUtil;

public class CreateCardSwipe
{
  private static Logger logger = Logger.getLogger(CreateCardSwipe.class);

  public long saveCardSwipe(CardSwipe cs)
  {
    logger.debug("SaveCardSwipe: cardnumber" + cs.getCardNumber() + " classroom: " + cs.getClassRoom());
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = null;
    Long index = null;
    try
    {
      transaction = session.beginTransaction();
      DBase dBase = new DBase();
      dBase.setCardnumber(cs.getCardNumber());
      dBase.setClassRoom(cs.getClassRoom());

      // dBase.setName(name);
      // dBase.setType(type);

      index = (Long) session.save(dBase);
      transaction.commit();
      logger.debug("Committed Transaction: " + index);
    } catch (HibernateException e)
    {
      transaction.rollback();
      e.printStackTrace();
    } finally
    {
      session.close();
    }
    return index;
  }

}
