package org.wsd.app.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.wsd.app.mongo.User;
import reactor.core.publisher.Mono;

public interface UserRepository extends ReactiveMongoRepository<User, String> {
    Mono<User> findByUsername(String username);
}
