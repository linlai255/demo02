package com.cll.admin.mapper;

import com.cll.admin.pojo.SkuDetail;

import java.util.List;

public interface ProductSkuDao {

    List<SkuDetail> skuDetail(Integer prodId);
}
