package in.nareshit.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import in.nareshit.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	@Modifying
	@Query("UPDATE Employee e SET e.empName=:name WHERE e.id=:id")
	int updateEmployeeName(Long id, String name);

	List<Employee> findByEmpNameStartingWithOrderByEmpSalaryDesc(String empName);

	// List<Employee> findByEmpNameLike(String empName);

	@Query("from Employee where empName LIKE :name Order by empSalary Desc")
	List<Employee> getAllByNameLike(String name);

	@Query(value = "select * from Employee order by emp_salary desc limit :no,1", nativeQuery = true)
	Employee getSalary(int no);

	String findEmpNameById(Long id);

	@Query("select empSalary from Employee")
	List<Double> getSalaries();

	@Query("select e from Employee e where e.empSalary in (:salaries)")
	List<Employee> getAllBySalaries(List<Double> salaries);

	@Query("select max(e.empSalary),e.empName,e.empDept from Employee e group by e.empDept")
	List<Object[]> getMaxSalaryEachDept();

	@Query("select e from Employee e INNER JOIN e.empAddr as a where a.city in (:cities)")
	List<Employee> getAllByCities(List<String> cities);
}
