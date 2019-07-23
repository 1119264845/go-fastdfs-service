package com.elfop.gofastdfs.uploadservice.domain;

import lombok.Data;

import java.io.File;

/**
 * @Description:
 * @author: liu zhenming
 * @version: V1.0
 * @date: 2019/7/23  11:15
 */
@Data
public class DfsUpload {

    private File file;

    private String scene;

    private String path;

    private String output;

    private String authToken;
}
