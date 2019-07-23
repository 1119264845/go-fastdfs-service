package com.elfop.gofastdfs.uploadservice.client;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @author: liu zhenming
 * @version: V1.0
 * @date: 2019/7/9  15:36
 */
@Component
public class OkHttpClientUtil {

    public static final int CONN_TIMEOUT = 20;
    public static final int READ_TIMEOUT = 20;
    public static final int WRITE_TIMEOUT = 20;
    public static final OkHttpClient CLIENT = createOkHttpClient();
    private static final String FASTDFS_PARAMETER_NAMES_FILE = "file";

    private static OkHttpClient createOkHttpClient() {
        return new OkHttpClient.Builder().connectTimeout(CONN_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS).writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
                .build();
    }

    public static MultipartBody formBodyBuilder(Map<String, String> params, File file) {

        MultipartBody.Builder bodyBuilder = new MultipartBody.Builder().setType(MultipartBody.FORM);

        if (params != null) {
            for (String key2 : params.keySet()) {
                bodyBuilder.addFormDataPart(key2, params.get(key2));
            }
        }

        bodyBuilder.addFormDataPart(
                FASTDFS_PARAMETER_NAMES_FILE, file.getName(), RequestBody.create(MediaType.parse("image/png"), file)
        );
        return bodyBuilder.build();
    }


}
