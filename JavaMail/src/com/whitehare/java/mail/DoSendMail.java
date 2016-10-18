package com.whitehare.java.mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

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

    try
    {
      MimeMessage message = new MimeMessage(session);
      message.setFrom(new InternetAddress(from));
      message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
      message.setSubject("Test Email from Java");
      message.setText("Here is the Body");

      Transport.send(message);

    } catch (MessagingException mex)
    {
      mex.printStackTrace();

    }
  }

}
