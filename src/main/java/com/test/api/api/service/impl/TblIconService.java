package com.test.api.api.service.impl;

import com.test.api.api.bean.TblIcon;
import com.test.api.api.constant.CommConstant;
import com.test.api.api.constant.TableColumnEnum.DelTagEnum;
import com.test.api.api.dao.TblIconDao;
import com.test.api.api.dto.iconmanager.TblIconAddDto;
import com.test.api.api.dto.iconmanager.TblIconUpdateDto;
import com.test.api.api.service.ICommonService;
import com.test.api.api.service.ITblIconService;
import com.test.api.api.utils.PageUtils;
import com.test.api.api.utils.StringUtil;
import com.test.api.api.vo.page.PageRequest;
import com.test.api.api.vo.page.PageResult;
import org.springframework.beans.BeanUtils;
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
public class TblIconService implements ITblIconService {

    @Autowired
    private TblIconDao tblIconDao;
    @Autowired
    private ICommonService iCommonService;

    @Override
    public int deleteByPrimaryKey(String id) {
        return tblIconDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(TblIcon record) {
        return tblIconDao.insert(record);
    }

    @Override
    public int insertSelective(TblIconAddDto record) {
        TblIcon tblIcon = new TblIcon();
        BeanUtils.copyProperties(record, tblIcon);
        tblIcon.setId(StringUtil.uuid());
        iCommonService.setObjectInsertInfo(tblIcon, null);
        return tblIconDao.insertSelective(tblIcon);
    }

    @Override
    public TblIcon selectByPrimaryKey(String id) {
        return tblIconDao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(TblIconUpdateDto record) {
        TblIcon icon = iCommonService.getInfo(tblIconDao, CommConstant.SELECT_BY_PRIMARY_KEY, record.getId());
        BeanUtils.copyProperties(record, icon);
        iCommonService.setObjectUpdateInfo(icon, null);
        return tblIconDao.updateByPrimaryKeySelective(icon);
    }

    @Override
    public int updateByPrimaryKey(TblIcon record) {
        return tblIconDao.updateByPrimaryKey(record);
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return PageUtils.getPageResult(iCommonService.getPageInfo(tblIconDao, CommConstant.QUERY_LIST, pageRequest));
    }

    @Override
    public List<TblIcon> queryAll() {
        return tblIconDao.queryList(null);
    }

    @Override
    public int updateDelTag(String id) {
        TblIcon icon = this.selectByPrimaryKey(id);
        icon.setDelTag(DelTagEnum.DEL_TAG_1.getCode());
        iCommonService.setObjectUpdateInfo(icon, null);
        return tblIconDao.updateDelTag(icon);
    }
}
