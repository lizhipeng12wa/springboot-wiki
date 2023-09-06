package com.springboot.wiki.pojo.req;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author li
 * @version 1.0
 * @ClassName EbookReq
 * @date 2023/6/29 9:16
 * @since 1.0
 *
 * 用于封装对Ebook表请求信息的封装类
 */
@Data
public class EbookSaveReq  {
    private Long id;
    @NotNull(message = "【名称】不能为空")
    private String name;
    private Long category1Id;
    private Long category2Id;
    private String description;
    private String cover;
    private Integer docCount;
    private Integer viewCount;
    private Integer voteCount;
}
