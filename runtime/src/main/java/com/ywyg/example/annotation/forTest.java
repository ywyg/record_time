package com.ywyg.example.annotation;

import java.lang.annotation.*;

/**
 * @author saijie.gao
 * @date 2022/1/27
 */
@Documented
@Inherited
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface forTest {
}
