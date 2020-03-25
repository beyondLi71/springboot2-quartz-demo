package com.beyondli.common.utils.page;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author beyondLi
 * @param <T> 实体类型
 * @desc  分页容器.
 */
@Getter @Setter
public class PageResult<T> {

    private PageResult() { }
    //当前页
    private Integer page;
    //总数量
    private long count;
    //分页数据
    private List<T> list;

    public PageResult(int page, long count, List<T> list) {
        this.page = page;
        this.count = count;
        this.list = list;
    }

}
