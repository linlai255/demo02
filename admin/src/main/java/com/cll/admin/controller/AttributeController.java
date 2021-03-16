package com.cll.admin.controller;

import com.cll.admin.pojo.MyAttribute;
import com.cll.admin.services.AttributeService;
import com.cll.common.CommonResult;
import com.cll.mbg.model.TProductAttribute;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/attribute")
@Api(value = "商品属性管理")
public class AttributeController {
    @Autowired
    AttributeService attributeService;
    @RequestMapping(value = "/getAttributeByCategory" , method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "根据分类获取属性")
    public CommonResult<List<TProductAttribute>> getAttributeByCategory(@ApiParam(name = "属性id") @RequestParam Integer cateId){
            List<TProductAttribute> list = attributeService.getAttributeByCategory(cateId);
            if (list == null){
                return CommonResult.failed("当前分类下没有属性，请添加");
            }
            return CommonResult.success("获取成功",list);

    }
    @RequestMapping(value = "/addAttribute",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "添加属性" ,notes = " 属性名称:attrName," +
            "                                 属性输入类型：0->输入框；1->单选；2->多选:inputType," +
            "                                 可选值列表，以逗号隔开:valueList," +
            "                                 是否支持手动新增；0->不支持；1->支持:manuallyAdd," +
            "                                 属性的类型；0->规格；1->参数:attrType")
    public CommonResult addAttribute(@RequestBody MyAttribute myAttribute){
        int code = attributeService.addAttribute(myAttribute);
        if (code == 0){
            return CommonResult.failed("网络异常");
        }
        return CommonResult.success("添加成功");
    }
    @RequestMapping(value = "/updateAttribute",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "更新属性" ,notes = " 属性id:attrId , 属性名称:attrName," +
            "                                 属性输入类型：0->输入框；1->单选；2->多选:inputType," +
            "                                 可选值列表，以逗号隔开:valueList," +
            "                                 是否支持手动新增；0->不支持；1->支持:manuallyAdd," +
            "                                 属性的类型；0->规格；1->参数:attrType")
    public CommonResult updateAttribute(@RequestBody TProductAttribute tProductAttribute){
        int code = attributeService.updateAttribute(tProductAttribute);
        if (code == 0){
            return CommonResult.failed("网络异常");
        }
        return CommonResult.success("更新成功");
    }
}
