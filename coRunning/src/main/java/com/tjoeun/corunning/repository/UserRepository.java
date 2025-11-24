package com.tjoeun.corunning.repository;

import com.tjoeun.corunning.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
