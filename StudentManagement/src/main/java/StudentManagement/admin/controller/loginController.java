package StudentManagement.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import StudentManagement.admin.*;
import StudentManagement.admin.dao.Admin_dao;
import StudentManagement.admin.model.Admin;
import StudentManagement.admin.model.User;
import StudentManagement.student.dao.StudentDao;

@Controller
public class loginController {
	public String userName = "";

	@Autowired
	public Admin_dao admin_dao;

	@Autowired
	public StudentDao Sdao;

	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	//calling home page
	@RequestMapping("/home")
	public String home(Model model) {
		List<Object[]> list1 = Sdao.allInTable();

		model.addAttribute("list", list1);

		return "home";
	}

	//validating login page if loging details true then call home page
	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public String loginPerform(@ModelAttribute User user, Model model) {
		int i = admin_dao.validate(user.getUname(), user.getPass());
		if (i==0) {
			model.addAttribute("msg", "You have enterd wrong password and username");
			return "login";
		}
		List<Object[]> list1 = Sdao.allInTable();

		model.addAttribute("list", list1);

		userName = user.getUname();
		return "home";

		
	}
}
