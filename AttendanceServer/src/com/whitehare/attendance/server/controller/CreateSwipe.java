package com.whitehare.attendance.server.controller;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.whitehare.attendance.server.beans.CardSwipe;
import com.whitehare.attendance.server.persistence.CardSwipes;
import com.whitehare.attendance.server.persistence.util.HibernateUtil;

public class CreateSwipe
{
  public Long saveCardSwipe(CardSwipe cs)
  {
    return saveNameType(cs.getCardNumber(), cs.getClassRoom());
  }

  public Long saveNameType(String name, String type)
  {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = null;
    Long index = null;
    try
    {
      transaction = session.beginTransaction();
      CardSwipes dBase = new CardSwipes();
      dBase.setName(name);
      dBase.setType(type);

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
