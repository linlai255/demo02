package com.cll.admin.services.impl;

import com.cll.admin.mapper.AttributeDao;
import com.cll.admin.pojo.MyAttribute;
import com.cll.admin.services.AttributeService;
import com.cll.admin.utils.MyTOProductUtil;
import com.cll.mbg.mapper.TProductAttributeMapper;
import com.cll.mbg.model.TProductAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttributeServiceImpl implements AttributeService {
    @Autowired
    AttributeDao attributeDao;
    @Autowired
    TProductAttributeMapper tProductAttributeMapper;
    @Override
    public List<TProductAttribute> getAttributeByCategory(Integer cateId) {
        List<TProductAttribute> list = attributeDao.getAttributeByCategory(cateId);
        return list;
    }

    @Override
    public int addAttribute(MyAttribute myAttribute) {
        int insert = 0;
        TProductAttribute tProductAttribute = MyTOProductUtil.conversion(myAttribute);
        insert = tProductAttributeMapper.insert(tProductAttribute);
        return insert;
    }

    @Override
    public int updateAttribute(TProductAttribute tProductAttribute) {
        int key = 0;
       key = tProductAttributeMapper.updateByPrimaryKey(tProductAttribute);
        return key;
    }
}
