package com.seelles.service.impl;


import com.seelles.mapper.AdressMapper;
import com.seelles.pojo.Adress;
import com.seelles.service.AdressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class AdressServiceImpl implements AdressService {
    @Autowired
    AdressMapper adressMapper;
    @Override
    public int add(Adress adress) {
        return adressMapper.insert(adress);
    }

    @Override
    public int update(Adress adress) {
        return adressMapper.update(adress);
    }

    @Override
    public List<Adress> findAll() {
        return adressMapper.selectAll();
    }

    @Override
    public Adress findOne(int aid) {
        return adressMapper.selectOne(aid);
    }

    @Override
    public int delete(int aid) {
        return adressMapper.delete(aid);
    }

    @Override
    public int rowCount() {
        return adressMapper.rowCount();
    }
}
