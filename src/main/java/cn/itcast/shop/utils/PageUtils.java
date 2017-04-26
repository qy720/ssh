package cn.itcast.shop.utils;

import java.util.List;

/**
 * Created by Administrator on 2017/4/26.
 */
public class PageUtils<T> {
    private Integer page;//当前页
    private Integer totalCount;//总记录数
    private Integer totalPage;//总页数
    private Integer limit;//每页条数
    private List<T> list;//每页显示数据的集合

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
