package com.jc.rest.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.restdocs.request.RequestParametersSnippet;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.jc.jms.service.EmailSenderService;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.request.RequestDocumentation.requestParameters;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.payload.PayloadDocumentation.requestFields;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(JmsRestController.class)
@AutoConfigureRestDocs(outputDir = "target/snippets")
public class JmsRestControllerTest {
	
	@Autowired
    private MockMvc mockMvc;
	
	@MockBean
	private EmailSenderService emailSenderService;
	
	@Test
    public void greetingShouldReturnMessageFromService() throws Exception {
        this.mockMvc.perform(
        	post("/api/jms")
	        	.contentType(MediaType.APPLICATION_JSON)
	        	.content("{\"to\": \"mail@example.com\",\"body\":\"Some content\"}")
        	).andDo(print())
        	.andExpect(status().isOk())
        	.andDo(document("greeting",
        			requestFields(
    	        			fieldWithPath("to").description("Recipent of the mail"),
    	        			fieldWithPath("body").description("Body of the mail")
        			),
        			responseFields(
	        			fieldWithPath("to").description("Recipent of the mail"),
	        			fieldWithPath("body").description("Body of the mail")
        			))
        	);
    }
}
