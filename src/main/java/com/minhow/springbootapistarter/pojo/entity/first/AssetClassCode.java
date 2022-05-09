package com.minhow.springbootapistarter.pojo.entity.first;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author MinHow
 * @since 2019-10-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("CM_ARCD_GDZCFLML")
public class AssetClassCode implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "indocno", type = IdType.AUTO)
    @TableField(value = "indocno" )
    private Long indocno;

    @TableField(value = "scode")
    private String assetclassno;

    @TableField(value = "sname")
    private String sname;

    @TableField(value = "sline")
    private String sline;

    @TableField(value = "IMAX_CODE")
    private Long imaxCode;

    @TableField(value = "SVERSION")
    private String sversion;

}


