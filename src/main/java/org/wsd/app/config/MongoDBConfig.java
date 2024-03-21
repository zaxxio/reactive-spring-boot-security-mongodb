package org.wsd.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.ReactiveAuditorAware;
import org.springframework.data.mongodb.config.EnableReactiveMongoAuditing;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.convert.NoOpDbRefResolver;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Configuration
@EnableReactiveMongoAuditing(auditorAwareRef = "mongoAuditAware")
@EnableMongoRepositories(basePackages = "org.wsd.app.mongo")
public class MongoDBConfig {
    @Bean
    public ReactiveAuditorAware<String> mongoAuditAware() {
        return () -> ReactiveSecurityContextHolder.getContext()
                .map(securityContext -> {
                    String username = securityContext.getAuthentication().getName();
                    return Optional.ofNullable(username).orElse("SYSTEM");
                })
                .defaultIfEmpty("SYSTEM")
                .flatMap(Mono::just);
    }

}
