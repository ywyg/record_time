package com.ywyg.config;

import com.ywyg.advice.MethodCostAdvice;
import com.ywyg.annotation.AnnotationsClass;
import com.ywyg.es.EsService;
import com.ywyg.es.RecordRepository;
import com.ywyg.factory.RecordType;
import com.ywyg.out.OutResult;
import com.ywyg.processor.AddProxyProcessor;
import com.ywyg.utils.VerifyAnnotation;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author saijie.gao
 * @date 2022/1/26
 */
@Slf4j
@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties()
public class AutoConfiguration {

    @Bean
    public RuntimeConfig runtimeConfig() {
        return new RuntimeConfig();
    }

    @Bean
    public EsService esService(final RecordRepository recordRepository) {
        return new EsService(recordRepository);
    }

    @Bean
    @ConditionalOnBean(RuntimeConfig.class)
    public AnnotationsClass annotationsClass(final RuntimeConfig runtimeConfig) {
        AnnotationsClass annotationsClass = new AnnotationsClass(runtimeConfig);
        annotationsClass.setAnnotations();
        return annotationsClass;
    }

    @Bean
    @ConditionalOnBean(AnnotationsClass.class)
    public VerifyAnnotation verifyAnnotation(final AnnotationsClass annotationsClass) {
        return new VerifyAnnotation(annotationsClass);
    }

    @Bean
    @ConditionalOnBean(value = {RuntimeConfig.class, EsService.class})
    public RecordType recordType(final RuntimeConfig runtimeConfig, final EsService esService) {
        return new RecordType(runtimeConfig, esService);
    }

    @Bean
    @ConditionalOnBean(RecordType.class)
    public OutResult outResult(@NonNull final RecordType recordType) {
        return recordType.outResult();
    }

    @Bean
    @ConditionalOnBean(value = {VerifyAnnotation.class, OutResult.class})
    public MethodCostAdvice methodCostAdvice(final VerifyAnnotation verifyAnnotation, final OutResult outResult) {
        return new MethodCostAdvice(verifyAnnotation, outResult);
    }

    @Bean
    @ConditionalOnBean(value = {VerifyAnnotation.class, MethodCostAdvice.class})
    public AddProxyProcessor addProxyProcessor(final MethodCostAdvice methodCostAdvice, final VerifyAnnotation verifyAnnotation) {
        return new AddProxyProcessor(methodCostAdvice, verifyAnnotation);
    }


}
