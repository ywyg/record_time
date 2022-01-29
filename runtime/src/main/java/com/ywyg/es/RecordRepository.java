package com.ywyg.es;

import com.ywyg.template.RecordTemplate;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author saijie.gao
 * @date 2022/1/27
 */
@Lazy
public interface RecordRepository extends ElasticsearchRepository<RecordTemplate, String> {
}
