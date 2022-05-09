package com.minhow.springbootapistarter.service.first;

import com.baomidou.mybatisplus.extension.service.IService;
import com.minhow.springbootapistarter.common.response.Result;
import com.minhow.springbootapistarter.pojo.dto.AssetClassCodeDTO;
import com.minhow.springbootapistarter.pojo.entity.first.AssetClassCode;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author MinHow
 * @since 2019-10-05
 */
public interface AssetCodeService extends IService<AssetClassCode> {

    Result get(AssetClassCodeDTO assetCodeDto);
}
