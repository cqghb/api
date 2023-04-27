package com.test.api.api.vo;

import com.test.api.api.bean.TblDataOperate;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @projectName api
 * @package com.test.api.api.vo
 * @className CodeValueVO
 * @description 菜单数据操作权限数据显示对象
 * @auther wangsheng
 * @creatTime 2021/10/16 10:08 下午
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
@Data
public class CodeValueVO extends TblDataOperate implements Serializable {

    private List childrenList;
}
