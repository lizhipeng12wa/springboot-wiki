package com.springboot.wiki.controller;

import com.springboot.wiki.pojo.Content;
import com.springboot.wiki.pojo.Doc;
import com.springboot.wiki.pojo.req.DocSaveReq;
import com.springboot.wiki.pojo.resp.CommonResp;
import com.springboot.wiki.pojo.resp.DocQueryResp;
import com.springboot.wiki.service.ContentService;
import com.springboot.wiki.service.DocService;
import com.springboot.wiki.utils.CopyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

/**
 * @author li
 * @version 1.0
 * @ClassName DocController
 * @date 2023/7/4 18:48
 * @since 1.0
 */
@RestController
@RequestMapping("/doc")
public class DocController {
    @Autowired
    private DocService docService;

    @Autowired
    private ContentService contentService;


    @GetMapping("/allList/{ebookId}")
    public CommonResp allList(@PathVariable Long ebookId){
        List<DocQueryResp> resp = docService.allList(ebookId);
        CommonResp<List<DocQueryResp>> listCommonResp = new CommonResp<>();
        listCommonResp.setContent(resp);
        return listCommonResp;
    }

    @PostMapping("/save")
    public CommonResp save(@Valid @RequestBody DocSaveReq req){
        Doc doc = CopyUtil.copy(req, Doc.class);
        docService.saveOrUpdate(doc);

        Content content = CopyUtil.copy(req, Content.class);
        contentService.saveOrUpdate(content);

        CommonResp resp = new CommonResp<>();
        return resp;
    }

    @GetMapping("/remove")
    public CommonResp remove(Long [] ids){
        List<Long> list = Arrays.asList(ids);
        docService.removeByIds(list);

        CommonResp<Object> resp = new CommonResp<>();
        return resp;
    }


    @GetMapping("/findContentById/{id}")
    public CommonResp findContentById(@PathVariable Long id){
        Content content = contentService.getById(id);

        CommonResp<String> resp = new CommonResp<>();
        if (content!=null && content.getContent()!=null){
            resp.setContent(content.getContent());
        }
        return resp;
    }

}