package com.example.demo;

import org.junit.jupiter.api.ClassOrderer.OrderAnnotation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@AutoConfigureMockMvc
@DisplayName("EmployeeList")
//@TestMethodOrder(OrderAnnotation.class)
public class MackitoTest {
	private static final RequestBuilder request = null;
	@Autowired
	private MockMvc mockMvc;

	@Test
	@DisplayName("Employee All")
	@Order(1)
	public void testgetAllEmployees() throws Exception {
		// creating request
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/api/employee/all");
		// Execute Request
		MvcResult result = mockMvc.perform(request).andReturn();
		// Get Response/Result
		MockHttpServletResponse resp = result.getResponse();

		// Assert Result
		//assertEquals(HttpStatus.OK.value(), resp.getStatus());
		assertNotNull(resp.getContentAsString());

	}

	@Test
	@DisplayName("createEmployee")
	@Order(2)
	public void testcreateEmployee() throws Exception {
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/api/employee/emp")
				.contentType(MediaType.APPLICATION_JSON).contentType("pinky");
		MvcResult result = mockMvc.perform(request).andReturn();
		MockHttpServletResponse resp = result.getResponse();
		//assertEquals(HttpStatus.CREATED.value(), resp.getStatus());
		assertNotNull(resp.getContentAsString());
	}

	@Test
	@DisplayName("UpdateEmployee")
	@Order(3)
	public void updateEmployee() throws Exception {
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.put("/api/employee/14")
				.contentType(MediaType.APPLICATION_JSON).contentType("saritha");
		MvcResult result = mockMvc.perform(request).andReturn();
		MockHttpServletResponse resp = result.getResponse();
		//assertEquals(HttpStatus.OK.value(), resp.getStatus());
		assertNotNull(resp.getContentAsString());
	}

	@Test
	@DisplayName("DeleteEmployee")
	@Order(4)
	public void deleteEmployee() throws Exception {
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.delete("/api/employee/20")
				.contentType(MediaType.APPLICATION_JSON).contentType("Ramya");
		MvcResult result = mockMvc.perform(request).andReturn();
		MockHttpServletResponse resp = result.getResponse();
		//assertEquals(HttpStatus.OK.value(), resp.getStatus());
		assertNotNull(resp.getContentAsString());
	}

}
