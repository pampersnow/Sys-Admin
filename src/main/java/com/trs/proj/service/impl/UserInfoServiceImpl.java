package com.trs.proj.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.trs.proj.domain.Permission;
import com.trs.proj.domain.Role;
import com.trs.proj.domain.UserInfo;
import com.trs.proj.mapper.UserInfoMapper;
import com.trs.proj.service.UserInfoService;

@Service(value = "userInfoService")
public class UserInfoServiceImpl implements UserInfoService {

	@Resource
	private UserInfoMapper userInfoMapper;

	@Override
	public UserInfo findByUsername(String username) {
		// TODO Auto-generated method stub
		return userInfoMapper.selectByUsername(username);
	}

	@Override
	public Role findRoleById(Integer id) {
		// TODO Auto-generated method stub
		return userInfoMapper.selectRoleById(id);
	}

	@Override
	public List<Integer> findRoleidByUid(Integer uid) {
		// TODO Auto-generated method stub
		return userInfoMapper.selectRoleidByUid(uid);
	}

	@Override
	public List<Integer> findPermissionidByRoleid(Integer roleid) {
		// TODO Auto-generated method stub
		return userInfoMapper.selectPermissionidByRoleid(roleid);
	}

	@Override
	public Permission findPermissionById(Integer permissionid) {
		// TODO Auto-generated method stub
		return userInfoMapper.selectPermissionById(permissionid);
	}

}
