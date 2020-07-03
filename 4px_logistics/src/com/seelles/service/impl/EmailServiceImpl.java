package com.seelles.service.impl;

import com.seelles.mapper.EmailMapper;
import com.seelles.pojo.Email;
import com.seelles.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmailServiceImpl implements EmailService {
    @Autowired
    EmailMapper emailMapper;

    @Override
    public List<Email> showList(int recid) {
       return emailMapper.selectJoin(recid);
    }

    @Override
    public int sendEmail(Email email) {
        return emailMapper.insert(email);
    }
}
