package com.test.api.api.service;

import org.apache.ibatis.annotations.Param;

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
     * @param codeType 键类型
     * @return
     */
    List<Map<String, String>> searchCodeKeyValue(String codeType);


}
