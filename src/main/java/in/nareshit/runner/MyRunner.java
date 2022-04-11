package in.nareshit.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import in.nareshit.entity.ERole;
import in.nareshit.entity.Role;
import in.nareshit.repo.RoleRepository;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Component
@Slf4j
public class MyRunner implements CommandLineRunner {

	@Autowired
	private RoleRepository repo;

	@Override
	public void run(String... args) throws Exception {
		if (repo.findAll().isEmpty() || repo.findAll() == null) {
			repo.save(new Role(ERole.ROLE_ADMIN));
			repo.save(new Role(ERole.ROLE_USER));
			log.info("ROLES INSERTED IN ROLE TABLE");
		}

	}

}
