package in.nareshit.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import in.nareshit.entity.ERole;
import in.nareshit.entity.Role;
import in.nareshit.repo.RoleRepository;
import lombok.Data;

@Data
@Component
public class MyRunner implements CommandLineRunner {

	@Autowired
	private RoleRepository repo;

	@Override
	public void run(String... args) throws Exception {
		if (repo.findAll().isEmpty() || repo.findAll() == null) {
			repo.save(new Role(ERole.ROLE_ADMIN));
			repo.save(new Role(ERole.ROLE_USER));
			System.out.println("ROLES INSERTED IN ROLE TABLE");
		}

	}

}
