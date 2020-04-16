package com.invillia.consumerspringrabbitmq.repository;

import com.invillia.consumerspringrabbitmq.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
