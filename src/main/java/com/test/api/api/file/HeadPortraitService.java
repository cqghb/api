package com.test.api.api.file;

import com.test.api.api.constant.CommConstant;
import com.test.api.api.custom.annotation.FileType;
import com.test.api.api.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
@Component("1")
@FileType(CommConstant.FILE_TYPE_HEAD_PORTRAIT)
public class HeadPortraitService implements FileDetail {
    protected static Logger logger = LoggerFactory.getLogger(HeadPortraitService.class);
    // 头像上传路径
    @Value("${head.portrai.path}")
    private String headPortraiPath;


    @Override
    public String uploadFile(MultipartFile[] files) {
        long fileSize = files[0].getSize();
        logger.info("头像大小为: " + fileSize);
        String fileType = files[0].getContentType();
        logger.info("头像类型为: " + fileType);

//        String fileName = files[0].getOriginalFilename();  // 文件名
        // 换个名字存
        String originalFileName = files[0].getOriginalFilename();
        String suffix = originalFileName.substring(originalFileName.lastIndexOf(CommConstant.DOT));
        String fileName = StringUtil.uuid() + suffix;  // 文件名
        File dest = new File(headPortraiPath + File.separator + fileName);
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
        return headPortraiPath + fileName;
    }

    @Override
    public String downFile() {
        return null;
    }
}
