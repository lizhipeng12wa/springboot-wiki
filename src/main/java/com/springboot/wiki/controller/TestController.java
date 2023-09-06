package com.springboot.wiki.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.springboot.wiki.pojo.Ebook;
import com.springboot.wiki.pojo.req.EbookQueryReq;
import com.springboot.wiki.pojo.resp.CommonResp;
import com.springboot.wiki.pojo.resp.EbookQueryResp;
import com.springboot.wiki.service.EbookService;
import com.springboot.wiki.utils.CopyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author li
 * @version 1.0
 * @ClassName TestController
 * @date 2023/6/28 15:44
 * @since 1.0
 */
@RestController//由于是前后端分离项目，所有只需要对请求信息进行处理，返回json格式信息
public class TestController {

    @Autowired
    EbookService ebookService;

    @GetMapping("/hello")
    public String hello(){
        return "hello springboot";
    }

    @PostMapping("/hello/test")
    public String test(String name){
        return name + "hello";
    }

    @GetMapping("/getEbook")
    public List<Ebook> getEbook(){
        List<Ebook> ebooks = ebookService.list();
        return ebooks;
    }

    @GetMapping("/getEbooks")
    public CommonResp getEbooks(){
        List<Ebook> EBook = ebookService.list();
        CommonResp<List<Ebook>> commonResp = new CommonResp<>();
        commonResp.setContent(EBook);
        return commonResp;
    }

    /*
    对于springboot，sql语句查询可以使用
    QueryWrapper<Ebook> queryWrapper = new QueryWrapper<>();//添加查询条件
    queryWrapper.like("name",name);
    上述代码完成了对查询语句添加 "name" like %name%的查询条件
     */

  /*
    @GetMapping("getEBooksByName")
    public CommonResp getEBooksByName(String name){//将请求信息封装为一个EbookReq的类
        QueryWrapper<Ebook> queryWrapper = new QueryWrapper<>();//添加查询条件
        queryWrapper.like("name",name);
        List<Ebook> ebooks = ebookService.list(queryWrapper);//将返回结果转化为一个关于EbookResp的类
        CommonResp<List<Ebook>> commonResp = new CommonResp<>();
        commonResp.setContent(ebooks);
        return commonResp;
    }*/

    /*
    使用请求封装类对请求信息进行封装(EbookReq)
    使用封装类对查询结果封装(EbookResp)，再将封装好的查询结果使用响应封装类封装(CommonResp)
     */

    @GetMapping("getEBooksByName")
    public CommonResp getEBooksByName(EbookQueryReq req) {
        QueryWrapper<Ebook> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name", req.getName());
        List<Ebook> ebooks = ebookService.list(queryWrapper);
        List<EbookQueryResp> ebookQueryResps = CopyUtil.copyList(ebooks, EbookQueryResp.class);
        CommonResp<List<EbookQueryResp>> commonResp = new CommonResp<>();
        commonResp.setContent(ebookQueryResps);
        return commonResp;
    }



    @GetMapping("/getEbookListByPage")
    public CommonResp getEbookListByPage(@RequestParam("current") int current, @RequestParam("size") int size){
        Page<Ebook> page = new Page<>(current, size);
        page = ebookService.page(page);
        List<Ebook> list = page.getRecords();

        CommonResp<Page<Ebook>> resp = new CommonResp<>();
        resp.setContent(page);
        return resp;
    }
}
