package com.ywyg.es;

import com.ywyg.template.RecordTemplate;

/**
 * @author saijie.gao
 * @date 2022/1/27
 */
public class EsService {

    private final RecordRepository recordRepository;

    public EsService(RecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }

    public void put(RecordTemplate bean) {
        recordRepository.save(bean);
    }
}
