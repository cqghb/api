package com.test.api.api.service.impl;

import com.test.api.api.bean.TblUser;
import com.test.api.api.dao.TblUserDao;
import com.test.api.api.service.ICommonService;
import com.test.api.api.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @projectName api
 * @package com.test.api.api.service.impl
 * @className CommonService
 * @description TODO
 * @auther wangsheng
 * @creatTime 2021/5/15 12:42 上午
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
@Service
public class CommonService implements ICommonService {

    protected static Logger logger = LoggerFactory.getLogger(CommonService.class);

    @Autowired
    private TblUserDao userDao;


    @Override
    public String getUserId() {
        String userId = StringUtil.getRandom();
        boolean r = true;
        // 记录用了几次才生成出了可用的字符串
        int num = 0;
        // 直到生成一个没有被使用的userNo就不再循环,
        // TODO 当字符用完之后将陷入死循环
        while (r){
            TblUser user = userDao.selectByPrimaryKey(userId);
            if(StringUtils.isEmpty(user)){
                r = false;
            } else {
                userId = StringUtil.getRandom();
            }
            num ++;
        }
        logger.info("共循环了 " + num + " 次后生成了可用的userNo");
        logger.info("生成的userNo: " + userId);
        return userId;
    }
}
