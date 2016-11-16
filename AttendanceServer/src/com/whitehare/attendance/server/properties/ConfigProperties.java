package com.whitehare.attendance.server.properties;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigProperties
{

  public enum Contract
  {
    report_mail_to, report_mail_from, mail_server, mail_report;
  }

  private String mailTo     = "";
  private String mailFrom   = "";
  private String mailHost   = "";
  private String mailReport = "";

  public void getPropertyValue() throws IOException
  {
    InputStream inputStream = null;

    try
    {
      Properties prop = new Properties();
      String configPropertyFileName = "server.properties";

      inputStream = getClass().getClassLoader().getResourceAsStream(configPropertyFileName);
      if (inputStream != null)
      {
        prop.load(inputStream);

      } else
      {
        throw new FileNotFoundException("Property File: '" + configPropertyFileName + "' was not found");
      }

      mailTo = prop.getProperty(Contract.report_mail_to.toString());
      mailFrom = prop.getProperty(Contract.report_mail_from.toString());
      mailHost = prop.getProperty(Contract.mail_server.toString());
      mailReport = prop.getProperty(Contract.mail_report.toString());

    } catch (Exception e)
    {
      e.printStackTrace();
    } finally
    {
      inputStream.close();
    }
  }

  public String getMailTo()
  {
    return mailTo;
  }

  public void setMailTo(String mailTo)
  {
    this.mailTo = mailTo;
  }

  public String getMailFrom()
  {
    return mailFrom;
  }

  public void setMailFrom(String mailFrom)
  {
    this.mailFrom = mailFrom;
  }

  public String getMailHost()
  {
    return mailHost;
  }

  public void setMailHost(String mailHost)
  {
    this.mailHost = mailHost;
  }

  public String getMailReport()
  {
    return mailReport;
  }

  public void setMailReport(String mailReport)
  {
    this.mailReport = mailReport;
  }

}
