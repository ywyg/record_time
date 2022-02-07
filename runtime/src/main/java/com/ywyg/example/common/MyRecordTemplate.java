package com.ywyg.example.common;

import com.ywyg.template.RecordTemplate;
import lombok.Builder;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.stereotype.Service;

/**
 * @author saijie.gao
 * @date 2022/2/7
 */
@ToString
@SuperBuilder
public class MyRecordTemplate extends RecordTemplate {

}
