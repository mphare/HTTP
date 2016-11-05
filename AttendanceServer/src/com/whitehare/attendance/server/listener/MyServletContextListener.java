package com.whitehare.attendance.server.listener;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.whitehare.attendance.server.schedular.DoEveryMinuteJob;

@WebListener
public class MyServletContextListener implements ServletContextListener
{

  private ScheduledExecutorService scheduler;

  @Override
  public void contextDestroyed(ServletContextEvent arg0)
  {
    System.out.println("...That's it..we're out");

  }

  @Override
  public void contextInitialized(ServletContextEvent event)
  {
    System.out.println("Hello! Let's get this show on the road..");
    scheduler = Executors.newSingleThreadScheduledExecutor();
    scheduler.scheduleAtFixedRate(new DoEveryMinuteJob(), 0, 1, TimeUnit.MINUTES);

  }

}
