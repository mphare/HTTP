package com.whitehare.java.mail;

import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.*;

public class DoSendMail
{

  public static void main(String[] args)
  {
    // TODO Auto-generated method stub

    String to = "mhare@zixcorp.com";
    String from = "bilbo.baggins@theshire.com";
    String host = "localhost";
    Properties properties = System.getProperties();
    properties.setProperty("mail.smtp.host", host);

    Session session = Session.getDefaultInstance(properties);
  }

}
