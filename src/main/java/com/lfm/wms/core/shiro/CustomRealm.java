package com.lfm.wms.core.shiro;

import com.lfm.wms.Service.RolePermService;
import com.lfm.wms.Service.UserInfoService;
import com.lfm.wms.Service.UserRoleService;
import com.lfm.wms.model.UserInfo;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author lfm
 * @date 2019/11/15 - 17:45
 */

public class CustomRealm extends AuthorizingRealm {

    @Autowired
    private UserInfoService userService;
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private RolePermService rolePermService;

    public CustomRealm() {
    }

    /**
     * 告诉shiro如何根据获取到的用户信息中的密码和盐值来校验密码
     */
    {
        //设置用于匹配密码的CredentialsMatcher
        HashedCredentialsMatcher hashMatcher = new HashedCredentialsMatcher();
        hashMatcher.setHashAlgorithmName("md5");
        hashMatcher.setStoredCredentialsHexEncoded(true);
        //加密的次数
        hashMatcher.setHashIterations(1024);
        this.setCredentialsMatcher(hashMatcher);
    }



    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        if (principals == null) {
            throw new AuthorizationException("PrincipalCollection method argument cannot be null.");
        }
        UserInfo user = (UserInfo) getAvailablePrincipal(principals);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setRoles(user.getRoles());
        info.setStringPermissions(user.getPerms());
        return info;
    }




    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken upToken=(UsernamePasswordToken) token;
        String username =upToken.getUsername();
        if(username==null){
            throw  new AccountException("Null usernames are not allowed by this realm");
        }
        UserInfo userDB=userService.selectByName(username);
        if(userDB ==null){
            throw new UnknownAccountException("No account found for admin [" + username + "]");
        }
    // 查询用户的角色和权限存到SimpleAuthenticationInfo中，这样在其他地方就能拿出用户的所有信息，包括角色和权限
        List<String> roleList = userRoleService.getRolesByUserId(userDB.getId());
        List<String> permList = rolePermService.getPermsByUserId(userDB.getId());
        Set<String> roles=new HashSet<>(roleList);
        Set<String> perms=new HashSet<>(permList);
        userDB.setRoles(roles);
        userDB.setPerms(perms);
        SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(userDB,userDB.getPassword(),getName());
        info.setCredentialsSalt(ByteSource.Util.bytes(userDB.getSalt()));
        return info;
    }


}
