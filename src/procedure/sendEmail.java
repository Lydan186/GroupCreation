/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package procedure;

import java.awt.Component;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * Esta clase es para mandar un email y poder mandar un archivo por email.
 *
 * @author josep
 */
public class sendEmail {

    static String affair;
    static String destinyMail = "";
    static String email = "programacion1javamail@gmail.com";
    static String message;
    static String password = "wdsvhouvpnlshako";
    static String route;

    /**
     * Procedimiento encargado para realizar el envio del correo electronico
     * junto al archivo txt con los grupos formados L-Code.(19 de setiembre de
     * 2022).Enviar correos desde Java 📧 | Gmail | 2022 [Video].
     * https://youtu.be/ZggjlwLzrxg Java y Otros.(22 de julio de 2021). Enviar
     * Correos Desde Java | Sin Archivos Adjuntos Y Con Archivos Adjuntos | 2021
     * [Video]. https://youtu.be/s5RYPoQTXBg
     *
     * @throws AddressException Por si se equivoca al digitar el correo
     * electronico.
     * @throws MessagingException Por el metodo de mandar mensajes por correo
     * electronico.
     */
    public static void sendMail() throws AddressException, MessagingException {

        Properties p = new Properties();

        p.put("mail.smtp.trust", "smtp.gmail.com");
        p.put("mail.smtp.auth", "true");
        p.put("mail.smtp.starttls.enable", "true");
        p.put("mail.smtp.host", "smtp.gmail.com");
        p.put("mail.smtp.port", "587");
        p.put("mail.smtp.user", email);

        destinyMail = JOptionPane.showInputDialog(null, "Digite el correo de "
                + "destino:");

        JFileChooser fileChooser = new JFileChooser();
        Component parent = null;
        int returnVal = fileChooser.showOpenDialog(parent);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            System.out.println("Se subio el registro: "
                    + fileChooser.getSelectedFile().getName());

        }

        Session session = Session.getDefaultInstance(p);

        BodyPart text = new MimeBodyPart();
        affair = JOptionPane.showInputDialog(null, "Digite el asunto");
        message = JOptionPane.showInputDialog(null, "Digite el mensaje del "
                + "correo");
        text.setText(message);
        BodyPart attached = new MimeBodyPart();
        attached.setDataHandler(new DataHandler
        (new FileDataSource(fileChooser.getSelectedFile())));
        attached.setFileName(fileChooser.getSelectedFile().getName());
        MimeMultipart m = new MimeMultipart();
        m.addBodyPart(text);
        m.addBodyPart(attached);

        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(email));
        message.addRecipient(Message.RecipientType.TO,
                new InternetAddress(destinyMail));
        message.setSubject(affair);
        message.setContent(m);

        Transport t = session.getTransport("smtp");
        t.connect(email, password);
        t.sendMessage(message, message.getAllRecipients());
        t.close();
        JOptionPane.showMessageDialog(null, "¡Correo enviado exitosamente!");
    }

}
