package com.wen.client;

import javax.annotation.Resource;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.wen.po.Mail;
import com.wen.po.User;

public class ReciveListen implements MessageListener {
	ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-mail.xml");
	 
	
	JavaMailSenderImpl mailSender=(JavaMailSenderImpl) context.getBean("mailSender");
	
	@Override
	public void onMessage(Message message) {
		
		ObjectMessage msg = (ObjectMessage) message;
		//System.out.println(msg);
		try {
			if (msg != null) {
				User user=(User) msg.getObject();
				System.out.println("�յ���Ϣ :  "+user);
				
				Mail mail=new Mail();
				mail.setFrom("17369379967@163.com");
				mail.setTo(user.getEmail());
				mail.setSubject("��֤�ʼ�");
				mail.setContent("http://10.0.0.74:9999/ActiveMq_UserRegister/activate?email="+user.getEmail()+"&activate=��");
				sendPureMail(mail);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//��ͨ�ı�Email
    public  void sendPureMail(Mail mail) {
        SimpleMailMessage message = new SimpleMailMessage();
 
        message.setFrom(mail.getFrom());
        message.setTo(mail.getTo());
        message.setSubject(mail.getSubject());
        message.setText(mail.getContent());
        mailSender.send(message);
    }
}
