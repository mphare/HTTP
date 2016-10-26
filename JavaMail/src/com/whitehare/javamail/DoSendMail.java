package com.whitehare.javamail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;

public class DoSendMail
{
  private static Logger logger = Logger.getLogger(DoSendMail.class);

  public static void main(String[] args)
  {
    sendTextEMail();
    sendHTMLEmail();
  }

  private static void sendHTMLEmail()
  {
    // String to = "mphare@whitehare.com";
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
      message.setContent("<h1>Here is the Body</h1>", "text/html");

      logger.debug("Sending html email to:" + to + " from: " + from);
      Transport.send(message);
      logger.debug("Sent html email to:" + to + " from: " + from);

    } catch (MessagingException mex)
    {
      mex.printStackTrace();

    }

  }

  private static void sendTextEMail()
  {
    // String to = "mphare@whitehare.com";
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

      logger.debug("Sending text email to:" + to + " from: " + from);
      Transport.send(message);
      logger.debug("Sent text email to:" + to + " from: " + from);

    } catch (MessagingException mex)
    {
      mex.printStackTrace();

    }
  }

}
