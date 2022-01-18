package com.hdd.mailsender.service;

import com.hdd.mailsender.dto.DataMailDTO;

import javax.mail.MessagingException;

public interface MailService {
    void sendHtmlMail(DataMailDTO dataMail, String templateName) throws MessagingException;
}
