package com.ywyg.config;

import com.ywyg.enumerate.OutType;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * @author saijie.gao
 * @date 2022/1/26
 */
@Data
@EnableConfigurationProperties(RuntimeConfig.class)
@ConfigurationProperties("runtime")
public class RuntimeConfig {

    /**
     * 需要记录时间的注解，必须是方法上注解
     * 例如：
     * runtime:
     * annotation: annotation_x 全限定类名,annotation_y 全限定类名
     * 所有被 annotation_x,annotation_y 修饰的方法运行时间都会被记录
     */
    private List<String> annotations = new ArrayList<>();

    public List<String> getAnnotations() {
        return annotations;
    }

    /**
     * 输出类型：目前支持 {CONSOLE|FILE|ELASTICSEARCH}
     */
    private OutType type = OutType.CONSOLE;

    public OutType getOutType() {
        return type;
    }

    /**
     * 输出到文件时需要指定路径
     */
    private  String path = "";

    public String getPath() {
        return path;
    }
}
