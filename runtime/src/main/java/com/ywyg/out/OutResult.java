package com.ywyg.out;


import com.ywyg.template.RecordTemplate;

import java.io.IOException;

/**
 * @author saijie.gao
 * @date 2022/1/27
 */
public interface OutResult {

    /**
     * 记录运行时间结果
     * @param recordTemplate 参数使用记录模版
     */
    void record(RecordTemplate recordTemplate) throws IOException;

}
