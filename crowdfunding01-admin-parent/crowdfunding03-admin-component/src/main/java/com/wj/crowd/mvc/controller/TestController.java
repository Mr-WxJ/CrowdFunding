package com.wj.crowd.mvc.controller;

import com.wj.crowd.entity.Admin;
import com.wj.crowd.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * @author wj
 * @create 2022-10-18 16:25
 */
@Controller
public class TestController {

    @Autowired
    AdminService adminService;

    private Logger logger = LoggerFactory.getLogger(TestController.class);

    @ResponseBody
    @RequestMapping("/send/array/three.html")
    public String testReceiveArrayThree(@RequestBody List<Integer> array) {

        for (Integer number : array) {
            logger.info("number="+number);
        }

        return "success";
    }

    @RequestMapping("/test/ssm.html")
    public String testSSM(Model model){
        //Admin admin = adminService.queryAdmin(1);
        List<Admin> adminList = adminService.getAll();
        model.addAttribute("adminList", adminList);
        return "target";
    }
}
