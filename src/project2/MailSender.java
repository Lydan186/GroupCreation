/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project2;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

/**
 *
 * @author josep
 */
public class MailSender {
    private String emailAddressTo = new String();
    private String msgSubject = new String();
    private String msgText = new String();

    final String USER_NAME = "programacion1javamail@gmail.com";   //User name of the Goole(gmail) account
    final String PASSSWORD = "wdsvhouvpnlshako";  //Password of the Goole(gmail) account
    final String FROM_ADDRESS = "programacion1javamail@gmail.com";  //From addresss
 
    public MailSender() {
    }

    public static void main(String[] args) {
      MailSender email = new MailSender();
     //Sending test email
      email.createAndSendEmail("DILAN.CHAVARRIA@ucr.ac.cr", "TGracias kevin te quiero mucho",
      "Gracias kevin te quiero mucho !!! \nGracias kevin te quiero mucho");
    }

    public void createAndSendEmail(String emailAddressTo, String msgSubject, String msgText) {
        this.emailAddressTo = emailAddressTo;
        this.msgSubject = msgSubject;
        this.msgText = msgText;
        sendEmailMessage();
    }
 
    private void sendEmailMessage() {
     
     //Create email sending properties
     Properties props = new Properties();
     props.put("mail.smtp.auth", "true");
     props.put("mail.smtp.starttls.enable", "true");
     props.put("mail.smtp.host", "smtp.gmail.com");
     props.put("mail.smtp.port", "587");
  
    Session session = Session.getInstance(props,
    new javax.mail.Authenticator() {
    protected PasswordAuthentication getPasswordAuthentication() {
    return new PasswordAuthentication("programacion1javamail@gmail.com", "wdsvhouvpnlshako");
   }
    });

  try {

     Message message = new MimeMessage(session);
     message.setFrom(new InternetAddress("programacion1javamail@gmail.com")); //Set from address of the email
     message.setContent(msgText,"text/html"); //set content type of the email
     
    message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("KEVIN.SIBAJAGRANADOS@ucr.ac.cr")); //Set email recipient
    
    message.setSubject("Gracias kevin te quiero mucho"); //Set email message subject
    Transport.send(message); //Send email message

   System.out.println("sent email successfully!");

  } catch (MessagingException e) {
       throw new RuntimeException(e);
  }
    }

    public void setEmailAddressTo(String emailAddressTo) {
        this.emailAddressTo = emailAddressTo;
    }

    public void setSubject(String subject) {
        this.msgSubject = subject;
    }

    public void setMessageText(String msgText) {
        this.msgText = msgText;
    }

}
