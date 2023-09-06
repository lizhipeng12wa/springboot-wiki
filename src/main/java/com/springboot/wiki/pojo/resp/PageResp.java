package com.springboot.wiki.pojo.resp;

import lombok.Data;

import java.util.List;

/**
 * @author li
 * @version 1.0
 * @ClassName PageResp
 * @date 2023/7/1 9:26
 * @since 1.0
 */
@Data
public class PageResp<T> {
    private Long total;//总条数
    private List<T> list;//每页数据内容
}
