package com.ywyg.factory;

import com.ywyg.config.RuntimeConfig;
import com.ywyg.enumerate.OutType;
import com.ywyg.es.EsService;
import com.ywyg.out.OutConsole;
import com.ywyg.out.OutEs;
import com.ywyg.out.OutFile;
import com.ywyg.out.OutResult;
import lombok.extern.slf4j.Slf4j;

/**
 * @author saijie.gao
 * @date 2022/1/27
 */
@Slf4j
public class RecordType {

    private final RuntimeConfig runtimeConfig;
    private final EsService esService;

    public RecordType(RuntimeConfig runtimeConfig, EsService esService) {
        this.runtimeConfig = runtimeConfig;
        this.esService = esService;
    }

    public OutResult outResult() {
        OutType outType = runtimeConfig.getOutType();
        switch (outType) {
            case CONSOLE: {
                return new OutConsole();
            }
            case FILE: {
                return new OutFile(runtimeConfig.getPath());
            }
            case ELASTICSEARCH: {
                return new OutEs(esService);
            }
            default: {
                log.warn("outType can not empty");
                Runtime.getRuntime().exit(0);
                return null;
            }
        }
    }

}
