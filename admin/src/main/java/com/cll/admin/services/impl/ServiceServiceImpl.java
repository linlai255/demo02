package com.cll.admin.services.impl;

import com.cll.admin.services.ServiceService;
import com.cll.mbg.mapper.TServiceMapper;
import com.cll.mbg.model.TService;
import com.cll.mbg.model.TServiceExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceServiceImpl implements ServiceService {
    @Autowired
    TServiceMapper tServiceMapper;
    @Override
    public List<TService> getService() {
        List<TService> list = tServiceMapper.selectByExample(new TServiceExample());
        return list;
    }
}
