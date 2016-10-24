package com.whitehare.mysqltest.controller;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.whitehare.mysqltest.persistence.AttendanceTable;
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
      AttendanceTable dBase = new AttendanceTable();
      dBase.setCardNumber(name);
      dBase.setClassRoom(type);

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
