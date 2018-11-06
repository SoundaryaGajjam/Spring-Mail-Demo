package com.scp.mail;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailParseException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;




public class MailController {
	
	//without attachment
	 
	 /* private MailSender mailSender;   
    public void setMailSender(MailSender mailSender) {  
        this.mailSender = mailSender;  
    }  
    public void sendMail(String from, String to, String subject, String msg) {     
    	SimpleMailMessage message = new SimpleMailMessage();  
        message.setFrom(from);  
        message.setTo(to);  
        message.setSubject(subject);  
        message.setText(msg); 
        mailSender.send(message);     
     }  */
	
	
	//with attachment
	private JavaMailSender mailSender;
	private SimpleMailMessage simpleMailMessage;
	
	public void setSimpleMailMessage(SimpleMailMessage simpleMailMessage) {
		this.simpleMailMessage = simpleMailMessage;
	}

	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}
	
	public void sendMail(String dear, String content) {
	
	   MimeMessage message = mailSender.createMimeMessage();
		
	   try{
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
			
		helper.setFrom(simpleMailMessage.getFrom());
		helper.setTo(simpleMailMessage.getTo());
		helper.setSubject(simpleMailMessage.getSubject());
		helper.setText(String.format(
			simpleMailMessage.getText(), dear, content));
			
		FileSystemResource file = new FileSystemResource("E:\\Demo.java");
		helper.addAttachment(file.getFilename(), file);

	     }catch (MessagingException e) {
		throw new MailParseException(e);
	     }
	     mailSender.send(message);
         }
	
}
