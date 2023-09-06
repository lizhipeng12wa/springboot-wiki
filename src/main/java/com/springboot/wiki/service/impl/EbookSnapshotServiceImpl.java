package com.springboot.wiki.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springboot.wiki.pojo.EbookSnapshot;
import com.springboot.wiki.service.EbookSnapshotService;
import com.springboot.wiki.mapper.EbookSnapshotMapper;
import org.springframework.stereotype.Service;

/**
* @author lenovo
* @description 针对表【ebook_snapshot】的数据库操作Service实现
* @createDate 2023-06-28 17:31:28
*/
@Service
public class EbookSnapshotServiceImpl extends ServiceImpl<EbookSnapshotMapper, EbookSnapshot>
    implements EbookSnapshotService{

}




