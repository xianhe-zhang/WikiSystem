package com.mariobar.wikisystem.service;

import com.mariobar.wikisystem.domain.Demo;
import com.mariobar.wikisystem.mapper.DemoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DemoService {

    @Resource
    private DemoMapper demoMapper;

    public List<Demo> list() {
        return demoMapper.selectByExample(null);
    }
}
