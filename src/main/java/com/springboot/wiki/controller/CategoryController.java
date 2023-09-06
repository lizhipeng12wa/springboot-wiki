package com.springboot.wiki.controller;

import com.springboot.wiki.pojo.Category;
import com.springboot.wiki.pojo.req.CategoryQueryReq;
import com.springboot.wiki.pojo.resp.CategoryQueryResp;
import com.springboot.wiki.pojo.resp.CommonResp;
import com.springboot.wiki.pojo.resp.PageResp;
import com.springboot.wiki.service.CategoryService;
import com.springboot.wiki.utils.CopyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author li
 * @version 1.0
 * @ClassName CategoryController
 * @date 2023/7/3 9:59
 * @since 1.0
 */
@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/getCategoryListByPage")
    public CommonResp getCategoryListByPage(CategoryQueryReq req){
        PageResp<CategoryQueryReq> repsPage = categoryService.getCategoryListByPage(req);
        CommonResp<PageResp<CategoryQueryReq>> resp = new CommonResp<>();
        resp.setContent(repsPage);
        return resp;
    }

    @PostMapping("/save")
    public CommonResp save(@RequestBody CategoryQueryReq req){
        Category category = CopyUtil.copy(req, Category.class);
        categoryService.saveOrUpdate(category);

        CommonResp resp = new CommonResp<>();
        return resp;
    }

    @GetMapping("/remove")
    public CommonResp remove(int id){
        categoryService.removeById(id);
        CommonResp<Object> resp = new CommonResp<>();
        return resp;
    }

    @GetMapping("/allList")
    public CommonResp allList(CategoryQueryReq req){
        List<CategoryQueryResp> resp = categoryService.allList(req);
        CommonResp<List<CategoryQueryResp>> listCommonResp = new CommonResp<>();
        listCommonResp.setContent(resp);
        return listCommonResp;
    }

}
