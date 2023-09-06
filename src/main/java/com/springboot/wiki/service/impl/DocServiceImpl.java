package com.springboot.wiki.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springboot.wiki.mapper.DocMapper;
import com.springboot.wiki.pojo.Doc;
import com.springboot.wiki.pojo.req.DocQueryReq;
import com.springboot.wiki.pojo.resp.DocQueryResp;
import com.springboot.wiki.service.DocService;
import com.springboot.wiki.utils.CopyUtil;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author lenovo
* @description 针对表【doc】的数据库操作Service实现
* @createDate 2023-06-28 17:31:27
*/
@Service
public class DocServiceImpl extends ServiceImpl<DocMapper, Doc>
    implements DocService{
    @Override
    public List<DocQueryResp> allList(Long ebookId) {
        QueryWrapper<Doc> wrapper = new QueryWrapper<>();
        wrapper.orderByAsc("sort");

        wrapper.eq("ebook_id",ebookId);
        List<Doc> list = this.list(wrapper);

        List<DocQueryResp> resp = CopyUtil.copyList(list, DocQueryResp.class);
        return resp;
    }
}




