package com.test.api.api.vo.page;

import lombok.Data;

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
@Data
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

}
