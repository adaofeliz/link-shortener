package com.adaofeliz.linkshortener.test;

import com.adaofeliz.linkshortener.Main;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;

@WebAppConfiguration
@ContextConfiguration(classes = Main.class) // Web Application base config file
public class AppInitializationTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private ApplicationContext context;

    @Test(description = "This test will test if the IoC framework is loading without errors.")
    public void testSpringApplicationContextLoad() throws Exception {
        Assert.assertNotNull(context);
    }
}
