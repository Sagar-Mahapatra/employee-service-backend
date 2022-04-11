package in.nareshit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Department {

	@Id
	private Integer id;

	@Column(name = "name")
	private String deptName;

}
