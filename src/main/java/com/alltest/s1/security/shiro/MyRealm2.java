package com.alltest.s1.security.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

/**
 * Created by Evan on 2018/1/29.
 */
public class MyRealm2 implements Realm {
    @Override
    public String getName() {
        return "MyRealm2";
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof UsernamePasswordToken;
    }

    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        Object user = token.getPrincipal();
        Object passwd = new String((char [])token.getCredentials());
        if (!"wang".equals(user)) {
            System.out.println("user is not exist");
            throw new UnknownAccountException("unknown Account!");
        }
        if (!"123".equals(passwd)) {
            System.out.println("passwd is not validate");
            throw new IncorrectCredentialsException("Incorrect Credential!");
        }
        return new SimpleAuthenticationInfo(user, passwd, getName());
    }
}
