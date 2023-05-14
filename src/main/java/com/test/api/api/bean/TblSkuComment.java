package com.test.api.api.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 商品评论表
 * </p>
 *
 * @author wsheng
 * @since 2023-05-14
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("tbl_sku_comment")
@ApiModel(value = "TblSkuComment对象", description = "商品评论表")
public class TblSkuComment implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("评论ID")
    @TableId(value = "id", type = IdType.INPUT)
    private String id;

    @ApiModelProperty("商品编号")
    @TableField("sku_no")
    private String skuNo;

    @ApiModelProperty("评论内容")
    @TableField("content")
    private String content;

    @ApiModelProperty("上一级评论主键，")
    @TableField("parent_id")
    private String parentId;

    @ApiModelProperty("创建人")
    @TableField("create_user")
    private String createUser;

    @ApiModelProperty("创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty("修改人")
    @TableField("update_user")
    private String updateUser;

    @ApiModelProperty("修改时间")
    @TableField("update_time")
    private LocalDateTime updateTime;

    @ApiModelProperty("删除标志[1: 删除; 2: 保留]")
    @TableField("del_tag")
    @TableLogic
    private String delTag;

    @ApiModelProperty("备注")
    @TableField("remark")
    private String remark;
}
