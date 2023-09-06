package com.springboot.wiki.pojo.req;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author li
 * @version 1.0
 * @ClassName ContentSaveReq
 * @date 2023/7/4 19:57
 * @since 1.0
 */
@Data
public class ContentSaveReq {
    private Long id;
    @NotNull(message = "【内容】不能为空")
    private String content;
}
