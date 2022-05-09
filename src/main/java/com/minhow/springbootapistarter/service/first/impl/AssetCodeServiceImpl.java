package com.minhow.springbootapistarter.service.first.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.minhow.springbootapistarter.common.response.Result;
import com.minhow.springbootapistarter.common.utils.JWTUtil;
import com.minhow.springbootapistarter.dao.first.mapper.AssetCodeMapper;
import com.minhow.springbootapistarter.pojo.dto.AssetClassCodeDTO;
import com.minhow.springbootapistarter.pojo.dto.AssetCodeResultDTO;
import com.minhow.springbootapistarter.pojo.entity.first.AssetClassCode;
import com.minhow.springbootapistarter.pojo.entity.first.User;
import com.minhow.springbootapistarter.service.first.AssetCodeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author MinHow
 * @since 2019-10-05
 */
@Service
public class AssetCodeServiceImpl extends ServiceImpl<AssetCodeMapper, AssetClassCode> implements AssetCodeService {
    @Autowired
    private JWTUtil jwtUtil;

    @Override
    public Result get(AssetClassCodeDTO assetCodeDto) {

        AssetClassCode assetClassCode = this.lambdaQuery()
                .select(AssetClassCode::getIndocno, AssetClassCode::getAssetclassno, AssetClassCode::getSline, AssetClassCode::getSname,AssetClassCode::getSversion, AssetClassCode::getImaxCode)
                .eq(AssetClassCode::getAssetclassno, assetCodeDto.getAssetclassno())
                .one();

        if (assetClassCode == null) {
            return Result.fail(4001, "没有找到资产分类！");
        }
        AssetCodeResultDTO dto = new AssetCodeResultDTO();
        BeanUtils.copyProperties(assetClassCode, dto);

        Long imaxcode = dto.getImaxCode();
        if (imaxcode == null) {
            imaxcode = 0L;
        }
        imaxcode = imaxcode +1;

        dto.setNewcode(dto.getAssetclassno()+"-"+assetCodeDto.getDeptno()+"-"+(imaxcode).toString());

        dto.setImaxCode(imaxcode);
        assetClassCode.setImaxCode(imaxcode);
        LambdaUpdateWrapper<AssetClassCode> lambdaUpdate = Wrappers.<AssetClassCode>lambdaUpdate();
        lambdaUpdate.eq(AssetClassCode::getIndocno, dto.getIndocno()).set(AssetClassCode::getImaxCode, imaxcode);
        this.updateById(assetClassCode);

        return Result.ok(dto);
    }
}
