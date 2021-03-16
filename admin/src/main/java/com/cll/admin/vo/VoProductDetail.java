package com.cll.admin.vo;

import com.cll.admin.pojo.ProductDetail;
import com.cll.admin.pojo.SkuDetail;
import com.cll.mbg.model.TProductImg;

import java.util.List;

public class VoProductDetail {
    private ProductDetail productDetail;
    private List<SkuDetail> skuDetail;
    private List<TProductImg> imgs;


    @Override
    public String toString() {
        return "VoProductDetail{" +
                "productDetail=" + productDetail +
                ", skuDetail=" + skuDetail +
                ", imgs=" + imgs +
                '}';
    }

    public ProductDetail getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(ProductDetail productDetail) {
        this.productDetail = productDetail;
    }

    public List<SkuDetail> getSkuDetail() {
        return skuDetail;
    }

    public void setSkuDetail(List<SkuDetail> skuDetail) {
        this.skuDetail = skuDetail;
    }

    public List<TProductImg> getImgs() {
        return imgs;
    }

    public void setImgs(List<TProductImg> imgs) {
        this.imgs = imgs;
    }
}
