/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package procedure;

import java.awt.Component;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.sql.DataSource;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import static org.graalvm.compiler.nodes.memory.address.OffsetAddressNode.address;

/**
 *
 * @author josep
 */
public class sendEmail {
    

    static String email = "programacion1javamail@gmail.com";
    static String password = "wdsvhouvpnlshako";
    static String destinyMail = "";
    static String route;
    
    
/**
 * Procedimiento encargado para realizar el envio del correo electronico junto 
 * al archivo txt con los grupos formados
 * @throws AddressException
 * @throws MessagingException 
 */  
    public static void sendMail() throws AddressException, MessagingException{
        
    Properties p = new Properties();
    
    p.put("mail.smtp.trust", "smtp.gmail.com");
    p.put("mail.smtp.auth", "true");
    p.put("mail.smtp.starttls.enable", "true");
    p.put("mail.smtp.host", "smtp.gmail.com");
    p.put("mail.smtp.port", "587");
    p.put("mail.smtp.user", email);
    
    destinyMail = JOptionPane.showInputDialog(null, "Digite el correo de destino:");
    
            JFileChooser fileChooser = new JFileChooser();
         Component parent = null;
                  int returnVal = fileChooser.showOpenDialog(parent);
                  if (returnVal == JFileChooser.APPROVE_OPTION) {
                  System.out.println("Se subio el registro: "
                    + fileChooser.getSelectedFile().getName());
                  
                  }
    
    
    
    Session session = Session.getDefaultInstance(p);
    
    BodyPart text = new MimeBodyPart();
    
        text.setText("Envio de documento con los grupos formados");
        BodyPart attached = new MimeBodyPart();
        attached.setDataHandler(new DataHandler (new FileDataSource(fileChooser.getSelectedFile())));
        attached.setFileName(fileChooser.getSelectedFile().getName());
        MimeMultipart m = new MimeMultipart();
        m.addBodyPart(text);
        m.addBodyPart(attached);
    




    MimeMessage message = new MimeMessage(session);
    message.setFrom(new InternetAddress(email));
    message.addRecipient(Message.RecipientType.TO, new InternetAddress(destinyMail));
    message.setSubject("Envio de Grupos");
    message.setContent(m);
    
    Transport t = session.getTransport("smtp");
        t.connect(email, password);
        t.sendMessage(message, message.getAllRecipients());
        t.close();
        JOptionPane.showMessageDialog(null, "¡Correo enviado exitosamente!");
    }
    
//    public static void uploadfile (){
//    
//        JFileChooser fileChooser = new JFileChooser();
//         Component parent = null;
//                  int returnVal = fileChooser.showOpenDialog(parent);
//                  if (returnVal == JFileChooser.APPROVE_OPTION) {
//                  System.out.println("Se subio el registro: "
//                    + fileChooser.getSelectedFile().getName());
//                  
//                  route = 
//                  }
//    
//    }

    
    
    
}
