package StudentManagement.student.dao;

import java.io.File;
import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import StudentManagement.admin.controller.loginController;
import StudentManagement.student.model.AddStudent;
import StudentManagement.student.model.Student;

@Repository
public class StudentDao {
	@Autowired
	public Student student;

	Configuration con = new Configuration();
	
	//fetching all details from databse
	public List<Object[]> allInTable(){
		System.out.println("in table");
		con.addAnnotatedClass(Student.class);
		con.configure();
		System.out.println("out");
		SessionFactory sessionFactory = con.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		
		NativeQuery q=session.createSQLQuery("select * from Student;");
		List<Object[]> list = q.list();
		
		session.close();
		return list;
		
	}
	
	//add student in database
	public int addStudent(AddStudent addStudent, String userName) {
		String s=String.valueOf(addStudent.getSid());
		if(addStudent.getSname()==null || addStudent.getSdept()==null || s==null || userName==null
				|| addStudent.getSname()=="" || addStudent.getSdept()=="" || s=="" || userName=="")
		{
			return 0;
		}
		
		con.addAnnotatedClass(Student.class);
		con.configure();
		SessionFactory sessionFactory = con.buildSessionFactory();
		System.out.println("inside addstudent dao");
		
		Session session = sessionFactory.openSession();
		System.out.println("pass");
//		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		student.setStudent_Name(addStudent.getSname());
		student.setDepartment(addStudent.getSdept());
		student.setStudent_ID(addStudent.getSid());

		int a = 0;
		try {
			a = Integer.parseInt(userName);
		} catch (Exception e) {
		}
		if (a != 0) {
			student.setAdmin_ID(a);
		} else {

			NativeQuery q = session.createSQLQuery("select * from Admin where Uname='" + userName + "';");
			List<Object[]> list = q.list();

			for (Object[] object : list) {
				System.out.println(object[0]);
				a = (Integer) object[0];
			}
			student.setAdmin_ID(a);

		}
		try {
			session.save(student);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			return 0;

		}finally {
			session.close();
			sessionFactory.close();
		}

		
		return 1;
	}

	
	//update student details in database
	public int updateStudent(AddStudent addStudent, String userName)
	{ String s=String.valueOf(addStudent.getSid());
		if(addStudent.getSname()==null || addStudent.getSdept()==null || s==null || userName==null ||
				addStudent.getSname()=="" || addStudent.getSdept()=="" || s=="" || userName=="")
		{
			return 0;
		}
		con.addAnnotatedClass(StudentManagement.student.model.Student.class);
		con.configure();
		SessionFactory sessionFactory = con.buildSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		student.setStudent_Name(addStudent.getSname());
		student.setDepartment(addStudent.getSdept());
		student.setStudent_ID(addStudent.getSid());

		int a = 0;
		try {
			a = Integer.parseInt(userName);
		} catch (Exception e) {
		}
		if (a != 0) {
			student.setAdmin_ID(a);
		} else {

			NativeQuery q = session.createSQLQuery("select * from Admin where Uname='" + userName + "';");
			List<Object[]> list = q.list();

			for (Object[] object : list) {
				System.out.println(object[0]);
				a = (Integer) object[0];
			}
			student.setAdmin_ID(a);
			

		}
		
		try {
			session.update(student);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			return 0;

		}finally {
			session.close();
			sessionFactory.close();
		}
		return 1;

	}
	
	//delete student fron database
	public int deleteStudent(int sId)
	{String s=String.valueOf(sId);
		if(s==null)
		{
			return 0;
		}
		con.addAnnotatedClass(StudentManagement.student.model.Student.class);
		con.configure();
		SessionFactory sessionFactory = con.buildSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		NativeQuery q=session.createSQLQuery("delete from Student where Student_ID='"+sId+"';");
		int i = q.executeUpdate();
		if(i<=0)
		{
			return 0;
		}
		session.close();
		sessionFactory.close();
		return 1;
	}

}
