package com.neo.service.serviceImpl;

import com.neo.dao.TestDao;
import com.neo.entity.Test;
import com.neo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    TestDao testDao;

    @Override
    public int insertOne(Test test) {

        testDao.insertOne(test);
        return 1;
    }
}
