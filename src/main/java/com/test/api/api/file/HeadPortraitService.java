package com.test.api.api.file;

import com.test.api.api.constant.CommConstant;
import com.test.api.api.custom.annotation.FileType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @projectName api
 * @package com.test.api.api.file
 * @className HeadPortraitService
 * @description 头像处理服务
 * @auther wangsheng
 * @creatTime 2021/5/20 12:10 上午
 * @company
 * @department
 */
@Component
@FileType(CommConstant.FILE_TYPE_HEAD_PORTRAIT)
public class HeadPortraitService implements FileDetail {
    protected static Logger logger = LoggerFactory.getLogger(HeadPortraitService.class);
//    // 头像上传路径
//    @Value("${head.portrai.path}")
//    private String headPortraiPath;

    @Override
    public String uploadFile(MultipartFile[] files, String path) {
        long fileSize = files[0].getSize();
        logger.info("头像大小为: " + fileSize);
        String fileType = files[0].getContentType();
        logger.info("头像类型为: " + fileType);

        // TODO 暂时就用上传的文件名作为保存的文件名
        String fileName = files[0].getOriginalFilename();  // 文件名
        File dest = new File(path + File.separator + fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            files[0].transferTo(dest);
        } catch (Exception e) {
//            log.error("{}",e);
//            object.put("success",2);
//            object.put("result","程序错误，请重新上传");
            return null;
        }
        return path + fileName;
    }

    @Override
    public String downFile() {
        return null;
    }
}
