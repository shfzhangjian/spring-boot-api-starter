package com.minhow.springbootapistarter.pojo.entity.first;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

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
@TableName("CM_ARCD_GDZCFLML_API")
public class User implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "indocno", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户名
     */
    @TableId(value = "scode")
    private String name;

    /**
     * 密码
     */
    @TableId(value = "ssecret")
    private String password;

    /**
     * 客户数
     */
    @TableId(value = "istate")
    private Integer customerNum;


}


