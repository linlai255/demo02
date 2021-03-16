package com.cll.admin.services.impl;

import com.cll.admin.mapper.ProductCategoryDao;
import com.cll.admin.mapper.ProductDao;
import com.cll.admin.mapper.ProductSkuDao;
import com.cll.admin.pojo.*;
import com.cll.admin.services.TProductService;
import com.cll.admin.utils.MyTOProductUtil;
import com.cll.admin.vo.AddProduct;
import com.cll.admin.vo.VoProductDetail;
import com.cll.mbg.mapper.TProductCategoryMapper;
import com.cll.mbg.mapper.TProductImgMapper;
import com.cll.mbg.mapper.TProductMapper;
import com.cll.mbg.mapper.TProductSkuMapper;
import com.cll.mbg.model.*;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class TProductServiceImpl implements TProductService {
    @Autowired
    ProductDao productDao;
    @Autowired
    TProductMapper tProductMapper;
    @Autowired
    TProductCategoryMapper tProductCategoryMapper;
    @Autowired
    ProductCategoryDao productCategoryDao;
    @Autowired
    TProductImgMapper tProductImgMapper;
    @Autowired
    TProductSkuMapper tProductSkuMapper;
    @Autowired
    ProductSkuDao productSkuDao;
    @Override
    public Page search(String title, Integer cateId, Integer racking, Integer pageNum, Integer pageSize) {
        Page page = new Page();
        page.setPageNum(pageNum);
        page.setPageSize(pageSize);
        TProductExample example = new TProductExample();
        TProductExample.Criteria criteria = example.createCriteria();
        criteria.andIsDeleteEqualTo("0");
        if (title != "" && title != null){
            criteria.andTitleLike(title);
        }
        if (cateId != null && cateId != 0) {
            criteria.andCateIdEqualTo(cateId);
        }
        if (racking != null && racking != -1){
            criteria.andRackingEqualTo(racking);
        }
        page.setTotal(productDao.countByConditions(title, cateId, racking));
        page.setTotalPages((int) Math.ceil((page.getTotal()*1.0)/page.getPageSize()));
        PageHelper.startPage(pageNum,pageSize);
        List<ProductAndCategory> list = productDao.search(title, cateId, racking);
        page.setProductList(list);
        return page;
    }

    @Override
    public VoProductDetail productDerail(Integer prodId) {
        ProductDetail productDetail = productDao.getProductDetail(prodId);
        TProductImgExample example = new TProductImgExample();
        example.createCriteria().andProdIdEqualTo(prodId).andIsDeleteEqualTo(0);
        List<TProductImg> imgs = tProductImgMapper.selectByExample(example);
        List<SkuDetail> skuDetails = productSkuDao.skuDetail(prodId);
        VoProductDetail voProductDetail = new VoProductDetail();
        voProductDetail.setProductDetail(productDetail);
        voProductDetail.setImgs(imgs);
        voProductDetail.setSkuDetail(skuDetails);
        return voProductDetail;
    }

    @Override
    public Integer deleteProduct(int prodId) {

        try {
            TProduct product = tProductMapper.selectByPrimaryKey(prodId);
            product.setIsDelete("1");
            Integer i = tProductMapper.updateByPrimaryKey(product);
        }
       catch (NullPointerException e){
            return 0;
       }
        catch (Exception e){
            return 2;
        }
        return 1;
    }

    @Override
    public Integer updateProduct(int prodId, String title, Integer cateId, BigDecimal originalPrice, BigDecimal separatePrice, BigDecimal groupPrice, Integer racking) {

        try {
            TProduct product = tProductMapper.selectByPrimaryKey(prodId);
            product.setTitle(title);
            product.setCateId(cateId);
            product.setOriginalPrice(originalPrice);
            product.setSeparatePrice(separatePrice);
            product.setGroupPrice(groupPrice);
            product.setRacking(racking);
            Integer i = tProductMapper.updateByPrimaryKey(product);
        }
        catch (NullPointerException e){
            return 0;
        }
        catch (Exception e){
            return 2;
        }
        return 1;
    }

    @Override
    public List<TProductCategory> categorySearch(String cateName) {
        List<TProductCategory> list = productCategoryDao.getCategory(cateName);
        if(cateName == null){
            return list;
        }
        int maxLevel = 10;
        List<Integer> list1 = new ArrayList<>();
        List<TProductCategory> list2 = new ArrayList<>();
        for (TProductCategory t :list){
            if (t.getCateLevel() == maxLevel){
                list1.add(t.getpCateId());
                list2.add(t);
            }
            if (t.getCateLevel() <maxLevel){
                maxLevel = t.getCateLevel();
                list1.clear();
                list2.clear();
                list1.add(t.getCateId());
                list2.add(t);
            }

        }
        if (maxLevel == -1){
            return null;
        }
       List<TProductCategory> result = new ArrayList<>();
        if (maxLevel == 1){
            result.addAll(list2);
            for (int i = 0; i < list1.size() ; i++) {
                List<TProductCategory> categoryBypId = productCategoryDao.getCategoryBypId(list1.get(i));
                result.addAll(categoryBypId);
                int size = categoryBypId.size();
                for (int j = 0; j < size; j++) {
                    List<TProductCategory> categoryBypId1 = productCategoryDao.getCategoryBypId(categoryBypId.get(0).getCateId());
                    categoryBypId.remove(0);
                    result.addAll(categoryBypId1);
                }
            }
            return result;
        }
        if (maxLevel == 2){
            result.addAll(list2);
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < list1.size(); i++) {
                List<TProductCategory> categoryBypId = productCategoryDao.getCategoryBypId(list1.get(i));
                result.addAll(categoryBypId);
                if (temp.size() == 0){
                    temp.add( list2.get(i).getpCateId());
                }
                if (!temp.contains(list2.get(i).getpCateId()) && temp.size() != 0 ){
                    temp.add(list2.get(i).getpCateId());
                }
            }
            for (int i = 0; i < temp.size(); i++) {
                TProductCategory tProductCategory = tProductCategoryMapper.selectByPrimaryKey(temp.get(i));
                result.add(tProductCategory);
            }
            return result;
        }
        if (maxLevel == 3){
            result.addAll(list2);
            List<Integer> temp = new ArrayList<>();
            List<Integer> temp1 = new ArrayList<>();
            for (int i = 0; i < list1.size(); i++) {
                if (temp.size() == 0){
                    temp.add( list2.get(i).getpCateId());
                }
                if (!temp.contains(list2.get(i).getpCateId()) && temp.size() != 0 ){
                    temp.add(list2.get(i).getpCateId());
                }
            }
            for (int i = 0; i < temp.size(); i++) {
                TProductCategory tProductCategory = tProductCategoryMapper.selectByPrimaryKey(temp.get(i));
                if (temp1.size() == 0){
                    temp1.add(tProductCategory.getpCateId());
                }
                if (!temp1.contains(tProductCategory.getpCateId())&& temp1.size() != 0){
                    temp1.add(tProductCategory.getpCateId());
                }
                result.add(tProductCategory);
            }
            for (int i = 0; i < temp1.size(); i++) {
                TProductCategory tProductCategory = tProductCategoryMapper.selectByPrimaryKey(temp1.get(i));
                result.add(tProductCategory);
            }
            return result;
        }
        return list;
    }

    @Override
    public int addSubclass(Integer pCateId, String cateName, Integer cateLevel) {
       TProductCategory tProductCategory = new TProductCategory();
       tProductCategory.setCateName(cateName);
       tProductCategory.setpCateId(pCateId);
       tProductCategory.setCateLevel(cateLevel);
        int insert = tProductCategoryMapper.insert(tProductCategory);
        return insert;
    }

    @Override
    public int updateCategory(String cateName ,Integer cateId) {
        TProductCategory tProductCategory = tProductCategoryMapper.selectByPrimaryKey(cateId);
        tProductCategory.setCateName(cateName);
        int i = tProductCategoryMapper.updateByPrimaryKey(tProductCategory);
        return i;
    }

    @Override
    public int addProduct(AddProduct addProduct, String url) {
        TProduct product = MyTOProductUtil.conversion(addProduct.getMyProduct());
        product.setIsDelete("0");
        int save = tProductMapper.save(product);
        Integer prodId = product.getProdId();
        List<MySku> mySku = addProduct.getMySku();
        int flag01 = mySku.size();
        int insert = 0;
        for (MySku sku : mySku){
            TProductSku sku1 = new TProductSku();
            sku1 = MyTOProductUtil.conversion(sku);
            sku1.setProdId(prodId);
            sku1.setSales(0);
            tProductSkuMapper.insert(sku1);
            insert++;
        }
        int flag = 0;
        int pic = 0;
        if (url != null){
            String substring = url.substring(0, url.length());
            String[] split = substring.split(",");
            for (String s : split){
                TProductImg tProductImg = new TProductImg();
                tProductImg.setProdId(prodId);
                tProductImg.setIsDelete(0);
                tProductImg.setPicUrl(s);
                tProductImgMapper.insert(tProductImg);
                flag++;
            }
            pic = split.length;
        }
       if (insert + flag + save == flag01 + pic + 1)
       {
           return 1;
       }
        return 0;
    }


}
