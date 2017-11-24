package com.yuan.web;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-core.xml","classpath:spring-mvc.xml"})
@Transactional(transactionManager="transactionManager")
public abstract class AbstractTest{


}
