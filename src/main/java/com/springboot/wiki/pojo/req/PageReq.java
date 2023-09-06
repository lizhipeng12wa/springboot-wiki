package com.springboot.wiki.pojo.req;

import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

/**
 * @author li
 * @version 1.0
 * @ClassName PageReq
 * @date 2023/6/30 19:31
 * @since 1.0
 * 封装分页数据
 */
@Data
public class PageReq {
    @NotNull(message = "【页面】不能为空")
    private int page;//当前页数
    @NotNull(message = "【每页条数】不能为空")
    @Max(value = 1000,message = "【每页条数】不能超过1000")
    private int size;//每页条数
}
