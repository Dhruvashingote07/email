package com.java_email.email;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import java.util.Properties;

public class emailSender{

    public static void main(String[] args) {

        // 1. Configure the recipient and your sender information
        String to = "dhruvshingote770@gmail.com"; 
        String from = "civicwatch.pune@gmail.com";
        // Use the 16-character App Password generated in Step 1 (NO SPACES)
        String appPassword = "srzv tjro vhur loyn"; 

        // 2. Set SMTP server properties for Gmail
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587"); // TLS Port
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true"); // Enable TLS

        // 3. Authenticate and create a session
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, appPassword);
            }
        });

        // Optional: Turn on logs to debug SMTP communication in the console
        session.setDebug(true);

        try {
            // 4. Create the email message
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            
            // Set Subject and Body text
            message.setSubject("Testing Java Email Sender");
            message.setText("Hello! This email was sent automatically from a Java application using Gmail SMTP.");

            // 5. Send the email
            System.out.println("Sending email...");
            Transport.send(message);
            System.out.println("Success! Email sent successfully.");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}


