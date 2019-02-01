package com.jc.rest.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.restdocs.request.RequestParametersSnippet;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.jc.data.entity.Customer;
import com.jc.data.repository.CustomerRepository;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@WebMvcTest(CustomerRestController.class)
@AutoConfigureRestDocs(outputDir = "target/snippets")
public class CustomerRestControllerTest {
	
	@Autowired
    private MockMvc mockMvc;
	
	@MockBean
	private CustomerRepository customerRepository;
	
	@Before
	public void setUp() {
		List<Customer> customers = new ArrayList<Customer>();
		customers.add(new Customer(1L, "John", "Snow"));
		customers.add(new Customer(2L, "Aria", "Stark"));
		Mockito.when(customerRepository.findAll()).thenReturn(customers);
		Mockito.when(customerRepository.getOne(1L)).thenReturn(customers.get(0));
	}
	
	@Test
    public void getListOfCustomers() throws Exception {
        this.mockMvc.perform(
        		get("/api/customer")
	        	.contentType(MediaType.APPLICATION_JSON)
        	).andDo(print())
        	.andExpect(status().isOk())
        	.andDo(document("customer",
        			responseFields(
	        			fieldWithPath("[]id").description("Id of the customer"),
	        			fieldWithPath("[]firstName").description("First name of the customer"),
	        			fieldWithPath("[]lastName").description("Last name of the customer")
        			))
        	);
    }
	

	@Test
    public void getListOneCustomer() throws Exception {
        this.mockMvc.perform(
        		get("/api/customer/{id}", "1")
	        	.contentType(MediaType.APPLICATION_JSON)
        	).andDo(print())
        	.andExpect(status().isOk())
        	.andDo(document("customer",
        			responseFields(
	        			fieldWithPath("id").description("Id of the customer"),
	        			fieldWithPath("firstName").description("First name of the customer"),
	        			fieldWithPath("lastName").description("Last name of the customer")
        			))
        	);
    }
}
