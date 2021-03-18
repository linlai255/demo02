package com.cll.admin.controller;

import com.cll.admin.pojo.MyCategory;
import com.cll.admin.pojo.MyProduct;
import com.cll.admin.pojo.MySku;
import com.cll.admin.pojo.Page;
import com.cll.admin.services.TProductService;
import com.cll.admin.vo.AddProduct;
import com.cll.admin.vo.Lists;
import com.cll.admin.vo.VoProductDetail;
import com.cll.common.CommonResult;
import com.cll.mbg.model.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@Controller
@Api(value = "商品管理")
@RequestMapping("/product")
public class ProductController {
    @Autowired
    TProductService tProductService;
    @RequestMapping(value = "/addProduct",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "添加商品", notes = "标题->title, 销量->sales, 主图->mainPic, 原价->originalPrice, 单独购买价格->separatePrice, " +
            "拼团价格->groupPrice, " +
            "            是否上架：0-不上架 1-上架->racking, 分类外键->cateId, 商品服务，\n" +
            "            引用t_service中的serv_id，中间以逗号隔开->services, 详情->detail")
    public CommonResult addProduct(@RequestBody AddProduct addProduct,
                                   @RequestParam(required = false) String url){
        int code = tProductService.addProduct(addProduct,url);
        if (code == 0){
            return CommonResult.failed("网络异常");
        }
        return CommonResult.success("添加成功");
    }
    /**
     * 根据条件分页获取商品
     * @param title
     * @param cateId
     * @param racking
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "商品搜索")
    public CommonResult<Page> search(@ApiParam(name = "商品名称") @RequestParam (defaultValue = "", required = false)String title,
                                     @ApiParam(name = "商品种类")@RequestParam (defaultValue = "0",required = false)Integer cateId,
                                     @ApiParam(name = "商品是否上架")@RequestParam (defaultValue = "-1",required = false)Integer racking,
                                     @ApiParam(name = "第几页")@RequestParam(defaultValue = "1" , required = false) Integer pageNum,
                                     @ApiParam(name = "每页大小")@RequestParam(defaultValue = "5" , required = false) Integer pageSize){
        Page page = tProductService.search(title , cateId , racking , pageNum , pageSize);
        return CommonResult.success("查询成功",page);
    }

    /**
     * 获取商品 详情
     * @param
     * @return
     */
    @RequestMapping(value = "/productDetail" , method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "商品详情")
    public CommonResult<VoProductDetail> ProductDerail(@RequestParam (required=true)Integer id){
        VoProductDetail product = tProductService.productDerail(id);
        if (product != null){
            return CommonResult.success("执行成功",product);
        }
        else return CommonResult.failed("执行失败");
    }
    @RequestMapping(value = "/getProductParams" , method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "商品参数")
    public CommonResult<List<String>> getProductParams(@RequestParam (required=true)Integer prodId){
        List<String> re = tProductService.getProductParams(prodId);
        if (re == null){return CommonResult.failed("商品不存在");}
        else return CommonResult.success("成功",re);
    }
    @RequestMapping(value = "/getProductQA" , method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "商品答疑信息")
    public CommonResult<List<TProductQuestion>> getProductQA(@RequestParam (required=true)Integer prodId,
                                                             @RequestParam( required = false ,defaultValue = "10") int size){
        List<TProductQuestion> list = tProductService.getProductQA(prodId,size);
        if (list == null)return CommonResult.failed("用户不存在");
        else return CommonResult.success("成功",list);
    }
    /**
     * 根据id删除商品
     * @param prodId
     * @return
     */
    @RequestMapping(value = "/deleteProduct" , method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "删除商品")
    public CommonResult deleteProduct(@ApiParam(name = "商品id" ,value = "prodId") @RequestParam (defaultValue = "", required = true)int prodId){
        Integer flag = tProductService.deleteProduct(prodId);
        if (flag == 0){
            return CommonResult.failed("商品获取失败");
        }
        if (flag == 2){
            return CommonResult.failed("系统异常");
        }
        return CommonResult.success("删除成功");
    }

    /**
     * 更新商品
     * @param prodId
     * @param title
     * @param cateId
     * @param originalPrice
     * @param separatePrice
     * @param groupPrice
     * @param racking
     * @return
     */
    @RequestMapping(value = "/updateProduct" , method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "更新商品")
    public CommonResult updateProduct(@ApiParam(name = "商品id") @RequestParam int prodId,
                                      @ApiParam(name = "商品名称")@RequestParam String title,
                                      @ApiParam(name = "商品分类")@RequestParam Integer cateId,
                                      @ApiParam(name = "商品原价")@RequestParam BigDecimal originalPrice,
                                      @ApiParam(name = "商品单独购买价格")@RequestParam(required = false , defaultValue = "") BigDecimal separatePrice,
                                      @ApiParam(name = "商品拼团价格")@RequestParam(required = false , defaultValue = "") BigDecimal groupPrice,
                                      @ApiParam(name = "商品是否上架：0-不上架 1-上架")@RequestParam Integer racking){
        Integer flag = tProductService.updateProduct(prodId,title,cateId,originalPrice,separatePrice,groupPrice,racking);
        if (flag == 0){
            return CommonResult.failed("商品获取失败");
        }
        if (flag == 2){
            return CommonResult.failed("系统异常");
        }
        return CommonResult.success("更新成功");
    }

    /**
     * 分类搜索
     * @param cateName
     * @return
     */
    @RequestMapping(value = "/categorySearch" , method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "根据关键字获取分类")
    public CommonResult<List<MyCategory> >categorySearch(String cateName){
        List<MyCategory> lists = tProductService.categorySearch(cateName);
        return CommonResult.success("成功",lists);
    }

    /**
     * 添加商品种类子类
     * @param pCateId
     * @param cateName
     * @return
     */
    @RequestMapping(value = "/addSubclass" , method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "添加分类")
    public CommonResult addSubclass(@ApiParam(value = "外键id", required = false)@RequestParam(required = false) Integer pCateId,
                                    @ApiParam(value = "分类名称" , required = true)@RequestParam(required = true) String cateName,
                                    @ApiParam(value = "分类等级", required = true)@RequestParam(required = true) Integer cateLevel){
        int code = tProductService.addSubclass(pCateId, cateName,cateLevel);
        if (code == 1){
           return CommonResult.success("添加成功");
        }
        else return CommonResult.failed("网络异常，请重试");
     }
@RequestMapping(value = "/updateCategory" , method = RequestMethod.POST)
@ResponseBody
@ApiOperation(value = "更新分类名称   ")
     public CommonResult updateCategory(@ApiParam(required = true,value = "修改的名称")@RequestParam String cateName,
                                        @ApiParam(required = true,value = "分类的id")@RequestParam Integer cateId){
        int code = tProductService.updateCategory(cateName , cateId);
         if (code == 1){
             return CommonResult.success("修改成功");
         }
         else return CommonResult.failed("网络异常，请重试");
     }

}
