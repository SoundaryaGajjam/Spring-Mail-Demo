package com.scp.mail;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {
	public static void main(String[] args) {
		ApplicationContext cxt=new ClassPathXmlApplicationContext("application-context.xml");
		
		
		MailController m=(MailController) cxt.getBean("mailMail"); 
		
		m.sendMail("XYZ", "Welcome to the Spring world !!!!");
	      /* without attachment
	       * 
	       * String sender="soundaryagajjam@gmail.com";//write here sender gmail id  
	      String receiver="konark.modi24@gmail.com";//write here receiver id  
	      m.sendMail(sender,receiver,"Spring Mail Demo","welcome to the spring world !!!"); */ 
	      System.out.println("success");  
    
       
	}
}
