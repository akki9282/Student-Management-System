package StudentManagement.admin.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class Admin_dao {

	// admin details validate from getting data from database
	public int validate(String userV, String passV) {
		if(userV==null && passV==null)
		{
			return 0;
		}
		String user = userV;
		String pass = passV;
		int i = 0;
		try {
			i = Integer.parseInt(user);
		} catch (Exception e) {
		}
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();

		if (i > 0) {
			String query = "select * from Admin where Admin_Id=" + i + " and pass='" + pass + "';";
			NativeQuery q = session.createSQLQuery(query);
			List<Object[]> list = q.list();
			if (list.isEmpty()) {
				return 0;
			}
			return 1;
		}
		String query = "select * from Admin where Uname='" + user + "' and pass='" + pass + "';";
		NativeQuery q = session.createSQLQuery(query);
		List<Object[]> list = q.list();
		String s=null;
		for(Object[] obj:list)
		{
			s=(String) obj[1];
		}
		
		if(!list.isEmpty() && s.equals(user))
		{
		return 1;	
		}

		return 0;
	}

}
