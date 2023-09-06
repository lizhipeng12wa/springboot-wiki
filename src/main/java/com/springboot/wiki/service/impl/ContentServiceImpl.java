package com.springboot.wiki.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springboot.wiki.pojo.Content;
import com.springboot.wiki.service.ContentService;
import com.springboot.wiki.mapper.ContentMapper;
import org.springframework.stereotype.Service;

/**
* @author lenovo
* @description 针对表【content】的数据库操作Service实现
* @createDate 2023-06-28 17:31:27
*/
@Service
public class ContentServiceImpl extends ServiceImpl<ContentMapper, Content>
    implements ContentService{

}




