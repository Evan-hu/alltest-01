package com.alltest.s1.security.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

/**
 * Created by Evan on 2018/1/18.
 */
public class ValidateRealm implements Realm {
    /**
     * 获取 realm 的名字
     * @return
     */
    @Override
    public String getName() {
        return this.toString();
    }

    /**
     * 验证是否支持 token
     * @param token
     * @return
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        //仅支持UsernamePasswordToken类型的Token
        return token instanceof UsernamePasswordToken;
    }

    /**
     * 根据 token 获取认证信息
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        Object user = token.getPrincipal();
        Object passwd = new String((char [])token.getCredentials());
        if (!"zhang".equals(user)) {
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
