package com.wj.crowd.service.impl;

import com.wj.crowd.entity.Admin;
import com.wj.crowd.mapper.AdminMapper;
import com.wj.crowd.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wj
 * @create 2022-10-15 18:35
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminMapper adminMapper;

    @Override
    public void saveAdmin(Admin admin) {
        adminMapper.insert(admin);
    }

    @Override
    public List<Admin> getAll() {
        List<Admin> list = adminMapper.selectByExample(null);
        return list;

    }
}
