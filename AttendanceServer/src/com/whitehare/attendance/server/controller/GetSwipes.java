package com.whitehare.attendance.server.controller;

import java.util.ArrayList;
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

    List<TestJoin> results = new ArrayList<TestJoin>();

    try
    {
      transaction = session.beginTransaction();

      String hql = "FROM TestJoins";
      Query query = session.createQuery(hql);
      // String sql = "SELECT CardNumber FROM CardSwipes";
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
