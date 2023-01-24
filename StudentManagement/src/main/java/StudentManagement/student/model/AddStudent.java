package StudentManagement.student.model;

import javax.validation.constraints.Size;

public class AddStudent {
	@Size(min = 1, message = "Student name can't be empty")
	private String Sname;
	private int Sid;
	@Size(min = 1, message = "Student dept can't be empty")
	private String Sdept;
	private String addOrUpdate;

	public String getAddOrUpdate() {
		return addOrUpdate;
	}

	public void setAddOrUpdate(String addOrUpdate) {
		this.addOrUpdate = addOrUpdate;
	}

	public String getSname() {
		return Sname;
	}

	public void setSname(String sname) {
		Sname = sname;
	}

	public int getSid() {
		return Sid;
	}

	public void setSid(int sid) {
		Sid = sid;
	}

	public String getSdept() {
		return Sdept;
	}

	public void setSdept(String sdept) {
		Sdept = sdept;
	}

}
