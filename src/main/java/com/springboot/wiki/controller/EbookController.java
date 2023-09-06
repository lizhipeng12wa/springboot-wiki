package com.springboot.wiki.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.springboot.wiki.pojo.Ebook;
import com.springboot.wiki.pojo.req.EbookQueryReq;
import com.springboot.wiki.pojo.req.EbookSaveReq;
import com.springboot.wiki.pojo.resp.CommonResp;
import com.springboot.wiki.pojo.resp.EbookQueryResp;
import com.springboot.wiki.pojo.resp.PageResp;
import com.springboot.wiki.service.EbookService;
import com.springboot.wiki.utils.CopyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

/**
 * @author li
 * @version 1.0
 * @ClassName EbookController
 * @date 2023/6/30 10:48
 * @since 1.0
 */
//电子书相关处理器方法
@RestController
@RequestMapping("/ebook")
public class EbookController {

    @Autowired
    EbookService ebookService;
    @GetMapping("/getEbooksByEbooksReq")
    public CommonResp getEbooksByEbooksReq(EbookQueryReq ebookQueryReq){
        List<EbookQueryResp> ebooksByEbooksReq = ebookService.getEbooksByEbooksReq(ebookQueryReq);
        CommonResp<List<EbookQueryResp>> commonResp = new CommonResp<>();
        commonResp.setContent(ebooksByEbooksReq);
        return commonResp;
    }

    @GetMapping("/getEbookListByPage")
    public CommonResp getEbookListByPage(@Valid EbookQueryReq ebookQueryReq){
        System.out.println(ebookQueryReq.getCategory2Id());
        PageResp<EbookQueryResp> ebookListByPage = ebookService.getEbookListByPage(ebookQueryReq);

        CommonResp<PageResp<EbookQueryResp>> resp = new CommonResp<>();  // 从原来的只携带分页数据-> 除了数据 还有总页数
        resp.setContent(ebookListByPage);
        return resp;
    }

    /*@GetMapping("/getEbooksByPage")
    public CommonResp getEbookByPage(EbookQueryReq req){
        Page<Ebook> page = new Page<>(req.getPage(),req.getSize());
        page = ebookService.page(page);//根据分页数据，分页查询，并封装到page中

        List<Ebook> records = page.getRecords();//将获取page中的数据信息

        PageResp<EbookQueryResp> pageResp = new PageResp<>();
        Long total = page.getTotal();//获取page中的总条数信息
        pageResp.setTotal(total);
        List<EbookQueryResp> ebookQueryResps = CopyUtil.copyList(records, EbookQueryResp.class);//将page中获取的数据信息EbookResp类型
        //将封装的详细信息一起封装到pageResp中
        pageResp.setList(ebookQueryResps);

        CommonResp<PageResp<EbookQueryResp>> commonResp = new CommonResp<>();//将pageResp继续封装为统一响应信息
        commonResp.setContent(pageResp);
        return commonResp;
    }*/


    @PostMapping("/save")
    public CommonResp save(@Valid @RequestBody EbookSaveReq req){
        Ebook ebook = CopyUtil.copy(req, Ebook.class);
        ebookService.saveOrUpdate(ebook);
        CommonResp commonResp = new CommonResp<>();
        return commonResp;
    }

    @GetMapping("/remove")
    public CommonResp remove(int id){
        ebookService.removeById(id);
        CommonResp<Object> resp = new CommonResp<>();
        return resp;
    }


    @PostMapping("/uploadImage")
    public CommonResp uploadImage(@RequestParam(value = "file", required = false) MultipartFile file){
        //动态获取项目所在的根目录
        String path = System.getProperty("user.dir");
        System.out.println(path);
        // 根目录的上一级
        String path2 = path.substring(0,path.lastIndexOf("\\"));
        System.out.println("path ============== " + path2);
        String imageName = ebookService.uploadImage(file, path2+"\\wiki_vue\\public\\image\\");
        CommonResp<Object> resp = new CommonResp<>();
        resp.setContent(imageName);
        return resp;
    }
}
