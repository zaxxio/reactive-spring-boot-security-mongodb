package org.wsd.app.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wsd.app.mongo.User;
import org.wsd.app.repository.UserRepository;
import reactor.core.publisher.Flux;

@Tag(name = "User Controller")
@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;

    @GetMapping
    public Flux<User> getUsers() {
        return userRepository.findAll();
    }

}
