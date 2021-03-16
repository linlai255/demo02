package com.cll.admin.services;

import com.cll.admin.pojo.MyAttribute;
import com.cll.mbg.model.TProductAttribute;

import java.util.List;

public interface AttributeService {

    List<TProductAttribute> getAttributeByCategory(Integer cateId);

    int addAttribute(MyAttribute myAttribute);

    int updateAttribute(TProductAttribute tProductAttribute);
}
