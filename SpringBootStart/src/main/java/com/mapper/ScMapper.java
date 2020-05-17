package com.mapper;

import com.entity.Sc;

public interface ScMapper {
    int insert(Sc record);

    int insertSelective(Sc record);
}