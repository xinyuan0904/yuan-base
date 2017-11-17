package com.yuan.comm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 *
 */
public class App 
{
	//日志参考：https://www.cnblogs.com/warking/p/5710303.html
	//https://wiki.base22.com/display/btg/How+to+setup+SLF4J+and+LOGBack+in+a+web+app+-+fast
	private static final  Logger LOG = LoggerFactory.getLogger(App.class); 
	
    public static void main( String[] args )
    {
    	LOG.trace("Hello World!");
    	LOG.debug("How are you today?");
    	LOG.info("I am fine.");
    	LOG.warn("I love programming.");
    	LOG.error("I am programming.");
        System.out.println( "Hello World!" );
    }
}
