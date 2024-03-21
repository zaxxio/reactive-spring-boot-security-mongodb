package org.wsd.app.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.wsd.app.mongo.Role;

public interface RoleRepository extends ReactiveMongoRepository<Role, String> {
}
