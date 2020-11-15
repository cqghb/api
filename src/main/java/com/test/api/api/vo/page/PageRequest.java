package com.test.api.api.vo.page;

import com.alibaba.fastjson.JSONObject;

/**
 * @projectName api
 * @package com.test.api.api.vo.page
 * @className PageRequest
 * @description 分页请求
 * @auther wangsheng
 * @creatTime 2020/11/12 12:45 上午
 * @company
 * @department
 */
public class PageRequest<T> {
    /**
     * 当前页码
     */
    private int currentPage;
    /**
     * 每页数量
     */
    private int pageSize;

    private T params;

    public PageRequest() {
    }

    public PageRequest(int currentPage, int pageSize, T params) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.params = params;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public T getParams() {
        return params;
    }

    public void setParams(T params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "PageRequest{" + JSONObject.toJSONString(this) +
                '}';
    }
}
