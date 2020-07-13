/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication8;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

/**
 *
 * @author march
 */
public class EnviarCorreo {
    
    public static String user ="marchelo.1989@live.cl";
    public static String pass= "2117la";
//    String Menasje = "Hola ";
//    String To="marchelo.bm@hotmail.com";
//    String Subject = "Prueba";
    
    
    
    public void enviarMail(String Menasje,String To,String Subject){
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.live.com");
        props.put("mail.smtp.port", "587");
        
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication(){
                        return new PasswordAuthentication(user, pass);
                    };
        });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(To));
            message.setSubject(Subject);
            message.setText(Menasje);
            
            Transport.send(message);
//            JOptionPane.showMessageDialog(null, "Su mensaje ha sido enviado");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
