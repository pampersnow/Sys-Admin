package com.trs.proj.service;

import java.util.List;

import com.trs.proj.domain.Permission;
import com.trs.proj.domain.Role;
import com.trs.proj.domain.UserInfo;

public interface UserInfoService {
	UserInfo findByUsername(String username);
	 
    Role findRoleById(Integer id);
 
    List<Integer> findRoleidByUid(Integer uid);
 
    List<Integer> findPermissionidByRoleid(Integer roleid);
 
    Permission findPermissionById(Integer permissionid);
}
