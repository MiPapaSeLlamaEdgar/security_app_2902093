package co.edu.sena.security_app_2902093;

import co.edu.sena.security_app_2902093.persistence.entity.PermissionEntity;
import co.edu.sena.security_app_2902093.persistence.entity.RoleEntity;
import co.edu.sena.security_app_2902093.persistence.entity.RoleEnum;
import co.edu.sena.security_app_2902093.persistence.entity.UserEntity;
import co.edu.sena.security_app_2902093.persistence.entity.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Set;

@SpringBootApplication
public class Application {

	public static void main(String[] args) { SpringApplication.run(Application.class, args);}

	@Bean
	CommandLineRunner inti(UserRepository userRepository) {
		return args -> {
			//CREATE PERMISSIONS
			PermissionEntity createPermission = PermissionEntity.builder()
					.name("CREATE")
					.build();

			PermissionEntity readPermission = PermissionEntity.builder()
					.name("READ")
					.build();

			PermissionEntity updatePermission = PermissionEntity.builder()
					.name("UPDATE")
					.build();

			PermissionEntity deletePermission = PermissionEntity.builder()
					.name("DELETE")
					.build();

			PermissionEntity refactorPermission = PermissionEntity.builder()
					.name("REFACTOR")
					.build();

			//CREATE ROLES
			RoleEntity roleAdmin = RoleEntity.builder()
					.roleEnum(RoleEnum.ADMIN)
					.permissionList(Set.of(createPermission, readPermission, updatePermission, deletePermission))
					.build();

			RoleEntity roleUser = RoleEntity.builder()
					.roleEnum(RoleEnum.USER)
					.permissionList(Set.of(createPermission, readPermission))
					.build();

			RoleEntity roleInvited = RoleEntity.builder()
					.roleEnum(RoleEnum.INVITED)
					.permissionList(Set.of(readPermission))
					.build();

			RoleEntity roleDeveloper = RoleEntity.builder()
					.roleEnum(RoleEnum.DEVELOPER)
					.permissionList(Set.of(createPermission, readPermission, updatePermission, deletePermission, refactorPermission))
					.build();

			//CREATE USERS
			UserEntity userEric = UserEntity.builder()
					.username("eric")
					.password("$2a$10$s0GTUt7rwesnNb.2tcvHdOSXs.dCTsPPTilw4pLbfwNMdYvegibuW")
					.isEnabled(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.credentialNoExpired(true)
					.roles(Set.of(roleAdmin))
					.build();

			UserEntity userJavier = UserEntity.builder()
					.username("javier")
					.password("$2a$10$s0GTUt7rwesnNb.2tcvHdOSXs.dCTsPPTilw4pLbfwNMdYvegibuW")
					.isEnabled(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.credentialNoExpired(true)
					.roles(Set.of(roleUser))
					.build();

			UserEntity userPaula = UserEntity.builder()
					.username("paula")
					.password("$2a$10$s0GTUt7rwesnNb.2tcvHdOSXs.dCTsPPTilw4pLbfwNMdYvegibuW")
					.isEnabled(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.credentialNoExpired(true)
					.roles(Set.of(roleInvited))
					.build();

			UserEntity userMora = UserEntity.builder()
					.username("mora")
					.password("$2a$10$s0GTUt7rwesnNb.2tcvHdOSXs.dCTsPPTilw4pLbfwNMdYvegibuW")
					.isEnabled(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.credentialNoExpired(true)
					.roles(Set.of(roleDeveloper))
					.build();

			userRepository.saveAll(List.of(userEric, userJavier, userPaula, userMora));

		};
	}
}
