package com.jc.rest.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.restdocs.request.RequestParametersSnippet;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.request.RequestDocumentation.requestParameters;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(GreetingController.class)
@AutoConfigureRestDocs(outputDir = "target/snippets")
public class GreetingControllerTest {
	
	@Autowired
    private MockMvc mockMvc;
	
	@Test
    public void greetingShouldReturnMessageFromService() throws Exception {
        this.mockMvc.perform(get("/api/greeting").param("name", "John")).andDo(print())
        	.andExpect(status().isOk())
        	.andDo(document("greeting",
        			requestParameters(
        				parameterWithName("name").description("Name to say Hello")
        			),
        			responseFields(
	        			fieldWithPath("id").description("Id of the Greeting"),
	        			fieldWithPath("content").description("Content of the Greeting itself")
        			))
        	);
    }
}
