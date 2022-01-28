package com.ywyg.utils;

import com.ywyg.annotation.AnnotationsClass;
import org.springframework.core.annotation.AnnotationUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author saijie.gao
 * @date 2022/1/27
 */
public class VerifyAnnotation {

    private final AnnotationsClass annotationsClass;

    public VerifyAnnotation(AnnotationsClass annotationsClass) {
        this.annotationsClass = annotationsClass;
    }

    public boolean needRecord(Method method) {
        for (Class clazz : annotationsClass.getAnnotations()) {
            Annotation annotation = AnnotationUtils.findAnnotation(method, clazz);
            if (annotation != null) {
                return true;
            }
        }
        return false;
    }


}
