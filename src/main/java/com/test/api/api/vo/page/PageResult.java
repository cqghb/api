package com.test.api.api.vo.page;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * @projectName api
 * @package com.test.api.api.vo.page
 * @className PageResult
 * @description 分页返回结果
 * @auther wangsheng
 * @creatTime 2020/11/12 12:43 上午
 * @company
 * @department
 */
public class PageResult {
    /**
     * 当前页码
     */
    private int currentPage;
    /**
     * 每页数量
     */
    private int pageSize;
    /**
     * 记录总数
     */
    private long totalSize;
    /**
     * 页码总数
     */
    private int totalPages;
    /**
     * 数据模型
     */
    private List<?> content;

    public PageResult() {
    }

    public PageResult(int currentPage, int pageSize, long totalSize, int totalPages, List<?> content) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalSize = totalSize;
        this.totalPages = totalPages;
        this.content = content;
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

    public long getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(long totalSize) {
        this.totalSize = totalSize;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List<?> getContent() {
        return content;
    }

    public void setContent(List<?> content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "PageResult{" + JSONObject.toJSONString(this) +'}';
    }
}
