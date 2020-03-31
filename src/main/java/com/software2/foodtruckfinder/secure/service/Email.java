package com.software2.foodtruckfinder.secure.service;
import java.util.*;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class Email {
    private final String from = "wwm.notifications@gmail.com";
    private final String password = "BaylorB3Ars!";

    public String to, sub, msg;

    public boolean send() {
        //Get properties object
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        //get Session
        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(from, password);
                    }
                });
        //compose message
        try {
            MimeMessage message = new MimeMessage(session);
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(sub);
            message.setText(msg);
            //send message
            Transport.send(message);
            System.out.println("message sent successfully to " + to + "msg:" + msg);
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Email{" +
                "from='" + from + '\'' +
                ", password='" + password + '\'' +
                ", to='" + to + '\'' +
                ", sub='" + sub + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }

    public Email(String to, String sub, String msg) {
        this.to = to;
        this.sub = sub;
        this.msg = msg;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
