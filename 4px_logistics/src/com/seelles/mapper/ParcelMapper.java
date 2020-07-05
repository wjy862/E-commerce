package com.seelles.mapper;

import com.seelles.pojo.Parcel;

import java.util.List;

public interface ParcelMapper {
    public List<Parcel> selectAll();

    public Parcel selectOne(int pid);

    // public parcel selectJoin(int pid);

    public int insert(Parcel parcel);

    public int delete(int pid);

    public int update(Parcel parcel);

    public int rowCount();
}
