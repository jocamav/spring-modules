package com.jc.controller;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(SecuredPageController.class)
@WithMockUser
public class SecuredPageControllerTest {
	
	@Autowired
    private MockMvc mockMvc;
	
	@Test
    public void shouldReturnJmsPage() throws Exception {
        this.mockMvc.perform(get("/secured")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("This is a protected area")));
    }
}
