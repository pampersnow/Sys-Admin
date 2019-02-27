package com.trs.proj.config;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import com.trs.proj.domain.UserInfo;
import com.trs.proj.service.UserInfoService;

public class MyshiroRealm extends AuthorizingRealm {

	@Resource
	private UserInfoService userInfoService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		System.out.println("开始权限配置>>>执行调用>>>MyShiroRealm>>>doGetAuthorizationInfo()");
		SimpleAuthorizationInfo authenticationInfo = new SimpleAuthorizationInfo();
		UserInfo userInfo = (UserInfo) principals.getPrimaryPrincipal();
		for (Integer integer : userInfoService.findRoleidByUid(userInfo.getUid())) {
			authenticationInfo.addRole(userInfoService.findRoleById(integer).getRole());
			for (Integer id : userInfoService.findPermissionidByRoleid(integer)) {
				authenticationInfo.addStringPermission(userInfoService.findPermissionById(id).getPermission());
			}
		}
		return authenticationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		System.out.println("开始登陆验证>>>执行调用>>>MyShiroRealm>>>doGetAuthenticationInfo()");
		String username = (String) token.getPrincipal();
		System.out.println("token.getCredentials()----->>>" + token.getCredentials());
		UserInfo userInfo = userInfoService.findByUsername(username);
		System.out.println("userInfo----->>>" + userInfo);
		if (userInfo == null) {
			return null;
		}
		System.out.println(userInfo.getCredentialsSalt());
		System.out.println(userInfo.getPassword());

		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(userInfo, userInfo.getPassword(),
				ByteSource.Util.bytes(userInfo.getCredentialsSalt()), getName());
		return authenticationInfo;
	}

}
