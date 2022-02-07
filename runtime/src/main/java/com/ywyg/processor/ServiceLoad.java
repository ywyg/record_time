package com.ywyg.processor;

import com.ywyg.template.MethodUpper;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.HashMap;
import java.util.Map;

/**
 * @author saijie.gao
 * @date 2022/2/7
 */
public class ServiceLoad implements ApplicationContextAware {

    private Map<String, MethodUpper> map;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        map = applicationContext.getBeansOfType(MethodUpper.class);
    }

    public Map<String, MethodUpper> getMap() {
        return map == null ? new HashMap<>() : map;
    }
}
