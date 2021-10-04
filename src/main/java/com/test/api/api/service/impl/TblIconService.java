package com.test.api.api.service.impl;

import com.test.api.api.bean.TblIcon;
import com.test.api.api.bean.TblUser;
import com.test.api.api.constant.CommConstant;
import com.test.api.api.dao.TblIconDao;
import com.test.api.api.service.ITblIconService;
import com.test.api.api.utils.PageUtils;
import com.test.api.api.utils.StringUtil;
import com.test.api.api.vo.page.PageRequest;
import com.test.api.api.vo.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @projectName api
 * @package com.test.api.api.service.impl
 * @className TblIconService
 * @description 图标管理服务实现类
 * @auther wangsheng
 * @creatTime 2021/9/8 1:02 上午
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
@Service
public class TblIconService extends CommonService implements ITblIconService {

    @Autowired
    private TblIconDao tblIconDao;

    @Override
    public int deleteByPrimaryKey(String id) {
        return tblIconDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(TblIcon record) {
        return tblIconDao.insert(record);
    }

    @Override
    public int insertSelective(TblIcon record) {
        TblUser loginUser = getLoginUser();
        String loginUserId = loginUser.getId();
        record.setId(StringUtil.uuid());
        record.setCreateUser(loginUserId);
        return tblIconDao.insertSelective(record);
    }

    @Override
    public TblIcon selectByPrimaryKey(String id) {
        return tblIconDao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(TblIcon record) {
        return tblIconDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TblIcon record) {
        return tblIconDao.updateByPrimaryKey(record);
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return PageUtils.getPageResult(getPageInfo(tblIconDao, CommConstant.QUERY_LIST, pageRequest));
    }

    @Override
    public List<TblIcon> queryAll() {
        return tblIconDao.queryList(null);
    }
}
