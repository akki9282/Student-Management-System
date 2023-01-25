package Student_test;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import StudentManagement.student.dao.StudentDao;
import base_test_config.BaseTest;

public class GetAll_test extends BaseTest{

	@Autowired
	StudentDao sDao;
	
	@Test
	public void test1()
	{
		List<Object[]> list = sDao.allInTable();
		assertNotNull(list);
	}
}
