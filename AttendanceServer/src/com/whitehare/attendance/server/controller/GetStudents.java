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

    List<Students> results = null;
    try
    {
      transaction = session.beginTransaction();

      String hql = "from Students order by lastName";
      Query query = session.createQuery(hql);
      // String sql = "SELECT * FROM Students";
      // Query query = session.createSQLQuery(sql);
      results = query.list();

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
