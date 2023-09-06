package com.springboot.wiki.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springboot.wiki.pojo.Category;
import com.springboot.wiki.pojo.Ebook;
import com.springboot.wiki.pojo.req.CategoryQueryReq;
import com.springboot.wiki.pojo.resp.CategoryQueryResp;
import com.springboot.wiki.pojo.resp.PageResp;
import com.springboot.wiki.service.CategoryService;
import com.springboot.wiki.mapper.CategoryMapper;
import com.springboot.wiki.utils.CopyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
* @author lenovo
* @description 针对表【category】的数据库操作Service实现
* @createDate 2023-06-28 17:31:27
*/
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category>
    implements CategoryService{
    //打印日志
    private static final Logger LOG = LoggerFactory.getLogger(CategoryService.class);
    @Override
    public PageResp<CategoryQueryReq> getCategoryListByPage(CategoryQueryReq req) {
        Page<Category> page = new Page<>(req.getPage(), req.getSize());
        page = this.page(page);
        List<Category> list = page.getRecords();

        LOG.info("总行数：{}",page.getTotal()+"");
        LOG.info("总页数：{}",page.getPages()+"");

        List<CategoryQueryReq> categoryResps = CopyUtil.copyList(list, CategoryQueryReq.class);

        PageResp<CategoryQueryReq> repsPage = new PageResp<>();
        repsPage.setList(categoryResps);
        repsPage.setTotal(page.getTotal());
        return repsPage;
    }

    @Override
    public List<CategoryQueryResp> allList(CategoryQueryReq req) {
        Page<Ebook> page = new Page<>(req.getPage(), req.getSize());
        QueryWrapper<Category> wrapper = new QueryWrapper<>();
        if (!ObjectUtils.isEmpty(req.getName())){
            wrapper.like("name",req.getName());
        }else {
            wrapper.orderByAsc("sort");
        }
        List<Category> list = this.list(wrapper);

        List<CategoryQueryResp> resp = CopyUtil.copyList(list, CategoryQueryResp.class);
        return resp;
    }
}




