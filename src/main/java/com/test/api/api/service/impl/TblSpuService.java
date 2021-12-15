package com.test.api.api.service.impl;

import com.test.api.api.bean.TblSpu;
import com.test.api.api.constant.CommConstant;
import com.test.api.api.constant.TableColumnEnum.DelTagEnum;
import com.test.api.api.dao.TblSpuDao;
import com.test.api.api.service.ITblSpuService;
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
 * @className TblSpuService
 * @description 货品服务实现类
 * @auther wangsheng
 * @creatTime 2021/12/15 下午11:29
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
@Service
public class TblSpuService extends CommonService implements ITblSpuService {

    protected static final Logger logger = LoggerFactory.getLogger(TblSpuService.class);

    @Autowired
    private TblSpuDao spuDao;

    @Override
    public int deleteByPrimaryKey(String id) {
        return 0;
    }

    @Override
    public int insert(TblSpu record) {
        record.setId(StringUtil.uuid());
        setObjectInsertInfo(record, null);
        return spuDao.insert(record);
    }

    @Override
    public int insertSelective(TblSpu record) {
        record.setId(StringUtil.uuid());
        setObjectInsertInfo(record, null);
        return spuDao.insertSelective(record);
    }

    @Override
    public TblSpu selectByPrimaryKey(String id) {
        return spuDao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(TblSpu record) {
        TblSpu spu = getInfo(spuDao, CommConstant.SELECT_BY_PRIMARY_KEY, record.getId());
        BeanUtils.copyProperties(record, spu);
        setObjectUpdateInfo(spu, null);
        return spuDao.updateByPrimaryKeySelective(spu);
    }

    @Override
    public int updateByPrimaryKey(TblSpu record) {
        TblSpu spu = getInfo(spuDao, CommConstant.SELECT_BY_PRIMARY_KEY, record.getId());
        BeanUtils.copyProperties(record, spu);
        setObjectUpdateInfo(spu, null);
        return spuDao.updateByPrimaryKey(spu);
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return PageUtils.getPageResult(getPageInfo(spuDao, CommConstant.QUERY_LIST, pageRequest));
    }

    @Override
    public int updateDelTag(TblSpu record) {
        getInfo(spuDao, CommConstant.SELECT_BY_PRIMARY_KEY, record.getId());
        record.setDelTag(DelTagEnum.DEL_TAG_1.getCode());
        setObjectUpdateInfo(record, null);
        return spuDao.updateDelTag(record);
    }
}
