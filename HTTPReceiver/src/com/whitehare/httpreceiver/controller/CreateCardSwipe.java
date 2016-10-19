package com.whitehare.httpreceiver.controller;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.whitehare.httpreceiver.beans.CardSwipe;
import com.whitehare.httpreceiver.persistence.DBase;
import com.whitehare.httpreceiver.persistence.util.HibernateUtil;

public class CreateCardSwipe
{
  public long saveCardSwipe(CardSwipe cs)
  {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = null;
    Long index = null;
    try
    {
      transaction = session.beginTransaction();
      DBase dBase = new DBase();
      // dBase.setName(name);
      // dBase.setType(type);

      index = (Long) session.save(dBase);
      transaction.commit();

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
