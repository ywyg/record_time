package com.ywyg.out;

import com.ywyg.template.RecordTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ObjectUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author saijie.gao
 * @date 2022/1/27
 */
@Slf4j
public class OutFile implements OutResult {

    private static final String FILENAME = String.format("method_runtime_record_%s.log", new SimpleDateFormat("yyyy_MM_dd").format(new Date()));
    private final String path;

    /**
     * @param path file path
     */
    public OutFile(String path) {
        if (ObjectUtils.isEmpty(path)) {
            log.error("runtime.path not empty");
            Runtime.getRuntime().exit(0);
        }
        this.path = path + File.separator + FILENAME;
    }


    @Override
    public void record(RecordTemplate recordTemplate) throws IOException {
        FileOutputStream fileOutputStream = null;
        File file = checkFile();
        try {
            assert file != null;
            fileOutputStream = new FileOutputStream(file, true);
            fileOutputStream.write(recordTemplate.toString().getBytes());
            fileOutputStream.write(System.getProperty("line.separator").getBytes());
            fileOutputStream.flush();
        } catch (AssertionError | IOException ioException) {
            log.error(ioException.getMessage());
        } finally {
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
        }
    }

    private File checkFile() {
        File check = new File(path);
        try {
            if (check.exists() || check.createNewFile()) {
                return check;
            } else {
                log.error("An error occur when create file {} ", path);
                return null;
            }
        } catch (IOException ioException) {
            log.error("An error occur when create file {} ", path);
            return null;
        }
    }

}
