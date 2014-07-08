package com.springapp.mvc;

import junit.framework.Assert;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.*;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

/**
 * Created by zdsoft on 14-5-26.
 */

public class TestHelloWord {

    @Test
    public void testHelloWord(){


        String path = "/Users/zdsoft/Desktop/Java/dev1/Shiro/src/test/resource/shiro.ini";

        path = "classpath:shiro.ini";
        path = "classpath:shiro-realm.ini";

        Factory<org.apache.shiro.mgt.SecurityManager> factory = new IniSecurityManagerFactory(path);
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");
        try{
            subject.login(token);
            System.out.print("success login");
        }catch (AuthorizationException e){
            System.out.print("fail");
        };

        Assert.assertEquals(true, subject.isAuthenticated());

        subject.logout();
    }
}
