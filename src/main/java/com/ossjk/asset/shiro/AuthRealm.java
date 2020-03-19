package com.ossjk.asset.shiro;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.ossjk.asset.system.entity.Permission;
import com.ossjk.asset.system.entity.User;
import com.ossjk.asset.system.service.IPermissionService;
import com.ossjk.asset.system.service.IRoleService;
import com.ossjk.asset.system.service.IUserService;

public class AuthRealm extends AuthorizingRealm {
	@Autowired
	private IUserService userService;

	@Autowired
	private IRoleService roleService;

	@Autowired
	private IPermissionService ips;

	// 认证.登录
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// 实现登录逻辑的

		UsernamePasswordToken utoken = (UsernamePasswordToken) token;// 获取用户输入的token
		// 获取到UsernamePasswordToken就可以获取用户的帐号密码，拿到了之后就可以进行的登录逻辑的

		String username = utoken.getUsername();
		// 查询数据库的用户信息
		Wrapper wrapper = Condition.create().eq("name", username);
		User user = userService.selectOne(wrapper);
		// 在shiro中，shiro不管权限对象是什么，shiro 只负责拿到权限地址（字符）
		// 当前用户在系统上有什么权限，把拥有的权限设置到permissions
		List<String> url = ips.selectUserPermission(Condition.create().isWhere(true).eq(" u.id ", user.getId()));
		Wrapper wrapper2 = Condition.create().isWhere(true).eq(" u.id ", user.getId()).between("level", 1, 2);
		List<Permission> menu = ips.selectMenuPermission(wrapper2);
		SecurityUtils.getSubject().getSession().setAttribute("permission", url);
		SecurityUtils.getSubject().getSession().setAttribute("menu", menu);
		return new SimpleAuthenticationInfo(user, user.getPwd(), this.getClass().getName());// 放入shiro.调用CredentialsMatcher检验密码
	}

	// 授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
		// 根据PrincipalCollection对象获取session中的对象信息
		// User user = (User)
		// principal.fromRealm(this.getClass().getName()).iterator().next();//
		// 获取session中的用户
		// 根据用户查询数据库中的权限，就可以把所有的权限交给shiro，shiro就会自动的帮我们判断该按钮是否有权限显示

		List<String> permission = (List<String>) SecurityUtils.getSubject().getSession().getAttribute("permission");
		// 把所有的权限交给SimpleAuthorizationInfo进行管理
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.addStringPermissions(permission);// 将权限放入shiro中.
		return info;
	}

}