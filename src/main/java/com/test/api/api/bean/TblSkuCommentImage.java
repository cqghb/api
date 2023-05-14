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
 * 商品评论影像信息表
 * </p>
 *
 * @author wsheng
 * @since 2023-05-14
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("tbl_sku_comment_image")
@ApiModel(value = "TblSkuCommentImage对象", description = "商品评论影像信息表")
public class TblSkuCommentImage implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("商品评论影像信息主键")
    @TableId(value = "id", type = IdType.INPUT)
    private String id;

    @ApiModelProperty("文件名")
    @TableField("name")
    private String name;

    @ApiModelProperty("文件路径")
    @TableField("path")
    private String path;

    @ApiModelProperty("评论组件")
    @TableField("sku_comment_id")
    private String skuCommentId;

    @ApiModelProperty("序号")
    @TableField("index")
    private Integer index;

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
