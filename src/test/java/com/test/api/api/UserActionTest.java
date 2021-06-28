package com.test.api.api;

import com.test.api.api.bean.TblUser;
import com.test.api.api.utils.JsonUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * @projectName api
 * @package com.test.api.api
 * @className UserActionTest
 * @description 用户管理接口测试类
 * @auther wangsheng
 * @creatTime 2021/6/28 1:30 上午
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
@SpringBootTest
@AutoConfigureMockMvc
public class UserActionTest {

    @Autowired
    private MockMvc mockMvc;

    @BeforeAll
    public void loginIn() throws Exception {
        TblUser u = new TblUser();
        u.setId("666666");
        u.setPass("123456");
        String data = JsonUtils.objectToJson(u);
        mockMvc.perform(MockMvcRequestBuilders.post("/login")
                .accept(MediaType.APPLICATION_JSON)
                .content(data))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())

                .andReturn();
    }

    @Test
    public void getHello() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/testAppException").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

}
