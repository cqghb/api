package com.test.api.api.utils;

import com.github.pagehelper.PageInfo;
import com.test.api.api.vo.page.PageRequest;
import com.test.api.api.vo.page.PageResult;

/**
 * @projectName api
 * @package com.test.api.api.utils
 * @className PageUtils
 * @description 分页工具
 * @auther wangsheng
 * @creatTime 2020/11/12 12:47 上午
 * @company
 * @department
 */
public class PageUtils {
    /**
     * 将分页信息封装到统一的接口
     * @param pageRequest
     * @param pageInfo
     * @return
     */
    public static PageResult getPageResult(PageRequest pageRequest, PageInfo<?> pageInfo) {
        PageResult pageResult = new PageResult();
        int pageNum = pageInfo.getPageNum();
        int pageSize = pageInfo.getPageSize();
        pageResult.setPageNum(pageNum < 1 ? 1 : pageNum);
        pageResult.setPageSize(pageSize < 1 ? 10 : pageSize);
        pageResult.setTotalSize(pageInfo.getTotal());
        pageResult.setTotalPages(pageInfo.getPages());
        pageResult.setContent(pageInfo.getList());
        return pageResult;
    }
}
