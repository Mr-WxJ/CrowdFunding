package com.wj.crowd.service;

import com.wj.crowd.entity.Admin;

import java.util.List;

/**
 * @author wj
 * @create 2022-10-15 18:35
 */
public interface AdminService {
    public void saveAdmin(Admin admin);

    List<Admin> getAll();
}
