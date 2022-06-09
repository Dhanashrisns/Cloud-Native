package com.cloudnative.OTT.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionService {

  @Autowired
  JavaMailSender javaMailSender;

  private void sendEmail(){
    SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
    simpleMailMessage.setTo("sanasdhanashri13@gmail.com");
    simpleMailMessage.setSubject("OTT subscription");
    simpleMailMessage.setText("Your subscription has been activated");
    javaMailSender.send(simpleMailMessage);


  }
}
