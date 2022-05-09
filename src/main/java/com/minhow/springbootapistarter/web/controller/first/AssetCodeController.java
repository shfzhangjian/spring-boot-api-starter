package com.minhow.springbootapistarter.web.controller.first;


import com.alibaba.fastjson.JSON;
import com.minhow.springbootapistarter.common.response.Result;
import com.minhow.springbootapistarter.common.utils.IpUtils;
import com.minhow.springbootapistarter.common.utils.JWTUtil;
import com.minhow.springbootapistarter.pojo.dto.AssetClassCodeDTO;
import com.minhow.springbootapistarter.pojo.entity.first.AssetCodeLog;
import com.minhow.springbootapistarter.pojo.entity.first.User;
import com.minhow.springbootapistarter.service.first.AssetCodeLogService;
import com.minhow.springbootapistarter.service.first.AssetCodeService;
import com.minhow.springbootapistarter.service.first.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Date;
import java.util.Map;

/**
 * 资产分类
 * @author MinHow
 * @since 2019-10-05
 */
@RestController
@RequestMapping("/assetcode")
public class AssetCodeController {
    @Autowired
    private AssetCodeService assetCodeService;

    @Autowired
    private AssetCodeLogService assetCodeLogService;


    @Autowired
    private UserService userService;

    @Autowired
    private JWTUtil jwtUtil;


    @PostMapping("/get")
    public Result get(@Valid AssetClassCodeDTO param, HttpServletRequest request) {

        final String authHeader = request.getHeader("authorization");
        // 获取token
        final String token = authHeader.substring(7);

        AssetCodeLog log = new AssetCodeLog();
        Map map = jwtUtil.getJWTData(token);
        Integer id = (Integer) map.get("userId");

        User user = userService.getServerInfo(id);

        log.setScode(user.getScode());
        log.setSname(user.getSname());
        log.setDtime(new Date());

        String json =  JSON.toJSONString(param);
        log.setSreq(json);

        log.setSip(IpUtils.getIpAddr(request));

        Result result =  assetCodeService.get(param);


        String jsonResult = JSON.toJSONString(result);
        log.setSresult(jsonResult);

        assetCodeLogService.record(log);

        return result;
    }
}

