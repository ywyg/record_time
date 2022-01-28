package com.ywyg.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author saijie.gao
 * @date 2022/1/26
 */
@SpringBootTest
public class RuntimeConfigTest {

    @Autowired
    private RuntimeConfig runtimeConfig;

    @Test
    public void ListAnnotation() {
        System.out.println(runtimeConfig.getAnnotations());
    }

}
