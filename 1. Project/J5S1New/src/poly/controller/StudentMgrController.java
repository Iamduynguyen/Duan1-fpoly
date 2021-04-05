package poly.controller;

import org.apache.jasper.tagplugins.jstl.core.If;
import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import poly.bean.Student;

@Controller
@RequestMapping("/student-mgr")
public class StudentMgrController {
	@RequestMapping()
	public String index(ModelMap model) {
		model.addAttribute("message", "Bạn Gọi index()");
		return "student-mgr";
	}

	@RequestMapping(params = "btnInsert")
	
	public String insert(ModelMap model,

			
			@RequestParam("name")String name,
			@RequestParam("mark")Double mark,
			@RequestParam("major")String major){
			model.addAttribute("name",name);
			model.addAttribute("mark",mark);
			model.addAttribute("major",major);
		return "success";
		
		}

	@RequestMapping(params = "btnUpdate")
	public String update(ModelMap model, Student student) {
		model.addAttribute("student", student);
		model.addAttribute("message", "Bạn gọi update()");
		return "success2";
	}

	@RequestMapping(params = "btnDelete")
	public String delete(ModelMap model) {
		model.addAttribute("message", "Bạn gọi delete()");
		return "student-mgr";
	}

	@RequestMapping(params = "lnkEdit")
	public String edit(ModelMap model) {
		model.addAttribute("message", "Bạn gọi edit()");
		return "student-mgr";
	}
	
}
