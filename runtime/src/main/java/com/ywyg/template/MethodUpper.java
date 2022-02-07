package com.ywyg.template;

import com.ywyg.out.OutResult;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author saijie.gao
 * @date 2022/2/7
 */
public interface MethodUpper {

    /**
     * 自定义模板需要实现该方法
     * @param invocation 方法对象
     * @param outResult 记录模版
     * @return 方法继续向下执行
     * @throws Throwable 方法执行异常
     */
    Object cost(MethodInvocation invocation, OutResult outResult) throws Throwable;
}
