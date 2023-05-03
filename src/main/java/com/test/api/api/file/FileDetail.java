package com.test.api.api.file;

import com.test.api.api.config.AppException;
import com.test.api.api.constant.MsgCodeConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

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
    Logger logger = LoggerFactory.getLogger(FileDetail.class);

    /**
     * 文件上传
     * @param files 上传文件列表
     * @return
     */
    String uploadFile(MultipartFile files[]);

    /**
     * 文件下载
     * @return
     */
    String downFile();

    /**
     * 删除指定路径的文件
     * @param filePath 文件路径
     * @return
     */
    default boolean delFile(String filePath) throws AppException {
        File file = new File(filePath);
        if(file.isDirectory()){
            throw new AppException(MsgCodeConstant.ERROR_CODE, "文件路径不正确");
        }
        if(!file.exists()){
            throw new AppException(MsgCodeConstant.ERROR_CODE, "文件不存在");
        }
        logger.info("删除的文件路径为:" + filePath);
        return file.delete();
    }
}
