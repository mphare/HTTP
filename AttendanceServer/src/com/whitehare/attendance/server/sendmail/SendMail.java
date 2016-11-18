package com.whitehare.attendance.server.sendmail;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;

import com.whitehare.attendance.server.properties.ConfigProperties;
import com.whitehare.attendance.server.report.EmailAttendanceReportFormat;

public class SendMail
{
  private static Logger logger = Logger.getLogger(SendMail.class);

  public static void sendHTMLEmail(EmailAttendanceReportFormat htmlReport)
  {

    ConfigProperties cfgProp = new ConfigProperties();

    try
    {
      cfgProp.getPropertyValue();
    } catch (IOException e)
    {
      e.printStackTrace();
    }

    String mail_to = cfgProp.getMailTo();
    String maiL_from = cfgProp.getMailFrom();

    String to = mail_to;
    String from = maiL_from;

    // String to = "mphare1156@gmail.com";
    // String to = "mhare@zixcorp.com";
    // String to = "mphare@whitehare.com";
    // String from = "prof.minerva.mcgonagall@hogwarts.edu";

    String mail_host = cfgProp.getMailHost();

    Properties properties = System.getProperties();
    properties.setProperty("mail.smtp.host", mail_host);

    Session session = Session.getDefaultInstance(properties);
    try
    {
      MimeMessage message = new MimeMessage(session);
      message.setFrom(new InternetAddress(from));
      message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
      message.setSubject("Test Email from Java");
      message.setContent(htmlReport.getReport(), "text/html");

      logger.info("Sending html email to:" + to + " from: " + from);
      Transport.send(message);

    } catch (MessagingException mex)
    {
      mex.printStackTrace();

    }

  }
}
