package com.minhow.springbootapistarter.service.first.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.minhow.springbootapistarter.common.response.Result;
import com.minhow.springbootapistarter.common.utils.JWTUtil;
import com.minhow.springbootapistarter.dao.first.mapper.AssetCodeLogMapper;
import com.minhow.springbootapistarter.pojo.entity.first.AssetCodeLog;
import com.minhow.springbootapistarter.service.first.AssetCodeLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author MinHow
 * @since 2019-10-05
 */
@Service
public class AssetCodeLogServiceImpl extends ServiceImpl<AssetCodeLogMapper, AssetCodeLog> implements AssetCodeLogService {
    @Autowired
    private JWTUtil jwtUtil;

    @Override
    public void record(AssetCodeLog assetCodeLog) {
        assetCodeLog.setIndocno(null);
        this.save(assetCodeLog);
    }
}
