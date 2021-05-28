package com.test.api.api.utils;

import com.test.api.api.constant.CommConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.io.File;

/**
 * @projectName api
 * @package com.test.api.api.utils
 * @className FileUtil
 * @description 文件工具类
 * @auther wangsheng
 * @creatTime 2021/5/29 1:48 上午
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
public class FileUtil {

    protected static final Logger logger = LoggerFactory.getLogger(FileUtil.class);

    /**
     * 通过文件路径直接修改文件名
     *
     * @param filePath    需要修改的文件的完整路径
     * @param newFileName 需要修改的文件的名称
     * @return
     */
    public static String fixFileName(String filePath, String newFileName) {
        File f = new File(filePath);
        if (!f.exists()) { // 判断原文件是否存在（防止文件名冲突）
            return null;
        }
        newFileName = newFileName.trim();
        if (StringUtils.isEmpty(newFileName)) // 文件名不能为空
            return null;
        String newFilePath = null;
        String basePath = filePath.substring(0, filePath.lastIndexOf(File.separator));
        if (f.isDirectory()) { // 判断是否为文件夹
            newFilePath = basePath + File.separator + newFileName;
        } else {
            newFilePath = basePath + File.separator + newFileName;
                   // + filePath.substring(filePath.lastIndexOf(CommConstant.DOT));
        }
        File nf = new File(newFilePath);
        try {
            f.renameTo(nf); // 修改文件名
        } catch (Exception err) {
            logger.error("文件改名失败" + err.getMessage(), err);
            return null;
        }
        return newFilePath;
    }
}
