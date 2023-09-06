package com.springboot.wiki.service;

import com.springboot.wiki.pojo.Ebook;
import com.baomidou.mybatisplus.extension.service.IService;
import com.springboot.wiki.pojo.req.EbookQueryReq;
import com.springboot.wiki.pojo.resp.EbookQueryResp;
import com.springboot.wiki.pojo.resp.PageResp;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
* @author lenovo
* @description 针对表【ebook(电子书)】的数据库操作Service
* @createDate 2023-06-28 17:31:28
*/
public interface EbookService extends IService<Ebook> {
    public List<EbookQueryResp> getEbooksByEbooksReq(EbookQueryReq ebookQueryReq);
    public String uploadImage(MultipartFile file, String folder);

    public PageResp<EbookQueryResp> getEbookListByPage(EbookQueryReq req);
}
