package Student_test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import StudentManagement.student.dao.StudentDao;
import StudentManagement.student.model.AddStudent;
import base_test_config.BaseTest;

public class UpdateStudent_test extends BaseTest {

	@Autowired
	StudentDao sDao;
	@Autowired
	AddStudent addStudent;

	@Test
	public void test1() {
		addStudent.setSname("akash panari");
		addStudent.setSid(1);
		addStudent.setSdept("mechanical");

		int i = sDao.updateStudent(addStudent, "102");

		assertEquals(1, i);
	}

	@Test
	public void test2() {
		addStudent.setSname(null);
		addStudent.setSid(1);
		addStudent.setSdept("mechanical");

		int i = sDao.updateStudent(addStudent, "102");

		assertEquals(0, i);
	}
	
	@Test
	public void test3() {
		addStudent.setSname("");
		addStudent.setSid(1);
		addStudent.setSdept("mechanical");

		int i = sDao.updateStudent(addStudent, "102");

		assertEquals(0, i);
	}
}
