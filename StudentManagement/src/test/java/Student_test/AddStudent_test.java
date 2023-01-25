package Student_test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import StudentManagement.student.dao.StudentDao;
import StudentManagement.student.model.AddStudent;
import base_test_config.BaseTest;

public class AddStudent_test extends BaseTest {

	@Autowired
	StudentDao studentDao;
	@Autowired
	AddStudent addStudent;
	
	@Test
	public void test1()
	{		

		addStudent.setSname("akash panari");
		addStudent.setSdept("computer");
		addStudent.setSid(1);
		addStudent.setAddOrUpdate("add");
		
		int i = studentDao.addStudent(addStudent, "102");
		
		assertEquals(1, i);
		

	}
	
	@Test
	public void test2()
	{
		addStudent.setSname("akash panari");
		addStudent.setSdept("computer");
		addStudent.setSid(1);
		addStudent.setAddOrUpdate("add");
		
		int i = studentDao.addStudent(addStudent, "102");
		
		assertEquals(0, i);
	}
	
	@Test
	public void test3()
	{
		addStudent.setSname("akash panari");
		addStudent.setSdept(null);
		addStudent.setSid(1);
		addStudent.setAddOrUpdate("add");
		
		int i = studentDao.addStudent(addStudent, "102");
		
		assertEquals(0, i);
	}
	
	@Test
	public void test4()
	{
		addStudent.setSname("akash panari");
		addStudent.setSdept("");
		addStudent.setSid(2);
		addStudent.setAddOrUpdate("add");
		
		int i = studentDao.addStudent(addStudent, "102");
		
		assertEquals(0, i);
	}
	
	@Test
	public void test5()
	{
		addStudent.setSname("akash panari");
		addStudent.setSdept("computer");
		addStudent.setSid(1);
//		addStudent.setAddOrUpdate("add");
		
		int i = studentDao.addStudent(addStudent, "102");
		
		assertEquals(1, i);
	}
}
