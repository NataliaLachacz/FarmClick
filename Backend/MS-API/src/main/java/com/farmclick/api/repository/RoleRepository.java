package com.farmclick.api.repository;

import com.farmclick.api.model.Role;
import org.hibernate.validator.internal.engine.resolver.JPATraversableResolver;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.tools.JavaCompiler;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
