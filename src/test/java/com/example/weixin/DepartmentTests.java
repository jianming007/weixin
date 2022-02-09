package com.example.weixin;


import com.example.weixin.common.error.WxErrorException;
import com.example.weixin.config.WxCpAppConfigEnum;
import com.example.weixin.config.WxCpConfiguration;
import com.example.weixin.cp.api.WxCpDepartmentService;
import com.example.weixin.cp.api.WxCpService;
import com.example.weixin.cp.bean.WxCpDepart;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * 部门测试
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class DepartmentTests {

    @Autowired
    private WxCpConfiguration wxCpConfiguration;

    /**
     * 获取部门列表
     * @throws WxErrorException
     */
    @Test
    public void list() throws WxErrorException {
        WxCpService wxCpService = wxCpConfiguration.getCpService(WxCpAppConfigEnum.CONTACT);
        WxCpDepartmentService departmentService = wxCpService.getDepartmentService();
        List<WxCpDepart> list = departmentService.list(null);
        list.forEach(System.out::println);
    }

    /**
     * 获取部门详情
     * @throws WxErrorException
     */
    @Test
    public void get() throws WxErrorException {
        WxCpService wxCpService = wxCpConfiguration.getCpService(WxCpAppConfigEnum.CONTACT);
        WxCpDepartmentService departmentService = wxCpService.getDepartmentService();
        WxCpDepart wxCpDepart = departmentService.get(43L);
        System.out.println(wxCpDepart);
    }

}
