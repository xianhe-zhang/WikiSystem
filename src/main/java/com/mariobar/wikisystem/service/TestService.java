package com.mariobar.wikisystem.service;

import com.mariobar.wikisystem.domain.Test;
import com.mariobar.wikisystem.mapper.TestMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TestService {

    @Resource
    private TestMapper testMapper;

    public List<Test> list() {
        return testMapper.list();
    }
}
