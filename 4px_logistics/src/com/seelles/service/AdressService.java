package com.seelles.service;

import com.seelles.pojo.Adress;

import java.util.List;

public interface AdressService {
    public int add(Adress adress);
    public int update(Adress adress);
    public List<Adress> findAll();
    public Adress findOne(int aid);
    public int delete(int aid);
    public int rowCount();
}
