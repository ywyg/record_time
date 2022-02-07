package com.ywyg.example.common;

import com.ywyg.out.OutResult;
import com.ywyg.template.MethodUpper;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Service;

/**
 * @author saijie.gao
 * @date 2022/2/7
 */
@Service
public class MyMethodUpper implements MethodUpper {

    @Override
    public Object cost(MethodInvocation invocation, OutResult outResult) throws Throwable {
        outResult.record(MyRecordTemplate.builder().build());
        return invocation.proceed();
    }
}
