package com.auth.service.repository;

import com.auth.service.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users,Long> {

    Users findByUsername(String username);

    Optional<Users> findByEmail(String email);

    boolean existsByEmail(String email);

}
