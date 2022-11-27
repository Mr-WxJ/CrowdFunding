package com.wj.crowd.mvc.controller;

import com.github.pagehelper.PageInfo;
import com.mysql.cj.Session;
import com.wj.crowd.constant.CrowdConstant;
import com.wj.crowd.entity.Admin;
import com.wj.crowd.service.AdminService;
import com.wj.crowd.util.CrowdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Objects;

/**
 * @author wj
 * @create 2022-11-21 16:06
 */
@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("/admin/update.html")
    public String update(Admin admin, @RequestParam("pageNum") Integer pageNum, @RequestParam("keyword") String keyword) {

        adminService.update(admin);

        return "redirect:/admin/get/page.html?pageNum="+pageNum+"&keyword="+keyword;
    }

    @RequestMapping("/admin/edit/page.html")
    public String toEditPage(@RequestParam("adminId") Integer adminId, Model model) {
        // 1.根据 id（主键）查询待更新的 Admin 对象
        Admin admin = adminService.getAdminById(adminId);

        // 2.将 Admin 对象存入模型
        model.addAttribute("admin", admin);

        return "admin-edit";
    }

    @RequestMapping("/admin/save.html")
    public String save(Admin admin) {
        adminService.saveAdmin(admin);
        return "redirect:/admin/get/page.html?pageNum="+Integer.MAX_VALUE;
    }

    @RequestMapping("/admin/remove/{adminId}/{pageNum}/{keyword}.html")
    public String remove(
            @PathVariable("adminId") Integer adminId,
            @PathVariable("pageNum") Integer pageNum,
            @PathVariable("keyword") String keyword
    ) {
        // 执行删除
        adminService.remove(adminId);
        if (Objects.equals(keyword, "")){
            return "redirect:/admin/get/page.html?pageNum=" + pageNum;
        }
        return "redirect:/admin/get/page.html?pageNum=" + pageNum + "&keyword=" + keyword;
    }

    @RequestMapping("/admin/get/page.html")
    public String getAdminPage(
            @RequestParam(value="keyword", defaultValue="") String keyword,
            @RequestParam(value="pageNum", defaultValue="1") Integer pageNum,
            @RequestParam(value="pageSize", defaultValue="5") Integer pageSize,
            Model model
    ) {
        // 查询得到分页数据
        PageInfo<Admin> pageInfo = adminService.getPageInfo(keyword, pageNum, pageSize);
        // 将分页数据存入模型
        model.addAttribute(CrowdConstant.ATTR_NAME_PAGE_INFO, pageInfo);

        return "admin-page";
    }

    @RequestMapping("/admin/do/logout.html")
    public String doLogout(HttpSession session){

        // 强制session失效
        session.invalidate();

        return "redirect:/admin/login/page.html";
    }
    @RequestMapping("/admin/do/login.html")
    public String doLogin(@RequestParam("loginAcct") String loginAcct,
                          @RequestParam("userPswd") String userPswd,
                          HttpSession session){

        // 调用service 方法登录检查
        Admin admin = adminService.getAdminByLoginAcct(loginAcct, userPswd);

        // 将登录成功的admin 存入session 作用域
        session.setAttribute(CrowdConstant.ATTR_NAME_LOGIN_ADMIN,admin);
        return "redirect:/admin/main/page.html";
    }
}
