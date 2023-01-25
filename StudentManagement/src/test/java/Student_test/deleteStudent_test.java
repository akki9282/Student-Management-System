package Student_test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import StudentManagement.student.dao.StudentDao;
import base_test_config.BaseTest;

public class deleteStudent_test extends BaseTest{
@Autowired
	StudentDao sDao;
@Test
public void test1()
{
	int i = sDao.deleteStudent(1);
assertEquals(1, i);
}

@Test
public void test2()
{
	int i = sDao.deleteStudent(1);
assertEquals(0, i);
}

//@Test
//public void test3()
//{
//	int i = sDao.deleteStudent();
//assertEquals(0, i);
//}
}
