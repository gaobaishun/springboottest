package com.neo.dao;

import com.neo.entity.Test;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
public interface TestDao {

    void insertOne(Test test);
}
