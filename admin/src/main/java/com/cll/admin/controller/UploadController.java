package com.cll.admin.controller;

import com.cll.admin.utils.FileUtil;
import com.cll.common.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("/upload")
@Api(value = "文件管理")
public class UploadController {
    @RequestMapping(value = "/singleFile" , method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "单文件上传")
    public CommonResult singleFile(MultipartFile file){
        try {
            long size = file.getSize() / 1024;
            System.out.println("size = " + size);
            if(size >= 1024){ //图片限制小于1MB上传
                return CommonResult.failed("图片不能大于1MB");
            }
            String url = FileUtil.upload(file);
            return CommonResult.success(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return CommonResult.failed("上传出错");
    }
}
