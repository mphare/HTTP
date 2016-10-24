package com.whitehare.mysqltest.controller;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.whitehare.mysqltest.persistence.DBase;
import com.whitehare.mysqltest.persistence.util.HibernateUtil;

public class CreateEntry
{
  /**
   * === C ===
   * 
   * @param courseName
   * @return
   */
  public Long saveNameType(String name, String type)
  {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = null;
    Long index = null;
    try
    {
      transaction = session.beginTransaction();
      DBase dBase = new DBase();
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
