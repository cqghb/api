package com.test.api.api.file;

import com.test.api.api.constant.CommConstant;
import com.test.api.api.custom.annotation.FileType;
import com.test.api.api.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * @projectName api
 * @package com.test.api.api.file
 * @className SkuFileService
 * @description 商品相关文件上传的服务
 * @auther wangsheng
 * @creatTime 2023/4/29 上午1:58
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
@Component("2")/* 这里的1是前端上传文件组件送的参数 2表示商品展示的图片*/
@FileType(CommConstant.FILE_TYPE_PRODUCT_DISPLAY_PICTURE)
public class SkuFileService implements FileDetail{
    protected static Logger logger = LoggerFactory.getLogger(SkuFileService.class);

    // 保存位置
    @Value("${sku.picture.path}")
    private String path;
    /**
     * 商品相关文件上传时先上传到临时目录，等审核通过后再移动到正式目录，防止恶意删除文件，
     * 如果临时目录的文件被恶意删除，影像要小得多。
     * @param files 上传文件列表
     * @return
     */
    @Override
    public String uploadFile(MultipartFile[] files) {
        long fileSize = files[0].getSize();
        String fileType = files[0].getContentType();

        // 换个名字存
        String originalFileName = files[0].getOriginalFilename();
        String suffix = originalFileName.substring(originalFileName.lastIndexOf(CommConstant.DOT));
        String fileName = StringUtil.uuid() + suffix;  // 文件名
        File dest = new File(path + File.separator + fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            files[0].transferTo(dest);
        } catch (Exception e) {
            logger.error("文件传失败",e);
            return null;
        }
        return path + fileName;
    }

    @Override
    public String downFile() {
        return null;
    }
}
