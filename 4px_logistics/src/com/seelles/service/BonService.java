package com.seelles.service;

import com.seelles.pojo.Bon;

import java.util.List;

public interface BonService {
    public int add(Bon bon);
    public int update(Bon bon);
    public List<Bon> findAll();
    public Bon findOne(int bid);
    public int delete(int bid);
    public int rowCount();
}
