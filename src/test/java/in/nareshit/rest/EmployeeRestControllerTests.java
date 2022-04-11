package in.nareshit.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import in.nareshit.entity.Employee;
import in.nareshit.service.IEmployeeService;
import lombok.extern.slf4j.Slf4j;

@WebMvcTest(value = EmployeeRestController.class)
@Slf4j
public class EmployeeRestControllerTests {

	@MockBean
	private IEmployeeService service;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void getSalaryTest() throws Exception {
		when(service.getSalary(1)).thenReturn("Dummy");
		int status = mockMvc.perform(MockMvcRequestBuilders.get("/employee/salary/1")).andReturn().getResponse()
				.getStatus();
		assertEquals(200, status);
	}

	@Test
	public void saveEmployeeTest() throws Exception {
		log.info("saveEmployeeTest method in EmployeeRestControllerTests class started");
		when(service.saveEmployee(ArgumentMatchers.any())).thenReturn(1l);
		String empJSON = new ObjectMapper().writeValueAsString(new Employee());
		int status = mockMvc.perform(
				MockMvcRequestBuilders.post("/employee").content(empJSON).contentType(MediaType.APPLICATION_JSON))
				.andReturn().getResponse().getStatus();
		assertEquals(200, status);
		log.info("saveEmployeeTest method in EmployeeRestControllerTests class ended");

	}

}
