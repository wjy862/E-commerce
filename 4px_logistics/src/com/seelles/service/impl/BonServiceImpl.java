package com.seelles.service.impl;

import com.seelles.mapper.BonMapper;

import com.seelles.pojo.Bon;

import com.seelles.service.BonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BonServiceImpl implements BonService {
    @Autowired
    BonMapper bonMapper;

    @Override
    public int add(Bon bon) {
        return bonMapper.insert(bon);
    }

    @Override
    public int update(Bon bon) {
        return bonMapper.update(bon);
    }

    @Override
    public List<Bon> findAll() {
        return bonMapper.selectAll();
    }

    @Override
    public Bon findOne(int bid) {
        return bonMapper.selectOne(bid);
    }

    @Override
    public int delete(int bid) {
        return bonMapper.delete(bid);
    }

    @Override
    public int rowCount() {
        return bonMapper.rowCount();
    }
}