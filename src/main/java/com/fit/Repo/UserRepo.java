package com.fit.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fit.Entity.UserEntity;

@Repository

public interface UserRepo extends JpaRepository<UserEntity,Integer>{

}
