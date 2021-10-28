package com.test.api.api.service;

import com.test.api.api.bo.CodeValueBO;
import com.test.api.api.vo.CodeValueVO;
import com.test.api.api.vo.page.PageRequest;
import com.test.api.api.vo.page.PageResult;

import java.util.List;
import java.util.Map;

/**
 * @projectName api
 * @package com.test.api.api.service
 * @className ITblCodeValueService
 * @description 码值服务接口
 * @auther wangsheng
 * @creatTime 2021/5/10 12:30 上午
 * @company
 * @department 
 */
public interface ITblCodeValueService {

    /**
     * 键值对查询
     * @param codeValueBO 键类型
     * @return
     */
    List<Map<String, String>> searchCodeKeyValue(CodeValueBO codeValueBO);

    /**
     * 数据操作分组数据分页查询
     * @param pageQuery
     * @return
     */
    PageResult findPageChildren(PageRequest pageQuery);

    List<CodeValueVO> findPageChildren();
}
