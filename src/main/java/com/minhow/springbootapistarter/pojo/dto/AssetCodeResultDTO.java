package com.minhow.springbootapistarter.pojo.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author MinHow
 * @date 2019/10/6 10:49 上午
 */
@Data
public class AssetCodeResultDTO {
    private Integer indocno;

    private String sline;

    private String assetclassno;

    private String deptno;

    private String newcode;

    private String sname;

    private Long imaxCode;

    private String sversion;

}
