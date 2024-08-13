package com.formapp.formupdate.repository;

import com.formapp.formupdate.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
