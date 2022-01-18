package com.hdd.mailsender.service;

import com.hdd.mailsender.dto.ClientSdi;
import com.hdd.mailsender.dto.DataMailDTO;
import com.hdd.mailsender.utils.Const;
import com.hdd.mailsender.utils.DataUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.HashMap;
import java.util.Map;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private MailService mailService;

    @Override
    public Boolean created(ClientSdi clientSdi) {

        try {
            DataMailDTO dataMailDTO = new DataMailDTO();
            dataMailDTO.setTo(clientSdi.getEmail());
            dataMailDTO.setSubject(Const.SEND_MAIL_SUBJECT.CLIENT_REGISTER);
            Map<String, Object> props = new HashMap<>();
            props.put("name", clientSdi.getName());
            props.put("username", clientSdi.getUsername());
            props.put("password", DataUtils.generateTempPwd(6));
            dataMailDTO.setProps(props);

            mailService.sendHtmlMail(dataMailDTO, Const.TEMPLATE_FILE_NAME.CLIENT_REGISTER);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return true;
    }
}
