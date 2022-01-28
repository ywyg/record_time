package com.ywyg.example;

import com.ywyg.example.common.Demo01;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author saijie.gao
 * @date 2022/1/27
 */
@SpringBootTest
public class MethodTest {

    @Autowired
    private Demo01 demo01;

    @Test
    public void test01() {
        demo01.method01();
        demo01.method04();
    }
}
