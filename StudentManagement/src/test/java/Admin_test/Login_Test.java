package Admin_test;

import static org.junit.Assert.assertEquals;

import javax.servlet.ServletContext;

import org.eclipse.jdt.internal.compiler.batch.FileSystem.Classpath;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import StudentManagement.admin.controller.loginController;
import StudentManagement.admin.dao.Admin_dao;
import StudentManagement.admin.model.User;
import base_test_config.BaseTest;

public class Login_Test extends BaseTest {

	@Autowired
	Admin_dao admin_dao;

	@Test
	public void test1() {

		assertEquals(1, admin_dao.validate("test@123", "12345678"));

	}

	@Test
	public void test2() {

		assertEquals(1, admin_dao.validate("102", "1234"));

	}

	@Test
	public void test3() {

		assertEquals(0, admin_dao.validate("test@123", "12345"));

	}

	@Test
	public void test4() {
		
		assertEquals(0, admin_dao.validate("test@123", null));

	}

	@Test
	public void test5() {

		assertEquals(0, admin_dao.validate(null, "12345678"));

	}

	@Test
	public void test6() {

		assertEquals(0, admin_dao.validate(null, null));

	}

	@Test
	public void test7() {

		assertEquals(0, admin_dao.validate("", ""));

	}
}
