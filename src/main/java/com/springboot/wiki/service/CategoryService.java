package com.springboot.wiki.service;

import com.springboot.wiki.pojo.Category;
import com.baomidou.mybatisplus.extension.service.IService;
import com.springboot.wiki.pojo.req.CategoryQueryReq;
import com.springboot.wiki.pojo.req.EbookQueryReq;
import com.springboot.wiki.pojo.resp.CategoryQueryResp;
import com.springboot.wiki.pojo.resp.EbookQueryResp;
import com.springboot.wiki.pojo.resp.PageResp;

import java.util.List;

/**
* @author lenovo
* @description 针对表【category】的数据库操作Service
* @createDate 2023-06-28 17:31:27
*/
public interface CategoryService extends IService<Category> {
    PageResp<CategoryQueryReq> getCategoryListByPage(CategoryQueryReq req);

    List<CategoryQueryResp> allList(CategoryQueryReq req);
}
