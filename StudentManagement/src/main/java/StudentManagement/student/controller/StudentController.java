package StudentManagement.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import StudentManagement.admin.controller.loginController;
import StudentManagement.student.dao.StudentDao;
import StudentManagement.student.model.AddStudent;
import StudentManagement.student.model.Student;

@Controller
public class StudentController {
	@Autowired
	public StudentDao Sdao;
	@Autowired
	public loginController lc;

	//add or update student model
	@PostMapping(path = "/AddorUpdateStudent")
	public String addOrUpadeteStudent(@ModelAttribute AddStudent addStudent, Model model) {
		
		
		
		
		String un = lc.userName;
		System.out.println(un);
		String s = addStudent.getAddOrUpdate();
		
		//-----------For add student------------------
		if (s.equals("add")) {
			
			
			//validation for empty field
			String s1=String.valueOf(addStudent.getSid());
			
			if(addStudent.getSname()=="" || addStudent.getSdept()=="" || s1=="" || un=="")
			{
				model.addAttribute("msg", "missed some important field");
				model.addAttribute("addOrUpdate", "add");
				model.addAttribute("addUpdate","Add Student");
				return "addStudent";
			}
			//validation end
			
			
			int check = Sdao.addStudent(addStudent, un);
			if (check == 0) {
				model.addAttribute("msg", "ID already present in database");
				model.addAttribute("addOrUpdate", "add");
				model.addAttribute("addUpdate","Add Student");
				return "addStudent";
			}
			model.addAttribute("msg", "data save successfully");
			model.addAttribute("addOrUpdate", "add");
			model.addAttribute("addUpdate","Add Student");
			return "addStudent";
		}

		///-------------------for update student------------------
		
		//validation for empty field
		String s1=String.valueOf(addStudent.getSid());
		
		if(addStudent.getSname()=="" || addStudent.getSdept()=="" || s1=="" || un=="")
		{
			model.addAttribute("msg", "missed some important field");
			model.addAttribute("addOrUpdate", "update");
			model.addAttribute("addUpdate","Update Student");
			return "addStudent";
		}
		// validation end
		
		int check = Sdao.updateStudent(addStudent, un);
		if (check == 0) {
			model.addAttribute("msg", "Given ID not present in database first add student");
			model.addAttribute("addOrUpdate", "update");
			model.addAttribute("addUpdate","Update Student");
			return "addStudent";
		}
		model.addAttribute("msg", "data update successfully");
		model.addAttribute("addOrUpdate", "update");
		model.addAttribute("addUpdate","Update Student");
		return "addStudent";

	}

	//delete student model
	@PostMapping(path = "/deleteStudent")
	public String deleteStudent(@RequestParam("sId") int sId,Model model)
	{ //validation
		String s=String.valueOf(sId);
		if(s=="")
		{
			model.addAttribute("msg","missed field");
			return "deleteStudent";
		}
		//validation end
		
		
		int i=Sdao.deleteStudent(sId);
		if(i<=0)
		{model.addAttribute("msg","Given ID not prsent in database");
			return "deleteStudent";
		}
		model.addAttribute("msg","delete successfully");
		return "deleteStudent";
	}
	
	
	
	
	
	//button calling from home page 
	
	@RequestMapping("/callAddStudent")
	public String callAddStudent(Model model) {
		model.addAttribute("addUpdate","Add Student");
		model.addAttribute("addOrUpdate", "add");
		return "addStudent";
	}

	@RequestMapping("/updateStudent")
	public String callUpdateStudent(Model model) {
		model.addAttribute("addUpdate","Update Student");
		model.addAttribute("addOrUpdate", "update");
		return "addStudent";
	}

	@RequestMapping("/deleteStudent")
	public String callDeleteStudent() {
		
		return "deleteStudent";
	}
	
	

}
