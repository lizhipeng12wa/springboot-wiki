package com.springboot.wiki.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springboot.wiki.pojo.User;
import com.springboot.wiki.service.UserService;
import com.springboot.wiki.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author lenovo
* @description 针对表【user】的数据库操作Service实现
* @createDate 2023-06-28 17:31:28
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




