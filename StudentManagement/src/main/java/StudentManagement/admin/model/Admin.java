package StudentManagement.admin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Size;

//admin table

@Entity
public class Admin {
	@Id
	private int Admin_ID;
	
	private String Uname;
	private String College;
	private String pass;

	public int getAdmin_ID() {
		return Admin_ID;
	}

	public void setAdmin_ID(int admin_ID) {
		Admin_ID = admin_ID;
	}

	public String getUname() {
		return Uname;
	}

	public void setUname(String uname) {
		Uname = uname;
	}

	public String getCollege() {
		return College;
	}

	public void setCollege(String college) {
		College = college;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(int admin_ID, String uname, String college, String pass) {
		super();
		Admin_ID = admin_ID;
		Uname = uname;
		College = college;
		this.pass = pass;
	}

}
