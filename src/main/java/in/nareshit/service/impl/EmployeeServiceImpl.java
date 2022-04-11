package in.nareshit.service.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.nareshit.entity.Employee;
import in.nareshit.exception.ResourceNotFoundException;
import in.nareshit.repo.EmployeeRepository;
import in.nareshit.service.IEmployeeService;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private EmployeeRepository repo;

	@Override
	public Long saveEmployee(Employee e) {
		System.out.println("saveEmployee in EmployeeServiceImpl executed");
		e.setEmpCode(UUID.randomUUID().toString().substring(0, 7).toUpperCase());
		Long id = repo.save(e).getId();
		return id;
	}

	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> employees = repo.findAll();
		log.info("List of Employee data in EmployeeServiceImpl: " + employees);
		employees.stream().collect(Collectors.groupingBy(Employee::getEmpDept))
				.forEach((dept, empl) -> System.out.println(dept + "=>" + empl));
		return employees;
	}

	@Override
	public List<Employee> getAllEmployee(String sortBy, String order) {
		if (order == null)
			return repo.findAll(Sort.by(sortBy));
		else if (order.equalsIgnoreCase("desc"))
			return repo.findAll(Sort.by(sortBy).descending());
		/*
		 * Java 8 return
		 * repo.findAll().stream().sorted(Comparator.comparing(Employee::getEmpSalary).
		 * reversed()).collect(Collectors.toList());
		 */
		else
			return repo.findAll(Sort.by(sortBy));
	}

	@Override
	@Cacheable(value = "employee", key = "#id")
	public Employee getEmployeeById(Long id) {
		return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("NO EMPLOYEE FOUND WITH ID: " + id));
	}

	@Override
	@CachePut(value = "employee", key = "#id")
	public Employee updateEmployee(Long id, Employee e) {
		if (repo.existsById(id) && id != null) {
			Employee updatedEmployee = repo.save(e);
			log.info("UPDATED EMPLOYEE:: " + updatedEmployee);
			return updatedEmployee;
		} else {
			throw new ResourceNotFoundException("NO EMPLOYEE FOUND WITH ID: " + id);
		}
	}

	@Override
	@CacheEvict(value = "employee", key = "#id")
	public void deleteEmployee(Long id) {
		repo.delete(getEmployeeById(id));
	}

	@Transactional
	@Override
	@CachePut(key = "#id", value = "employee")
	public int updateEmployeeName(Long id, String name) {
		if (repo.existsById(id))
			return repo.updateEmployeeName(id, name);
		else
			throw new ResourceNotFoundException("NO EMPLOYEE FOUND WITH ID: " + id);
	}

	@Override
	public List<Employee> findByEmpNameStartingWith(String empName) {
		return repo.findByEmpNameStartingWithOrderByEmpSalaryDesc(empName);
	}

	@Override
	public List<Employee> getAllByEmpNameLike(String empName) {
		return repo.getAllByNameLike(empName);
	}

	@Override
	public String getSalary(int no) {
		Employee emp = repo.getSalary(no - 1);
		return emp.getEmpName() + " => " + emp.getEmpSalary();
	}

	@Override
	public String findEmpNameById(Long id) {
		return repo.findEmpNameById(id);
	}

	@Override
	public List<Double> getIncrementedSalaries(int percentage) {
		return repo.getSalaries().stream().map(emp -> ((percentage / 100) * emp) + emp).collect(Collectors.toList());
	}

	@Override
	public List<Employee> getAllBySalaries(List<Double> salaries) {
		return repo.getAllBySalaries(salaries);
	}

	@Override
	public List<Object[]> getMaxSalaryEachDept() {
		return repo.getMaxSalaryEachDept();
	}

	@Override
	public List<Employee> getAllByCities(List<String> cities) {
		System.out.println(cities);
		return repo.getAllByCities(cities);
	}

}
