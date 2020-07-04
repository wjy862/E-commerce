package com.seelles.mapper;

import com.seelles.pojo.Adress;

import java.util.List;

public interface AdressMapper {

    public List<Adress> selectAll();

    public Adress selectOne(int aid);

    public int insert(Adress adress);

    public int delete(int aid);

    public int update(Adress adress);

    public int rowCount();
}
