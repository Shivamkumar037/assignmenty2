package com.busyatra;

import com.busyatra.entity.Role;
import com.busyatra.entity.User;
import com.busyatra.repository.RoleRepository;
import com.busyatra.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.password.PasswordEncoder;


@SpringBootApplication
@EnableJpaAuditing
public class BusYatraApplication {
@Autowired
private UserRepository userRepo;

    @Autowired
   private RoleRepository roleRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(BusYatraApplication.class, args);
        System.out.println("\n================================");
        System.out.println("Bus Yatra Application Started!");
        System.out.println("API Running on: http://localhost:8080/api");
        System.out.println("================================\n");
    }



    @Bean
    public CommandLineRunner init(UserRepository userRepo, RoleRepository roleRepo) {

return args->createMethod();
    }

    private void createMethod() {

        if(! roleRepo.existsByRoleName("ADMIN")) {
            User user = new User();
            user.setEmail("admin@gmail.com");
            user.setPassword(passwordEncoder.encode("admin@123"));
            user.setName("Admion ");
            user.setMobileNo("123456789");
            user.setAadhaarNo("123456789122");
            Role role = new Role();

            role.setRoleName("ADMIN");
            role=roleRepo.save(role);
            user.setRole(role);
            userRepo.save(user);
        }else {
            System.out.println("Role Admin  already exists!");
        }

        if(! roleRepo.existsByRoleName("USER")) {
            User user = new User();
            user.setEmail("user@gmail.com");
            user.setPassword(passwordEncoder.encode("user@123"));
            user.setName("User");
            user.setMobileNo("123456789");
            user.setAadhaarNo("123456789122");
            Role role = new Role();

            role.setRoleName("USER");
            role=roleRepo.save(role);
            user.setRole(role);
            userRepo.save(user);
        }else {
            System.out.println("Role User  already exists!");
        }
    }
}