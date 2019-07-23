package com.elfop.gofastdfs.uploadservice;

import com.elfop.gofastdfs.uploadservice.client.FastDfsClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @author: liu zhenming
 * @version: V1.0
 * @date: 2019/7/23  15:00
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FastDfsClientTest {

    @Resource
    private FastDfsClient client;

    @Test
    public void uploadTest() {

        File file = new File("D:\\test.jpg");

        Map<String, String> data = new HashMap<>(10);
        data.put("scene", "default");
        data.put("output", "json");
        data.put("path", "/mypic");
        data.put("auth_token", "");

        String response = client.upload(data, file);

        System.out.println(response);
    }


}
