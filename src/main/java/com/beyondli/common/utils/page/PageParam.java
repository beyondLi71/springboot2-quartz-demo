package com.beyondli.common.utils.page;

/**
 * @author beyondLi
 * @desc  分页请求参数封装.
 */
public class PageParam {

    public static final int PAGE_SIZE = 10;

    public PageParam() {
        this.c = PAGE_SIZE;
    }

    public PageParam(Integer p, Integer c) {
        this.setP(p);
        this.setC(c);
    }

    //当前页
    private Integer p = 1;

    //每页容量
    private Integer c;

    public Integer getP() {
        return p;
    }

    public void setP(Integer p) {
        if (p != null && p > 0) {
            this.p = p;
        }
    }

    public Integer getC() {
        return c;
    }

    public void setC(Integer c) {
        if (c != null) {
            this.c = c;
        }
    }
}
