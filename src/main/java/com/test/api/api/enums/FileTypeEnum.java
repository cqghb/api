package com.test.api.api.enums;

/**
 * @projectName api
 * @package com.test.api.api.enums
 * @className FileTypeEnum
 * @description 文件类型枚举
 * @auther wangsheng
 * @creatTime 2021/5/29 1:29 上午
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
public enum FileTypeEnum {
    JPG("jpg","JPG"),
    JPEG("jpeg","JPEG"),
    PNG("png","PNG"),
    GIF("gif","GIF"),
    PDF("pdf","PDF"),
    DOC("doc","DOC"),
    DOCX("docx","DOCX"),
    XLS("xls","XLS"),
    XLSX("xlsx","XLSX"),
    PPT("ppt","PPT"),
    PPTX("pptx","PPTX");

    private String code;
    private String desc;

    FileTypeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public FileTypeEnum getFileTypeEnum(String code){
        for (FileTypeEnum item : FileTypeEnum.values()){
            if(item.getCode().equals(code)){
                return item;
            }
        }
        return null;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
