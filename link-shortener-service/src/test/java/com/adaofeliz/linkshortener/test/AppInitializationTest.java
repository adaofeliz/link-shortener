package com.adaofeliz.linkshortener.test;

import com.adaofeliz.linkshortener.Main;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.assertNotNull;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Main.class})
public class AppInitializationTest {

    @Autowired
    ApplicationContext context;

    @Test
    public void testSpringApplicationContextLoad() {
        assertNotNull(context);
    }
}
