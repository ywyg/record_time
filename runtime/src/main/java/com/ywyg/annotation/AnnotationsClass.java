package com.ywyg.annotation;

import com.ywyg.config.RuntimeConfig;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author saijie.gao
 * @date 2022/1/26
 */
@Slf4j
public class AnnotationsClass {

    private final RuntimeConfig runtimeConfig;
    private final List<Class> annotations = new ArrayList<>();


    public AnnotationsClass(RuntimeConfig runtimeConfig) {
        this.runtimeConfig = runtimeConfig;
    }

    public void setAnnotations() {
        runtimeConfig.getAnnotations().forEach(annotation -> {
                    try {
                        Class<?> clazz = Class.forName(annotation);
                        annotations.add(clazz);
                    } catch (ClassNotFoundException ignored) {
                        log.error("Annotation {} not found", annotation);
                    }
                }
        );
        annotations.add(Time.class);
    }

    public List<Class> getAnnotations() {
        return annotations;
    }
}
