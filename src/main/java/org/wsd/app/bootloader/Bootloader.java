package org.wsd.app.bootloader;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.wsd.app.mongo.Role;
import org.wsd.app.mongo.User;
import org.wsd.app.repository.RoleRepository;
import org.wsd.app.repository.UserRepository;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
@RequiredArgsConstructor
public class Bootloader implements CommandLineRunner {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        user.setUsername("partharaj.dev@gmail.com");
        user.setPassword(passwordEncoder.encode("password"));

        Role userRole = new Role("ROLE_USER");
        Role adminRole = new Role("ROLE_ADMIN");

        Mono<Role> roleMono = roleRepository.save(userRole);
        Mono<Role> roleAdmin = roleRepository.save(adminRole);

        Mono<User> userMono = Mono.zip(roleMono, roleAdmin)
                .flatMap(roles -> {
                    user.setRoles(List.of(roles.getT1(), roles.getT2()));
                    return userRepository.save(user);
                });

        userMono.subscribe();
    }
}
