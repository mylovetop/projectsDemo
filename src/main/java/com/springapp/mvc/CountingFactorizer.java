package com.springapp.mvc;

import javax.servlet.*;
import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by zdsoft on 14-5-29.
 */
public class CountingFactorizer implements Servlet {

    private final AtomicLong count = new AtomicLong(0);

    public long getCount(){
        return count.get();
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
//        BigInteger i = ex
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
