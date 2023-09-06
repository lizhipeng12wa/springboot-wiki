package com.springboot.wiki.pojo.req;

import lombok.Data;

/**
 * @author li
 * @version 1.0
 * @ClassName ContentQueryReq
 * @date 2023/7/4 19:56
 * @since 1.0
 */
@Data
public class ContentQueryReq{
    private Long id;
    private String content;
    //内容
}
