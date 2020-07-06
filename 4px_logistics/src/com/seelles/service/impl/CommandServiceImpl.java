package com.seelles.service.impl;

import com.seelles.mapper.CommandMapper;
import com.seelles.pojo.Command;
import com.seelles.service.CommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommandServiceImpl implements CommandService {
    @Autowired
    CommandMapper commandMapper;

    @Override
    public int add(Command command) {
        return commandMapper.insert(command);
    }

    @Override
    public int update(Command command) {
        return commandMapper.update(command);
    }

    @Override
    public List<Command> findAll() {
        return commandMapper.selectAll();
    }

    @Override
    public Command findOne(int cid) {
        return commandMapper.selectOne(cid);
    }

    @Override
    public int delete(int cid) {
        return commandMapper.delete(cid);
    }

    @Override
    public int rowCount() {
        return commandMapper.rowCount();
    }
}
