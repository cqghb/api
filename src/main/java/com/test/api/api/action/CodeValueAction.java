package com.test.api.api.action;

import com.test.api.api.config.Result;
import com.test.api.api.service.ITblCodeValueService;
import com.test.api.api.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @projectName api
 * @package com.test.api.api.action
 * @className CodeValueAction
 * @description 码值控制器
 * @auther wangsheng
 * @creatTime 2021/5/10 12:34 上午
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
@RestController
public class CodeValueAction {

    protected static Logger logger = LoggerFactory.getLogger(CodeValueAction.class);

    @Autowired
    private ITblCodeValueService iTblCodeValueService;

    /**
     * 码值查询
     * @param codeType 码值类型
     * @return
     */
    @GetMapping(value="/searchCodeKeyValue")
    public Result searchCodeKeyValue(@RequestParam(name = "codeType") String codeType) {
        logger.info("[码值查询] action start: codeType=" + codeType);
        List<Map<String, String>> codeKeyValueList = iTblCodeValueService.searchCodeKeyValue(codeType);
        logger.info("[码值查询] action end");
        return ResultUtil.success(codeKeyValueList);
    }
}
