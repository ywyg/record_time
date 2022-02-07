package com.ywyg.template;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @author saijie.gao
 * @date 2022/2/7
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "record_log", createIndex = true)
public abstract class RecordTemplate {

    /**
     * 记录Id
     */
    @org.springframework.data.annotation.Id
    String Id;
}
