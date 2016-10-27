package com.whitehare.attendance.server.controller;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.whitehare.attendance.server.persistence.Students;
import com.whitehare.attendance.server.persistence.util.HibernateUtil;

public class GetStudents
{
  public List<Students> getAllStudents()
  {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = null;
    String students = new String();
    List<Students> results = null;
    try
    {
      transaction = session.beginTransaction();

      String hql = "FROM Students";
      Query query = session.createQuery(hql);
      results = query.list();

      // students = session.createSQLQuery("select * from
      // Students").list().toString();
      transaction.commit();

    } catch (HibernateException e)
    {
      transaction.rollback();
      e.printStackTrace();
    } finally
    {
      session.close();
    }
    return results;
  }
}
