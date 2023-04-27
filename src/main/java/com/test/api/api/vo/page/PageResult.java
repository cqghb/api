package com.test.api.api.vo.page;

import lombok.Data;

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
@Data
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
}
