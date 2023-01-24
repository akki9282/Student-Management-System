package StudentManagement.admin.model;

import javax.validation.constraints.Size;

//save login deatils in here >>login id or username and password
public class User {
	@Size(min = 1, message = "Student name can't be empty")
private String Uname;
private String pass;
public String getUname() {
	return Uname;
}
public void setUname(String uname) {
	Uname = uname;
}
public String getPass() {
	return pass;
}
public void setPass(String pass) {
	this.pass = pass;
}


}
