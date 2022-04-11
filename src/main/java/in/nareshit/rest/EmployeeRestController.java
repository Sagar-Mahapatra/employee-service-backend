package in.nareshit.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.nareshit.entity.Employee;
import in.nareshit.props.AppProperties;
import in.nareshit.service.IEmployeeService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api/v1/employee")
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeRestController {

	@Autowired
	private IEmployeeService service;

	@Autowired
	private AppProperties props;

	@PostMapping
	public ResponseEntity<String> saveEmployee(@RequestBody Employee emp) {
		log.info("saveEmployee method in EmployeeRestController class started");
		service.saveEmployee(emp);
		log.info("saveEmployee method in EmployeeRestController class ended");
		return new ResponseEntity<String>(props.getSaveEmployeeSuccess(), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Employee>> getEmployees(@RequestParam(required = false) String sortBy,
			@RequestParam(required = false) String order) {
		log.info("getEmployees method in EmployeeRestController class started");
		ResponseEntity<List<Employee>> employees = null;
		if (sortBy == null) {
			employees = new ResponseEntity<>(service.getAllEmployee(), HttpStatus.OK);
			log.info("Data from EmployeeServiceImpl:: " + employees);
		} else {
			employees = new ResponseEntity<>(service.getAllEmployee(sortBy, order), HttpStatus.OK);
			log.info("Data from EmployeeServiceImpl:: " + employees);
		}
		log.info("getEmployees method in EmployeeRestController class ended");
		return employees;
	}

	@GetMapping("/name")
	public ResponseEntity<List<Employee>> getEmployeesNameStaringWith(@RequestParam String name) {
		log.info("getEmployeesNameStaringWith method in EmployeeRestController class started");
		List<Employee> employees = service.findByEmpNameStartingWith(name);
		log.info("getEmployeesNameStaringWith method in EmployeeRestController class ended");
		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
	}

	/*
	 * @GetMapping("/name") public ResponseEntity<List<Employee>>
	 * getEmployeesByNameLike(@RequestParam String name) { log.
	 * info("getEmployeesByNameLike method in EmployeeRestController class started"
	 * ); List<Employee> employees = service.getAllByEmpNameLike(name); log.
	 * info("getEmployeesByNameLike method in EmployeeRestController class ended");
	 * return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK); }
	 */

	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
		log.info("getEmployeeById method in EmployeeRestController class started");
		Employee employee = service.getEmployeeById(id);
		log.info("EMPLOYEE FOUND WITH ID:: " + id);
		log.info("getEmployeeById method in EmployeeRestController class ended");
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<String> updateEmployee(@RequestBody Employee employee) {
		service.updateEmployee(employee.getId(), employee);
		return new ResponseEntity<String>(props.getUpdateEmployeeSuccess(), HttpStatus.OK);
	}

	@PatchMapping("/{id}/{name}")
	public ResponseEntity<String> updateEmployeeName(@PathVariable Long id,
			@PathVariable(value = "name") String empName) {
		try {
			service.updateEmployeeName(id, empName);
			log.info("EMPLOYEE NAME UPDATED");
			return new ResponseEntity<String>(props.getUpdateEmployeeNameSuccess(), HttpStatus.OK);

		} catch (Exception e) {
			log.error(props.getUpdateEmployeeNameError());
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
		service.deleteEmployee(id);
		return new ResponseEntity<String>(props.getDeleteEmployeeSuccess(), HttpStatus.OK);
	}

	@GetMapping("/salary/{no}")
	public ResponseEntity<String> getSalary(@PathVariable int no) {
		return new ResponseEntity<String>(service.getSalary(no), HttpStatus.OK);
	}

	@GetMapping("/salary/{percentage}")
	public ResponseEntity<List<Double>> getIncrementedSalaries(@PathVariable String percentage) {
		List<Double> salaries = service.getIncrementedSalaries(Integer.valueOf(percentage).intValue());
		return new ResponseEntity<List<Double>>(salaries, HttpStatus.OK);
	}

	@GetMapping("/dept/salary/max")
	public List<Object[]> getMaxSalaryEachDept() {
		return service.getMaxSalaryEachDept();
	}

	@GetMapping("/city/{cities}")
	public List<Employee> getAllByCities(@PathVariable List<String> cities) {
		return service.getAllByCities(cities);
	}

}
