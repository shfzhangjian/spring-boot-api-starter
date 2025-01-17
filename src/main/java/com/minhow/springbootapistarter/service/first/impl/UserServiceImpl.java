package com.minhow.springbootapistarter.service.first.impl;

import com.minhow.springbootapistarter.common.response.Result;
import com.minhow.springbootapistarter.common.utils.JWTUtil;
import com.minhow.springbootapistarter.pojo.dto.LoginDTO;
import com.minhow.springbootapistarter.pojo.entity.first.User;
import com.minhow.springbootapistarter.dao.first.mapper.UserMapper;
import com.minhow.springbootapistarter.pojo.vo.TokenInfoVO;
import com.minhow.springbootapistarter.pojo.vo.UserInfoVO;
import com.minhow.springbootapistarter.service.first.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private JWTUtil jwtUtil;
    @Override
    public Result login(LoginDTO loginDTO) {

        User user = this.lambdaQuery()
                .select(User::getId, User::getScode,User::getSname, User::getSsecret)
                .eq(User::getScode, loginDTO.getName())
                .one();

        if (user == null) {
            return Result.fail(4001, "服务器不存在！");
        }
        if (user.getSsecret().equals(loginDTO.getPassword())==false) {
            return Result.fail(4001, "密码错误！！");
        }
        //省略业务逻辑...

        Map<String, Object> tokenData = new HashMap<>(2);
        tokenData.put("userId", user.getId());
        String token = jwtUtil.createJWT(tokenData);

        TokenInfoVO tokenInfoVO = new TokenInfoVO();
        tokenInfoVO.setToken(token);

        return Result.ok(tokenInfoVO);
    }

    @Override
    public User getServerInfo(Integer id) {
        User user = this.getById(id);
        return user;
    }
}
