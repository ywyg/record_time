package com.ywyg.advice;

import com.ywyg.out.OutResult;
import com.ywyg.template.RecordTemplate;
import com.ywyg.utils.VerifyAnnotation;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.time.Instant;
import java.util.UUID;

/**
 * @author saijie.gao
 * @date 2022/1/27
 */
public class MethodCostAdvice implements MethodInterceptor {

    private final VerifyAnnotation verifyAnnotation;
    private final OutResult outResult;

    public MethodCostAdvice(VerifyAnnotation verifyAnnotation, OutResult outResult) {
        this.verifyAnnotation = verifyAnnotation;
        this.outResult = outResult;
    }

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        if (verifyAnnotation.needRecord(invocation.getMethod())) {
            return timeCost(invocation);
        } else {
            return invocation.proceed();
        }
    }

    private Object timeCost(MethodInvocation invocation) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = invocation.proceed();
        long end = System.currentTimeMillis();
        RecordTemplate recordTemplate = RecordTemplate.builder()
                .Id(UUID.randomUUID().toString())
                .clazz(invocation.getMethod().getDeclaringClass())
                .method(invocation.getMethod().getName())
                .startTime(Instant.ofEpochMilli(start))
                .endTime(Instant.ofEpochMilli(end))
                .duration(end - start)
                .build();
        outResult.record(recordTemplate);
        return result;
    }

}
