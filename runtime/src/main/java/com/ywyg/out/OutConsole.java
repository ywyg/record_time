package com.ywyg.out;

import com.ywyg.template.RecordTemplate;

/**
 * @author saijie.gao
 * @date 2022/1/27
 */
public class OutConsole implements OutResult {

    @Override
    public void record(RecordTemplate recordTemplate) {
        System.out.println(recordTemplate);
    }

}
