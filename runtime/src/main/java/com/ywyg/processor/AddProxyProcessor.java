package com.ywyg.processor;

import com.ywyg.advice.MethodCostAdvice;
import com.ywyg.utils.VerifyAnnotation;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Method;

/**
 * @author saijie.gao
 * @date 2022/1/26
 */
public class AddProxyProcessor implements BeanPostProcessor {

    private final MethodCostAdvice methodCostAdvice;
    private final VerifyAnnotation verifyAnnotation;

    public AddProxyProcessor(MethodCostAdvice methodCostAdvice, VerifyAnnotation verifyAnnotation) {
        this.verifyAnnotation = verifyAnnotation;
        this.methodCostAdvice = methodCostAdvice;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> clazz = bean.getClass();
        do {
            for (final Method method : clazz.getMethods()) {
                if (verifyAnnotation.needRecord(method)) {
                    ProxyFactory proxyFactory = new ProxyFactory();
                    proxyFactory.addAdvice(methodCostAdvice);
                    proxyFactory.setOptimize(true);
                    proxyFactory.setFrozen(true);
                    proxyFactory.setTarget(bean);
                    return proxyFactory.getProxy();
                }
            }
            clazz = clazz.getSuperclass();
        } while (clazz != null);
        return bean;
    }


}
