package com.ywyg.template;

/**
 * @author saijie.gao
 * @date 2022/1/29
 */
public interface Template {

    /**
     * 继承Template 选择记录方式
     *
     * @param recordTemplate 模版
     * @return 返回新格式的 Json - String
     */
    String record(RecordTemplate recordTemplate);

}
