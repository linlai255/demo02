package com.cll.admin.controller;

import com.cll.admin.services.ServiceService;
import com.cll.common.CommonResult;
import com.cll.mbg.model.TService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/productService")
@Api(value = "商品服务管理")
public class ProductServiceController {
    @Autowired
    ServiceService serviceService;
    @RequestMapping(value = "/getService",method = RequestMethod.GET)
    @ApiOperation(value = "获取服务列表")
    public CommonResult<List<TService>> getService(){
        List<TService> list = serviceService.getService();
        if (list.isEmpty()){
            return CommonResult.failed("网络异常，请稍后充实");
        }
        return CommonResult.success("获取成功",list);
    }
}
