package com.test.api.api.service.impl;

import com.test.api.api.config.AppException;
import com.test.api.api.constant.ErrorMsgConstant;
import com.test.api.api.constant.MsgCodeConstant;
import com.test.api.api.dao.TblCodeValueDao;
import com.test.api.api.service.ITblCodeValueService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * @projectName api
 * @package com.test.api.api.service.impl
 * @className TblCodeValueService
 * @description 码值服务实现类
 * @auther wangsheng
 * @creatTime 2021/5/10 12:30 上午
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
@Service
public class TblCodeValueService implements ITblCodeValueService {

    protected static Logger logger = LoggerFactory.getLogger(TblCodeValueService.class);

    @Autowired
    private TblCodeValueDao tblCodeValueDao;

    @Override
    public List<Map<String, String>> searchCodeKeyValue(String codeType) {
        if(StringUtils.isEmpty(codeType)){
            logger.error(ErrorMsgConstant.CODE_TYPE_NOT_NULL);
            throw new AppException(MsgCodeConstant.ERROR_CODE, ErrorMsgConstant.CODE_TYPE_NOT_NULL);
        }
        return tblCodeValueDao.searchCodeKeyValue(codeType);
    }
}
