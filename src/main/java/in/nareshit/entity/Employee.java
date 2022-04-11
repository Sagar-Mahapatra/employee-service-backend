package in.nareshit.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee implements Serializable, Comparable<Employee> {

	private static final long serialVersionUID = 6617232005650316109L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "emp_name", nullable = false)
	private String empName;

	@Column(name = "emp_psw", nullable = false)
	private String empPassword;

	@Column(name = "emp_salary", nullable = false)
	private Double empSalary;

	@Column(name = "emp_dept", nullable = false)
	private String empDept;

	@Column(name = "emp_email", nullable = false)
	private String empEmail;
	@Column(name = "emp_contact", nullable = false)
	private String empContact;
	@Column(name = "emp_gender", nullable = false)
	private String empGender;

	@Column(name = "emp_code", nullable = false, updatable = false)
	private String empCode;

	@Column(name = "emp_img", nullable = false)
	private String imgurl;

	@ElementCollection
	private Set<String> roles;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "emp_id_fk")
	private List<Address> empAddr;

	@Override
	public int compareTo(Employee o) {
		return o.getEmpEmail().compareTo(this.getEmpEmail());
	}

}
