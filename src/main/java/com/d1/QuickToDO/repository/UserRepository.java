package com.d1.QuickToDO.repository;

import com.d1.QuickToDO.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
