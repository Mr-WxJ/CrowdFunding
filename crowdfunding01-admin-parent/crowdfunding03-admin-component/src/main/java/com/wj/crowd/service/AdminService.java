package com.wj.crowd.service;

import com.github.pagehelper.PageInfo;
import com.wj.crowd.entity.Admin;

import java.util.List;

/**
 * @author wj
 * @create 2022-10-15 18:35
 */
public interface AdminService {
    public void saveAdmin(Admin admin);

    List<Admin> getAll();

    Admin getAdminByLoginAcct(String loginAcct, String userPswd);

    PageInfo<Admin> getPageInfo(String keyword, Integer pageNum, Integer pageSize);

    void remove(Integer adminId);

    Admin getAdminById(Integer adminId);

    void update(Admin admin);
}