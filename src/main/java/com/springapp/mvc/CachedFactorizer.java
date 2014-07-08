package com.springapp.mvc;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import javax.servlet.*;
import java.io.IOException;
import java.math.BigInteger;

/**
 * Created by zdsoft on 14-5-29.
 */
@ThreadSafe
public class CachedFactorizer implements Servlet {

    @GuardedBy("this") private BigInteger lastNumber;
    @GuardedBy("this") private BigInteger[] lastFactorizer;
    @GuardedBy("this") private long hits;
    @GuardedBy("this") private long cacheHits;

    public synchronized long getHits(){
        return hits;
    }

    public synchronized double getCacheHitRatio(){
        return (double)cacheHits / (double)hits;
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
        BigInteger i = BigInteger.valueOf(1);//BigInteger.ONE;
        BigInteger[] factors = null;
        synchronized (this){
            ++hits;
            if (i.equals(lastNumber)){
                ++cacheHits;
                factors = lastFactorizer.clone();
            }
        }
        if (factors == null){
//            factors = factor(i);
        }



    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
