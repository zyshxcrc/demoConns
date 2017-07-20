package dao;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * Created by Administrator on 2017/6/30.
 */
public class MyRealm extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("1");
        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
        String name = token.getUsername();
        String password = new String(token.getPassword());
        System.out.println(name + "+++" + password);
        if ("zyliu".equals(name)&&"123456".equals(password)){
            return new SimpleAuthenticationInfo(name,password,getName());
        }
        return null;
    }
}
