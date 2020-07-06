package com.seelles.service;

import com.seelles.pojo.Command;

import java.util.List;

public interface CommandService {
    public int add(Command command);
    public int update(Command command);
    public List<Command> findAll();
    public Command findOne(int cid);
    public int delete(int cid);
    public int rowCount();
}
