package com.example.mybatisspringboot.service.impl;

import com.example.mybatisspringboot.pojo.User;
import com.example.mybatisspringboot.mapper.UserMapper;
import com.example.mybatisspringboot.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author limx
 * @since 2019-11-09
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
