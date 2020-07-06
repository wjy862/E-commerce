package com.seelles.mapper;

import com.seelles.pojo.Command;

import java.util.List;

public interface CommandMapper {
    public List<Command> selectAll();

    public Command selectOne(int cid);

   // public Command selectJoin(int uid);

    public int insert(Command command);

    public int delete(int cid);

    public int update(Command command);

    public int rowCount();
}
