package com.test.api.api.file;

import org.springframework.web.multipart.MultipartFile;

/**
 * @projectName api
 * @package com.test.api.api.file
 * @className FileDetail
 * @description 文件处理抽象类
 * @auther wangsheng
 * @creatTime 2021/5/19 11:52 下午
 * @company
 * @department
 */
public interface FileDetail {

    /**
     * 文件上传
     * @param files 上传文件列表
     * @param path 文件上传路径
     * @return
     */
    String uploadFile(MultipartFile files[], String path);

    /**
     * 文件下载
     * @return
     */
    String downFile();
}
