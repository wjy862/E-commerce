package com.seelles.service.impl;

import com.seelles.mapper.ParcelMapper;
import com.seelles.pojo.Parcel;
import com.seelles.service.ParcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ParcelServiceImpl implements ParcelService {
    @Autowired
    ParcelMapper parcelMapper;

    @Override
    public int add(Parcel parcel) {
        return parcelMapper.insert(parcel);
    }

    @Override
    public int update(Parcel parcel) {
        return parcelMapper.update(parcel);
    }

    @Override
    public List<Parcel> findAll() {
        return parcelMapper.selectAll();
    }

    @Override
    public Parcel findOne(int pid) {
        return parcelMapper.selectOne(pid);
    }

    @Override
    public int delete(int pid) {
        return parcelMapper.delete(pid);
    }

    @Override
    public int rowCount() {
        return parcelMapper.rowCount();
    }
}
