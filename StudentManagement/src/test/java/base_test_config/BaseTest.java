package base_test_config;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import javax.servlet.ServletContext;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:StudentManagement-servlet-context.xml"})
@WebAppConfiguration
public class BaseTest {

	protected MockMvc mockMvc;
	
	@Autowired
	WebApplicationContext webApplicationContext;
	
	@Before
	public void setup()
	{
		MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();

	}
	
	@Test
	public void test() {
		ServletContext servletContext = webApplicationContext.getServletContext();

	}
	@Test
	public void login_Page_calling_test() throws Exception
	{
		mockMvc.perform(get("/login")).andExpect(status().isOk())
		.andExpect(view().name("login")).andExpect(forwardedUrl("/WEB-INF/views/login.jsp"));
	}
}
