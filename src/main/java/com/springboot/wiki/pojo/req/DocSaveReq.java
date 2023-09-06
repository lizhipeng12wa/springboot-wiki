package com.springboot.wiki.pojo.req;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author li
 * @version 1.0
 * @ClassName DocSaveReq
 * @date 2023/7/4 18:46
 * @since 1.0
 */
@Data
public class DocSaveReq {

    /**
     * 电子书id
     * 父id
     * 名称
     * 顺序
     * 阅读数
     * 点赞数
     */

    private Long id;
    @NotNull(message = "【电子书】不能为空")
    private Long ebookId;
    @NotNull(message = "【名称】不能为空")
    private String name;
    @NotNull(message = "【父文档】不能为空")
    private Long parent;
    @NotNull(message = "【排序】不能为空")
    private Integer sort;
    private Integer viewCount;
    private Integer voteCount;
    @NotNull(message = "【内容】不能为空")
    private String content;

}
