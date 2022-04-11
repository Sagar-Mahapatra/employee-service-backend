package in.nareshit.service;

import java.util.List;

import in.nareshit.entity.Employee;

public interface IEmployeeService {

	Long saveEmployee(Employee e);

	List<Employee> getAllEmployee();

	List<Employee> getAllEmployee(String sortBy, String order);

	Employee getEmployeeById(Long id);

	Employee updateEmployee(Long id, Employee e);

	void deleteEmployee(Long id);

	int updateEmployeeName(Long id, String name);

	List<Employee> findByEmpNameStartingWith(String empName);

	List<Employee> getAllByEmpNameLike(String empName);

	String getSalary(int no);

	String findEmpNameById(Long id);

	List<Double> getIncrementedSalaries(int percentage);

	List<Employee> getAllBySalaries(List<Double> salaries);

	List<Object[]> getMaxSalaryEachDept();
	
	List<Employee> getAllByCities(List<String> cities);

}
