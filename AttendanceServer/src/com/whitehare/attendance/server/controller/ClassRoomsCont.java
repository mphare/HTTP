package com.whitehare.attendance.server.controller;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.whitehare.attendance.server.persistence.ClassRooms;
import com.whitehare.attendance.server.persistence.util.HibernateUtil;

public class ClassRoomsCont
{
  public List<ClassRooms> getAllClassRooms()
  {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = null;

    List<ClassRooms> results = null;
    try
    {
      transaction = session.beginTransaction();

      String hql = "from ClassRooms order by classRoom";
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
