package com.springboot.wiki.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springboot.wiki.exception.BusinessException;
import com.springboot.wiki.exception.BusinessExceptionCode;
import com.springboot.wiki.pojo.Ebook;
import com.springboot.wiki.pojo.req.EbookQueryReq;
import com.springboot.wiki.pojo.resp.EbookQueryResp;
import com.springboot.wiki.pojo.resp.PageResp;
import com.springboot.wiki.service.CategoryService;
import com.springboot.wiki.service.EbookService;
import com.springboot.wiki.mapper.EbookMapper;
import com.springboot.wiki.utils.CopyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.UUID;

/**
* @author lenovo
* @description 针对表【ebook(电子书)】的数据库操作Service实现
* @createDate 2023-06-28 17:31:27
*/
@Service
public class EbookServiceImpl extends ServiceImpl<EbookMapper, Ebook>
    implements EbookService{

    private static final Logger LOG = LoggerFactory.getLogger(CategoryService.class);
    @Override
    public List<EbookQueryResp> getEbooksByEbooksReq(EbookQueryReq ebookQueryReq) {

        QueryWrapper<Ebook> queryWrapper = new QueryWrapper<>();
        if(!ObjectUtils.isEmpty(ebookQueryReq.getName())) {
            queryWrapper.like("name", ebookQueryReq.getName());
        }
        List<Ebook> ebooks = this.list(queryWrapper);
        List<EbookQueryResp> ebookQueryResps = CopyUtil.copyList(ebooks, EbookQueryResp.class);
        return ebookQueryResps;
    }

    @Override
    public String uploadImage(MultipartFile file, String folder) {
        if (file == null) {
            throw new BusinessException(BusinessExceptionCode.Select_Upload_Image);
        }
        if (file.getSize() > 1024 * 1024 * 10) {
            throw new BusinessException(BusinessExceptionCode.Files_Larger_Than_10M);
        }
        //获取文件后缀
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1, file.getOriginalFilename().length());
        if (!"jpg,jpeg,gif,png".toUpperCase().contains(suffix.toUpperCase())) {
            throw new BusinessException(BusinessExceptionCode.Files_Wrong_Format);
        }
        String savePath = folder;
        File savePathFile = new File(savePath);
        if (!savePathFile.exists()) {
            //若不存在该目录，则创建目录
            savePathFile.mkdir();
        }
        //通过UUID生成唯一文件名
        String filename = UUID.randomUUID().toString().replaceAll("-","") + "." + suffix;
        try {
            //将文件保存指定目录
            file.transferTo(new File(savePath + filename));
            File file1 = new File(file.getOriginalFilename());
            //FileUtils.copyInputStreamToFile(file.getInputStream(),new File(savePath + filename));
        } catch (Exception e) {
            e.printStackTrace();
            throw new BusinessException(BusinessExceptionCode.Save_File_Exception);
        }
        //返回文件名称
        //LOG.info("文件名:{}",filename);

        return filename;
    }

    @Override
    public PageResp<EbookQueryResp> getEbookListByPage(EbookQueryReq req) {
        Page<Ebook> page = new Page<>(req.getPage(), req.getSize());

        QueryWrapper<Ebook> wrapper = new QueryWrapper<>();
        if (!ObjectUtils.isEmpty(req.getCategory2Id())&&req.getCategory2Id()!=0){
            wrapper.like("category2_id",req.getCategory2Id());
        }
        if (!ObjectUtils.isEmpty(req.getName())){
            wrapper.like("name",req.getName());
        }
        page = this.page(page,wrapper);


        List<Ebook> list = page.getRecords();

        LOG.info("总行数：{}",page.getTotal()+"");
        LOG.info("总页数：{}",page.getPages()+"");

        List<EbookQueryResp> ebookResps = CopyUtil.copyList(list, EbookQueryResp.class);

        PageResp<EbookQueryResp> respPage = new PageResp<>();
        respPage.setTotal(page.getTotal());
        respPage.setList(ebookResps);
        return respPage;
    }
}




