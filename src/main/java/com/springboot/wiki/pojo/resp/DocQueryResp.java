package com.springboot.wiki.pojo.resp;

import lombok.Data;

/**
 * @author li
 * @version 1.0
 * @ClassName DocQueryResp
 * @date 2023/7/4 18:46
 * @since 1.0
 */
@Data
public class DocQueryResp {
    private Long id;
    private Long ebookId;//电子书id
    private Long parent;//父id
    private String name;//名称
    private Integer sort;//顺序
    private Integer viewCount;//阅读数
    private Integer voteCount;//点赞数

}