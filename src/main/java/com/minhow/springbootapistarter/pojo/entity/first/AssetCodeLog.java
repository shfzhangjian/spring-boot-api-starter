package com.minhow.springbootapistarter.pojo.entity.first;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Generated;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Date;

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
@TableName("CM_ARCD_GDZCFLML_API_LOG")
@KeySequence(value="SEQ_API_LOG",clazz = String.class) //value为数据库中生成的序列名，class指主键属性类型
public class AssetCodeLog implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value="INDOCNO", type=IdType.ID_WORKER)  //注意主键类型要指定为Input
    @TableField(value = "INDOCNO")
    private Long indocno;

    @TableField(value = "SNAME")
    private String sname;

    @TableField(value = "SCODE")
    private String scode;

    @TableField(value = "SREQ")
    private String sreq;

    @TableField(value = "SRESULT")
    private String sresult;

    @TableField(value = "DTIME")
    private Date dtime;

    @TableField(value = "SIP")
    private String sip;

}


