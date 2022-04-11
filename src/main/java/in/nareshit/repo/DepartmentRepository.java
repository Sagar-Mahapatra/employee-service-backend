package in.nareshit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.nareshit.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
