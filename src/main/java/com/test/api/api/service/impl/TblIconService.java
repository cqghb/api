package com.test.api.api.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.test.api.api.bean.TblIcon;
import com.test.api.api.dao.TblIconDao;
import com.test.api.api.service.ITblIconService;
import com.test.api.api.utils.PageUtils;
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
public class TblIconService implements ITblIconService {

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
        return PageUtils.getPageResult(getPageInfo(pageRequest));
    }

    /**
     * 调用分页插件完成分页
     * @param pageRequest
     * @return
     */
    private PageInfo<TblIcon> getPageInfo(PageRequest pageRequest) {
        int currentPage = pageRequest.getCurrentPage();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(currentPage, pageSize);
        JSONObject jsonObject = (JSONObject) JSON.toJSON(pageRequest.getParams());
        TblIcon params = jsonObject.toJavaObject(TblIcon.class);
        List<TblIcon> iconList = tblIconDao.queryList(params);
        return new PageInfo<>(iconList);
    }
}
