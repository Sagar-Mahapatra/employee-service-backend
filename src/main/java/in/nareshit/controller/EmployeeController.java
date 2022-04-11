package in.nareshit.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import in.nareshit.entity.Department;
import in.nareshit.entity.Employee;
import in.nareshit.exception.ResourceNotFoundException;
import in.nareshit.repo.DepartmentRepository;
import in.nareshit.service.IEmployeeService;

@Controller
@RequestMapping("/employee-controller")
public class EmployeeController {

	@Autowired
	private IEmployeeService service;

	@Autowired
	private DepartmentRepository deptRepo;

	private List<Department> departments = new ArrayList<>();

	@PostConstruct
	public void loadAllDepartments() {
		departments = deptRepo.findAll();
	}

	@GetMapping("/register")
	public String registerEmployee(Model model, @RequestParam(required = false) String msg) {
		Employee emp = new Employee();
		System.out.println(departments);
		model.addAttribute("departments", departments);
		model.addAttribute("employee", emp);
		model.addAttribute("message", msg);
		return "registerEmployee";
	}

	@PostMapping("/save")
	public String saveEmployee(Employee employee, RedirectAttributes attr) {
		service.saveEmployee(employee);
		if (employee.getId() != null) {
			attr.addAttribute("msg", "EMPLOYEE UPDATED SUCCESSFULLY");
		} else {
			attr.addAttribute("msg", "EMPLOYEE REGISTERED SUCCESSFULLY");
		}
		return "redirect:register";
	}

	@GetMapping("/all")
	public String allEmployees(Model model, @RequestParam(required = false) String message) {
		List<Employee> list = service.getAllEmployee();
		model.addAttribute("employees", list);
		model.addAttribute("message", message);
		return "viewEmployees";
	}

	@GetMapping("/edit")
	public String editEmployee(@RequestParam Long id, Model model, RedirectAttributes attr) {
		try {
			Employee employee = service.getEmployeeById(id);
			model.addAttribute("employee", employee);
			model.addAttribute("departments", departments);
		} catch (ResourceNotFoundException e) {
			attr.addAttribute("message", e.getMessage());
			return "redirect:all";
		}

		return "updateEmployee";
	}

	@PostMapping("/update")
	public String updateEmployee(Employee employee, RedirectAttributes attr) {
		String msg = "";
		try {
			service.updateEmployee(employee.getId(), employee);
			msg = "EMPLOYEE UPDATED SUCCESSFULLY";
		} catch (ResourceNotFoundException e) {
			msg = e.getMessage();
		}
		attr.addAttribute("message", msg);
		return "redirect:all";
	}

	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam Long id, RedirectAttributes attr) {
		String msg = "";
		try {
			service.deleteEmployee(id);
			msg = "EMPLOYEE DELETED SUCCESSFULLY";
		} catch (ResourceNotFoundException e) {
			msg = e.getMessage();
		}
		attr.addAttribute("message", msg);
		return "redirect:all";
	}

}
