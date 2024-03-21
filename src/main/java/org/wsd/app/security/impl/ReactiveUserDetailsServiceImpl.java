package org.wsd.app.security.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.wsd.app.repository.UserRepository;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ReactiveUserDetailsServiceImpl implements ReactiveUserDetailsService {
    private final UserRepository userRepository;

    @Override
    public Mono<UserDetails> findByUsername(String username) {
        return Mono.from(userRepository.findByUsername(username));
    }
}
