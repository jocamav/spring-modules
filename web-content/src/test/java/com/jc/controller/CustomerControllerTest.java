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
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.jc.data.repository.CustomerRepository;

@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {
	
	@Autowired
    private MockMvc mockMvc;
	
	@MockBean
	private CustomerRepository customerRepository;
	
	@Test
    public void getMainPageWithCustomersViaAjax() throws Exception {
        this.mockMvc.perform(get("/customerajax")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("customer list response as JSON")));
    }
	
	@Test
    public void getMainPageWithCustomersInATable() throws Exception {
        this.mockMvc.perform(get("/customer")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("customer list in a Table")));
    }
}
