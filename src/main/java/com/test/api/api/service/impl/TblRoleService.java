package com.test.api.api.service.impl;

import com.test.api.api.bean.TblRole;
import com.test.api.api.bean.TblUser;
import com.test.api.api.config.AppException;
import com.test.api.api.constant.CommConstant;
import com.test.api.api.constant.TableColumnEnum.DelTagEnum;
import com.test.api.api.dao.TblRoleDao;
import com.test.api.api.service.ITblRoleService;
import com.test.api.api.utils.PageUtils;
import com.test.api.api.utils.StringUtil;
import com.test.api.api.vo.page.PageRequest;
import com.test.api.api.vo.page.PageResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @projectName api
 * @package com.test.api.api.service.impl
 * @className TblRoleService
 * @description 角色服务实现类
 * @auther wangsheng
 * @creatTime 2021/9/29 2:07 上午
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
@Service
public class TblRoleService extends CommonService implements ITblRoleService {

    protected static Logger logger = LoggerFactory.getLogger(TblRoleService.class);

    @Autowired
    private TblRoleDao roleDao;

    @Override
    public int deleteByPrimaryKey(String id) {
        return roleDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(TblRole record) {
        return roleDao.insert(record);
    }

    @Override
    public int insertSelective(TblRole record) {
        TblUser loginUser = getLoginUser();
        String loginUserId = loginUser.getId();
        record.setId(StringUtil.uuid());
        record.setCreateUser(loginUserId);
        return roleDao.insertSelective(record);
    }

    @Override
    public TblRole selectByPrimaryKey(String id) {
        return roleDao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(TblRole record) throws AppException {
        TblRole oldRole = getInfo(roleDao, CommConstant.SELECT_BY_PRIMARY_KEY, record.getId());
        BeanUtils.copyProperties(record, oldRole);
        setObjectUpdateInfo(oldRole, null);
        return roleDao.updateByPrimaryKeySelective(oldRole);
    }

    @Override
    public int updateByPrimaryKey(TblRole record) {
        return roleDao.updateByPrimaryKey(record);
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return PageUtils.getPageResult(getPageInfo(roleDao, CommConstant.QUERY_LIST, pageRequest));
    }

    @Override
    public int updateRoleDelTag(TblRole record) {
        TblRole tab = getInfo(roleDao, CommConstant.SELECT_BY_PRIMARY_KEY, record.getId());
        record.setDelTag(DelTagEnum.DEL_TAG_1.getCode());
        setObjectUpdateInfo(record, null);
        return roleDao.updateRoleDelTag(record);
    }

//    /**
//     * 设置对象的修改信息
//     * @param record
//     * @return
//     */
//    private TblRole setUpdateInfo(TblRole record){
//        TblUser loginUser = getLoginUser();
//        String loginUserId = loginUser.getId();
//        record.setUpdateUser(loginUserId);
//        return record;
//    }
}
