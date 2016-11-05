package com.whitehare.attendance.server.schedular;

import java.util.Date;

public class DoEveryMinuteJob implements Runnable
{

  @Override
  public void run()
  {
    Date date = new Date();
    System.out.println("It's ben a minute: " + date.toString());

  }

}
