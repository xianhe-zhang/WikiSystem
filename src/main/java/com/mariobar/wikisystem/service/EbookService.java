package com.mariobar.wikisystem.service;
/**
 * NOTE: Util类就是为了"提取公因式，把一些常用的共性Service part拿出来，封装成类。"
 */

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mariobar.wikisystem.domain.Ebook;
import com.mariobar.wikisystem.domain.EbookExample;
import com.mariobar.wikisystem.mapper.EbookMapper;
import com.mariobar.wikisystem.util.CopyUtil;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EbookService {
  private static final Logger LOG = LoggerFactory.getLogger(EbookService.class);

  @Resource
  private EbookMapper ebookMapper;

  @Resource
  private SnowFlake snowFlake;

  public PageResp<EbookQueryResp> list(EbookQueryReq req) {
    EbookExample ebookExample = new EbookExample();
    EbookExample.Criteria criteria = ebookExample.createCriteria();
    if (!ObjectUtils.isEmpty(req.getName())) {
      criteria.andNameLike("%" + req.getName() + "%");
    }
    if (!ObjectUtils.isEmpty(req.getCategoryId2())) {
      criteria.andCategory2IdEqualTo(req.getCategoryId2());
    }
    PageHelper.startPage(req.getPage(), req.getSize());
    List<Ebook> ebookList = ebookMapper.selectByExample(ebookExample);

    PageInfo<Ebook> pageInfo = new PageInfo<>(ebookList);
    LOG.info("总行数：{}", pageInfo.getTotal());
    LOG.info("总页数：{}", pageInfo.getPages());

    // List<EbookResp> respList = new ArrayList<>();
    // for (Ebook ebook : ebookList) {
    //     // EbookResp ebookResp = new EbookResp();
    //     // BeanUtils.copyProperties(ebook, ebookResp);
    //     // 对象复制
    //     EbookResp ebookResp = CopyUtil.copy(ebook, EbookResp.class);
    //
    //     respList.add(ebookResp);
    // }

    // 列表复制
    List<EbookQueryResp> list = CopyUtil.copyList(ebookList, EbookQueryResp.class);

    PageResp<EbookQueryResp> pageResp = new PageResp();
    pageResp.setTotal(pageInfo.getTotal());
    pageResp.setList(list);

    return pageResp;
  }

  /**
   * 保存
   */
  public void save(EbookSaveReq req) {
    Ebook ebook = CopyUtil.copy(req, Ebook.class);
    if (ObjectUtils.isEmpty(req.getId())) {
      // 新增
      ebook.setId(snowFlake.nextId());
      ebookMapper.insert(ebook);
    } else {
      // 更新
      ebookMapper.updateByPrimaryKey(ebook);
    }
  }

  public void delete(Long id) {
    ebookMapper.deleteByPrimaryKey(id);
  }
}
