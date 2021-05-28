package com.test.api.api.file;

import com.test.api.api.custom.annotation.FileType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @projectName api
 * @package com.test.api.api.file
 * @className FileServiceFactory
 * @description 文件处理工厂
 * @deprecated 策略服务不能注入自定义参数，废弃这个工厂
 * @auther wangsheng
 * @creatTime 2021/5/20 10:49 下午
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
@Component
public class FileServiceFactory {

    protected static Logger logger = LoggerFactory.getLogger(FileServiceFactory.class);

    // 单例对象 volatile + 双重检测机制 -> 禁止指令重排
    private volatile static FileServiceFactory instance = null;
    // 要扫描的策略类的包
    public static final String SCAN_PACKAGE = FileServiceFactory.class.getPackage().getName();
    // 策略类的集合
    private static List<Class<? extends FileDetail>> fileDetailList = new ArrayList<>();

    private FileServiceFactory() {
        getFileDetailList();
    }

    /**
     * 静态工厂方法
     * @return
     */
    public static FileServiceFactory getInstance(){
        if(null == instance){// 双重检测机制
            synchronized (FileServiceFactory.class){// 同步锁
                if(instance == null){
                    instance = new FileServiceFactory();
                }
            }
        }
        return instance;
    }

    /**
     * 加载文件下载策略类
     */
    public static void getFileDetailList(){
        try {
            String path = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "java" + File.separator + "" + SCAN_PACKAGE.replace(".", File.separator) + File.separator;
            File file = new File(path);
            String[] strs = file.list();
            for(String str : strs){
                String forName = SCAN_PACKAGE + "." + str.replace(".java", "");
                Class<? extends FileDetail> clazz = (Class<? extends FileDetail>)Class.forName(forName);
                if(clazz.isAnnotationPresent(FileType.class)){
                    fileDetailList.add(clazz);
                }
            }
//            logger.info("文件操作策略类加载完成: " + fileDetailList);

        } catch (ClassNotFoundException e) {
            logger.error("文件下载策略加载失败: " + e.getMessage(), e);
        }
    }

    /**
     * 获得对应文件类型的处理策略
     * @param fileType 文件类型
     * @return
     */
    public static FileDetail getFileDetail(String fileType){
        for(Class<? extends FileDetail> clazz : fileDetailList){
            FileType fileTypeEnum = clazz.getAnnotation(FileType.class);
            if(fileTypeEnum.value().equals(fileType)){
                try {
                    return clazz.newInstance();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
