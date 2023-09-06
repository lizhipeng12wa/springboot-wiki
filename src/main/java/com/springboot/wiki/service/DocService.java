package com.springboot.wiki.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.springboot.wiki.pojo.Doc;
import com.springboot.wiki.pojo.resp.DocQueryResp;

import java.util.List;

/**
* @author lenovo
* @description 针对表【doc】的数据库操作Service
* @createDate 2023-06-28 17:31:27
*/
public interface DocService extends IService<Doc> {
    List<DocQueryResp> allList(Long ebookId);
}
