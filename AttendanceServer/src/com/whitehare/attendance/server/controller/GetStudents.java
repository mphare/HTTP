package com.whitehare.attendance.server.controller;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.whitehare.attendance.server.persistence.util.HibernateUtil;

public class GetStudents
{
  public String getAllStudents()
  {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = null;
    String students = new String();
    try
    {
      transaction = session.beginTransaction();

      students = session.createSQLQuery("select * from Students").list().toString();
      transaction.commit();

    } catch (HibernateException e)
    {
      transaction.rollback();
      e.printStackTrace();
    } finally
    {
      session.close();
    }
    return students;
  }
}
