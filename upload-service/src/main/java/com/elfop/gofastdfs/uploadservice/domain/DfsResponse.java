package com.elfop.gofastdfs.uploadservice.domain;

import lombok.Data;

/**
 * @Description:
 * @author: liu zhenming
 * @version: V1.0
 * @date: 2019/7/23  14:26
 */
@Data
public class DfsResponse {

    private String status;

    private String message;

    private Object data;

}
