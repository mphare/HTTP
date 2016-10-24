package com.whitehare.mysqltest.test;

import org.junit.Test;

import com.whitehare.mysqltest.controller.CreateEntry;

public class WhenTestingDatabase
{

  @Test
  public void shouldwWriteToDatabase()
  {

    CreateEntry ce = new CreateEntry();
    ce.saveNameType("Simplex", "Qube");

  }
}
