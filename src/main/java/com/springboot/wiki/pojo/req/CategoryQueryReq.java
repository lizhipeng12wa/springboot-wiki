package com.springboot.wiki.pojo.req;

import lombok.Data;

/**
 * @author li
 * @version 1.0
 * @ClassName CategoryQueryReq
 * @date 2023/7/3 9:53
 * @since 1.0
 */
@Data
public class CategoryQueryReq extends PageReq{
    private Long id;
    private Long parent;
    private String name;
    private Integer sort;
}
