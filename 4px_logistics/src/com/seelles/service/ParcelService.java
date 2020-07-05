package com.seelles.service;

import com.seelles.pojo.Parcel;

import java.util.List;

public interface ParcelService {
    public int add(Parcel parcel);
    public int update(Parcel parcel);
    public List<Parcel> findAll();
    public Parcel findOne(int pid);
    public int delete(int pid);
    public int rowCount();
    
}
