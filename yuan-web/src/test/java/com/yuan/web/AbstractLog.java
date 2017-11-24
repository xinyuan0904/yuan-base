package com.yuan.web;

import org.junit.runners.model.InitializationError;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;

public class AbstractLog{
	static{
		LoggerContext  lc = (LoggerContext) LoggerFactory.getILoggerFactory();
		JoranConfigurator configurator = new JoranConfigurator();  
	    configurator.setContext(lc);  
	    lc.reset();
	    try {
			configurator.doConfigure("E:\\java.project\\yuan-base\\yuan-web\\src\\main\\resources\\logback.xml");
		} catch (JoranException e) {
			e.printStackTrace();
		}
	}
}
