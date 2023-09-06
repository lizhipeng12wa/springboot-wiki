package com.springboot.wiki.pojo.resp;

import lombok.Data;

/**
 * @author li
 * @version 1.0
 * @ClassName ContentQueryResp
 * @date 2023/7/4 19:57
 * @since 1.0
 */
@Data
public class ContentQueryResp {
    private Integer id;
    private String content;//内容
}
