package com.whitehare.attendance.server.controller;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.whitehare.attendance.server.persistence.TestJoin;
import com.whitehare.attendance.server.persistence.util.HibernateUtil;

public class GetSwipes
{

  public List<TestJoin> getAllCardSwipes()
  {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = null;

    List<TestJoin> results = null;
    try
    {
      transaction = session.beginTransaction();

      String hql = "FROM CardSwipes";
      Query query = session.createQuery(hql);
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
