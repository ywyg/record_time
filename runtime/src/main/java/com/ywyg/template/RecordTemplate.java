package com.ywyg.template;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.Instant;

/**
 * @author saijie.gao
 * @date 2022/1/26
 */
@Data
@Builder
@ToString
@Document(indexName = "record_template", createIndex = true)
public class RecordTemplate {

    /**
     * 记录Id
     */
    @Id
    private String Id;

    /**
     * 记录方法所在类
     */
    @Field(type = FieldType.Text)
    private Class clazz;

    /**
     * 记录方法名
     */
    @Field(type = FieldType.Text)
    private String method;

    /**
     * 方法开始时间
     */
    @Field(type = FieldType.Long)
    private Instant startTime;

    /**
     * 方法结束时间
     */
    @Field(type = FieldType.Long)
    private Instant endTime;

    /**
     * 方法持续时间
     */
    @Field(type = FieldType.Text)
    private Long duration;
}
