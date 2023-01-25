package Admin_test;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import org.junit.Test;

import base_test_config.BaseTest;

public class loginControllerTest extends BaseTest{

	@Test
	public void login_Page_calling_test() throws Exception
	{
		this.mockMvc.perform(get("/login"))
		.andExpect(view().name("login")).andExpect(forwardedUrl("/WEB-INF/views/login.jsp"));
	}
	

}
