package com.test.api.api.file;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @projectName api
 * @package com.test.api.api.file
 * @className FileService
 * @description TODO
 * @auther wangsheng
 * @creatTime 2021/5/29 12:37 上午
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
@Component
public class FileService {

    protected static Logger logger = LoggerFactory.getLogger(FileService.class);

    private final Map<String, FileDetail> fileDetailMap = new ConcurrentHashMap<>();

    /**
     * 初始化文件处理策略
     * @param fileDetailMap 文件处理策略
     */
    public FileService(Map<String, FileDetail> fileDetailMap) {
        this.fileDetailMap.clear();
        fileDetailMap.forEach((k,v)->this.fileDetailMap.put(k,v));
        logger.info("文件操作策略类加载完成: " + this.fileDetailMap);
    }
    /**
     * 获得对应文件类型的处理策略
     * @param fileType 文件类型
     * @return
     */
    public FileDetail getFileDetail(String fileType){
        return this.fileDetailMap.get(fileType);
    }
}
