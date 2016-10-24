package com.whitehare.httpreceiver.controller;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.whitehare.httpreceiver.persistence.AttendanceTable;
import com.whitehare.httpreceiver.persistence.util.HibernateUtil;

public class CreateCardSwipe
{

  public long saveCardClass(String cardnumber, String classroom)
  {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = null;
    Long index = null;
    try
    {
      transaction = session.beginTransaction();
      AttendanceTable dBase = new AttendanceTable();
      dBase.setCardnumber(cardnumber);
      dBase.setClassRoom(classroom);
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
