package com.test.api.api.action;

import com.test.api.api.bo.CodeValueBO;
import com.test.api.api.config.Result;
import com.test.api.api.service.ITblCodeValueService;
import com.test.api.api.utils.ResultUtil;
import com.test.api.api.vo.page.PageRequest;
import com.test.api.api.vo.page.PageResult;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @projectName api
 * @package com.test.api.api.action
 * @className CodeValueAction
 * @description 码值控制器
 * @auther wangsheng
 * @creatTime 2021/5/10 12:34 上午
 * @company
 * @department 
 */
@RestController
@RequestMapping("/codeValue")
public class CodeValueAction {

    protected static Logger logger = LoggerFactory.getLogger(CodeValueAction.class);

    @Autowired
    private ITblCodeValueService iTblCodeValueService;

    /**
     * 码值查询
     * @param codeValueBO 码值类型
     * @return
     */
    @PostMapping(value="/searchCodeKeyValue")
    public Result searchCodeKeyValue(@RequestBody CodeValueBO codeValueBO) {
        logger.info("[码值查询] action start: codeType=" + codeValueBO.getCodeType());
        List<Map<String, String>> codeKeyValueList = iTblCodeValueService.searchCodeKeyValue(codeValueBO);
        logger.info("[码值查询] action end");

        return ResultUtil.success(codeKeyValueList);
    }

    /**
     * 数据操作分组数据分页查询
     * @param pageQuery
     * @return
     */
    @ApiOperation(value = "数据操作列表查询", notes = "数据操作列表查询")
    @PostMapping(value = "/findPageChildren")
    public Result findPageChildren(@RequestBody PageRequest pageQuery) {
        PageResult pageResult = iTblCodeValueService.findPageChildren(pageQuery);
        return ResultUtil.success(pageResult);
    }
}
