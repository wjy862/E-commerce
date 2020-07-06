package com.seelles.mapper;

import com.seelles.pojo.Bon;

import java.util.List;

public interface BonMapper {
    public List<Bon> selectAll();

    public Bon selectOne(int bid);

    // public Bon selectJoin(int pid);

    public int insert(Bon bon);

    public int delete(int bid);

    public int update(Bon bon);

    public int rowCount();
}
