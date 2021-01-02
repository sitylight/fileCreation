package com.rabbitchop.base;

import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

@Repository
public interface CustomMapper<T> extends Mapper<T>, MySqlMapper<T>, IdsMapper<T> {

}
