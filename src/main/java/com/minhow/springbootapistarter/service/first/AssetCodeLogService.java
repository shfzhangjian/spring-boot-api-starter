package com.minhow.springbootapistarter.service.first;

import com.baomidou.mybatisplus.extension.service.IService;
import com.minhow.springbootapistarter.common.response.Result;
import com.minhow.springbootapistarter.pojo.entity.first.AssetCodeLog;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author MinHow
 * @since 2019-10-05
 */
public interface AssetCodeLogService extends IService<AssetCodeLog> {

    void record(AssetCodeLog assetCodeLog);
}
