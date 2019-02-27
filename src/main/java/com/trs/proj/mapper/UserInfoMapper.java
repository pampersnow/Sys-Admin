package com.trs.proj.mapper;

import java.util.List;

import com.trs.proj.domain.Permission;
import com.trs.proj.domain.Role;
import com.trs.proj.domain.UserInfo;

public interface UserInfoMapper {
	
	UserInfo selectByUsername(String username);
	 
    List<Integer> selectRoleidByUid(Integer uid);
 
    Role selectRoleById(Integer id);
 
    List<Integer> selectPermissionidByRoleid(Integer roleid);
 
    Permission selectPermissionById(Integer permissionid);
}
