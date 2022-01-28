package com.ywyg.out;


import com.ywyg.es.EsService;
import com.ywyg.template.RecordTemplate;

/**
 * @author saijie.gao
 * @date 2022/1/27
 */
public class OutEs implements OutResult {

    private final EsService esService;

    public OutEs(EsService esService) {
        this.esService = esService;
    }

    @Override
    public void record(RecordTemplate recordTemplate) {
        esService.put(recordTemplate);
    }

}
