package com.mariobar.wikisystem.service;

import com.mariobar.wikisystem.domain.Ebook;
import com.mariobar.wikisystem.mapper.EbookMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EbookService {

  @Resource
  private EbookMapper ebookMapper;

  public List<Ebook> list() {
    return ebookMapper.selectByExample(null);
  }
}
