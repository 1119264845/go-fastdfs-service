package com.elfop.gofastdfs.uploadservice.client;

import java.io.File;
import java.util.Map;

/**
 * @Description:
 * @author: liu zhenming
 * @version: V1.0
 * @date: 2019/7/23  14:47
 */
public interface FastDfsClient {
    /**
     * 上传文件
     *
     * @param params
     * @param file
     * @return
     */
    String upload(Map<String, String> params, File file);
}
