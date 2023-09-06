package com.springboot.wiki.pojo.resp;

import com.springboot.wiki.pojo.req.PageReq;
import lombok.Data;

/**
 * @author li
 * @version 1.0
 * @ClassName CategoryQueryResp
 * @date 2023/7/3 9:55
 * @since 1.0
 */
@Data
public class CategoryQueryResp{
    private Long id;
    private Long parent;
    private String name;
    private Integer sort;
}
