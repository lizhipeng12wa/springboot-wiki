package com.springboot.wiki.pojo.resp;

import lombok.Data;

/**
 * @author li
 * @version 1.0
 * @ClassName EbookResp
 * @date 2023/6/29 9:17
 * @since 1.0
 *
 * 用于封装Ebook表查询结果的封装类
 */
@Data
public class EbookQueryResp {
    private Long id;
    private String name;
    private Long category1Id;
    private Long category2Id;
    private String description;
    private String cover;
    private Integer docCount;
    private Integer viewCount;
    private Integer voteCount;
}
