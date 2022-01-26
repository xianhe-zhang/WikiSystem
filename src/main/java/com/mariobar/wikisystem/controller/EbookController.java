package com.mariobar.wikisystem.controller;

import com.mariobar.wikisystem.resp.CommonResp;
import com.mariobar.wikisystem.service.EbookService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/ebook")
public class EbookController {

  @Resource
  private EbookService ebookService;

  @GetMapping("/list")
  public CommonResp list(@Valid EbookQueryReq req) {
    CommonResp<PageResp<EbookQueryResp>> resp = new CommonResp<>();
    PageResp<EbookQueryResp> list = ebookService.list(req);
    resp.setContent(list);
    return resp;
  }

  @PostMapping("/save")
  public CommonResp save(@Valid @RequestBody EbookSaveReq req) {
    CommonResp resp = new CommonResp<>();
    ebookService.save(req);
    return resp;
  }

  @DeleteMapping("/delete/{id}")
  public CommonResp delete(@PathVariable Long id) {
    CommonResp resp = new CommonResp<>();
    ebookService.delete(id);
    return resp;
  }
}
