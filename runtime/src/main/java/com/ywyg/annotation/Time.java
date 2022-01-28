package com.ywyg.annotation;

import java.lang.annotation.*;

/**
 * @author saijie.gao
 * @date 2022/1/26
 */
@Documented
@Inherited
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Time {
}
