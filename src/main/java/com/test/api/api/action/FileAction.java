package com.test.api.api.action;

import com.test.api.api.config.Result;
import com.test.api.api.file.FileService;
import com.test.api.api.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @projectName api
 * @package com.test.api.api.action
 * @className FileAction
 * @description 文件上传下载控制器
 * @auther wangsheng
 * @creatTime 2021/5/19 10:10 下午
 * @company
 * @department
 */
@RestController
@RequestMapping("file")
public class FileAction {

    protected static Logger logger = LoggerFactory.getLogger(FileAction.class);

    @Autowired
    private FileService fileService;
    /**
     * 文件上传，不同类别的文件保存在不同的位置中
     * @param files 文件列表
     * @param fileType 上传文件类别【头像类图片、商品图片等】
     * @return
     */
    @RequestMapping("/uploadFile")
    public Result uploadFile(@RequestParam("files")MultipartFile files[], @RequestParam("fileType")String fileType){
        String filePath = fileService.getFileDetail(fileType).uploadFile(files);
        logger.info("保存的文件路径是: " + filePath);
        return ResultUtil.success(filePath);
    }
}
