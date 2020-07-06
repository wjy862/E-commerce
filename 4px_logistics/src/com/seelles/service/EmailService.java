package com.seelles.service;

import com.seelles.pojo.Email;

import java.util.List;

public interface EmailService {
    public List<Email> showList(int recid);
    public int sendEmail(Email email);
}
