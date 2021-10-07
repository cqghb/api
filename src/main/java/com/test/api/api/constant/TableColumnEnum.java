package com.test.api.api.constant;

import com.test.api.api.utils.StringUtil;

/**
 * @projectName api
 * @package com.test.api.api.constant
 * @className TableColumnEnum
 * @description 数据库表字段值枚举
 * @auther wangsheng
 * @creatTime 2021/10/5 3:38 下午
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
public class TableColumnEnum {
    /** 公共字段枚举 start **/
    /**
     * 删除标志枚举
     */
    public enum DelTagEnum {
        DEL_TAG_1(TableColumnConstant.DEL_TAG_CODE_1, TableColumnConstant.DEL_TAG_DESC_1),
        DEL_TAG_2(TableColumnConstant.DEL_TAG_CODE_2, TableColumnConstant.DEL_TAG_DESC_2);

        // 码
        private String code;
        // 说明
        private String desc;

        DelTagEnum() {
        }

        DelTagEnum(String code, String desc) {
            this.code = code;
            this.desc = desc;
        }

        public static DelTagEnum getEnum(String code) {
            if (StringUtil.objIsEmpty(code)) {
                return null;
            }
            for (DelTagEnum item : DelTagEnum.values()) {
                if (item.getCode().equals(code)) {
                    return item;
                }
            }
            return null;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
    }
    /** 公共字段枚举 start **/

}
