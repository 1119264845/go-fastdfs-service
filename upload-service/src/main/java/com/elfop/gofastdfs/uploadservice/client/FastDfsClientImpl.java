package com.elfop.gofastdfs.uploadservice.client;

import lombok.extern.slf4j.Slf4j;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import static com.elfop.gofastdfs.uploadservice.client.OkHttpClientUtil.formBodyBuilder;

/**
 * @Description:
 * @author: liu zhenming
 * @version: V1.0
 * @date: 2019/7/23  11:12
 */
@Slf4j
@Component
public class FastDfsClientImpl implements FastDfsClient {

    private static final String FASTDFS_API_UPLOAD_URL = "/upload";

    @Value("${fastDfs.url}")
    private String apiUrl;


    /**
     * 上传文件
     *
     * @param params
     * @param file
     * @return
     */
    @Override
    public String upload(Map<String, String> params, File file) {
        return call(FASTDFS_API_UPLOAD_URL, params, file);
    }

    /**
     * call api by endpoint
     *
     * @param url
     * @param params
     * @return
     */
    private String call(String url, Map<String, String> params, File file) {
        log.debug("准备开始调用 fastDfs API 调用方法 url {}", url);
        try {

            Request request = new Request.Builder()
                    .url(apiUrl + url)
                    .post(formBodyBuilder(params, file))
                    .build();

            Response response = OkHttpClientUtil.CLIENT.newCall(request).execute();

            return response.body().string();
        } catch (IOException e) {
            log.error("准备开始调用 fastDfs API 调用方法 IO 错误 url {} ERROR {} , {}", url, e, e.getMessage());
            throw new RuntimeException("准备开始调用 fastDfs API 调用方法 IO 错误," + e.getMessage());
        } catch (Exception e) {
            log.error("准备开始调用 fastDfs API 调用方法 错误 url {} ERROR {} , {}", url, e, e.getMessage());
            throw new RuntimeException("准备开始调用 fastDfs API 调用方法 错误," + e.getMessage());
        }
    }


}
