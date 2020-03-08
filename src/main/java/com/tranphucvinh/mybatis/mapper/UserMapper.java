package com.tranphucvinh.mybatis.mapper;

import java.util.Map;

import com.tranphucvinh.mybatis.entity.User;

public interface UserMapper {

	public User selectUsers(Map<String,Object> param);
}
