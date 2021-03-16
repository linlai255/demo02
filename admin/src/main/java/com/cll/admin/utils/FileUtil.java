package com.cll.admin.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class FileUtil {
    /**
     * 系统文件分隔符 File.separator
     */
    private static final String SEPARATOR = "/";

    /**
     * 这里上传指定的文件到此module所属的project目录
     */
    private static final String BASE_DIR = System.getProperty("user.dir") + SEPARATOR ;

    /**
     * 一级目录
     */
    private static final String FIRST_LEVEL_DIR = "uploads";

    /**
     * 默认二级目录
     */
    private static final String SECOND_LEVEL_DIR_DEFAULT = "default";

    /**
     * @param file file
     * @return relative path
     * @throws IOException IOException
     */
    public static String upload(MultipartFile file) throws IOException {
        String secondLPath =String.valueOf(System.currentTimeMillis());
        String originalFilename = secondLPath+file.getOriginalFilename();
        String savePath = BASE_DIR + FIRST_LEVEL_DIR + SEPARATOR;
        String resultPath = savePath + originalFilename;
        File originFile = new File(resultPath);
        if (!originFile.getParentFile().exists()) {
            originFile.getParentFile().mkdirs();
        }
       file.transferTo(originFile);

        return resultPath;
    }


}
