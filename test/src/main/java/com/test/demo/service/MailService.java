package com.test.demo.service;

import org.springframework.stereotype.Repository;

@Repository
public interface MailService {
    public void sendSimpleMail(String to, String subject, String content);
}
