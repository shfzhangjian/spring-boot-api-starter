package com.minhow.springbootapistarter.pojo.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author MinHow
 * @date 2019/10/6 10:49 上午
 */
@Data
public class AssetClassCodeDTO {
    @NotBlank(message = "线路编码不能空")
    private String sline;

    @NotBlank(message = "资产分类不能空")
    private String assetclassno;


    @NotBlank(message = "归属单位编码")
    private String deptno;

}
