package com.springboot.wiki.pojo.req;

import lombok.Data;

/**
 * @author li
 * @version 1.0
 * @ClassName CategorySaveReq
 * @date 2023/7/3 9:54
 * @since 1.0
 */
@Data
public class CategorySaveReq {
    private Long id;
    private Long parent;
    private String name;
    private Integer sort;
}
