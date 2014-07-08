package shiro.c2;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

/**
 * Created by zdsoft on 14-5-26.
 */
public class MyRealm1 implements Realm {
    @Override
    public String getName() {
        return "myRealm1";
    }

    @Override
    public boolean supports(AuthenticationToken authenticationToken) {
        return authenticationToken instanceof UsernamePasswordToken;
    }

    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String)authenticationToken.getPrincipal();
        String password = new String((char[])authenticationToken.getCredentials());
        System.out.println("username=" + username + "password=" + password);
        if (!("zhang".equals(username))){
            throw new UnknownAccountException();
        }
        if (!("123".equals(password))){
            throw new IncorrectCredentialsException();
        }
        return new SimpleAuthenticationInfo(username, password, getName());
    }
}
