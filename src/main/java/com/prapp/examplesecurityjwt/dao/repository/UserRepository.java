package com.prapp.examplesecurityjwt.dao.repository;

import com.prapp.examplesecurityjwt.dao.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {

    Optional<UserEntity> findByUsernameAndIsActiveTrue(String username);
    Optional<UserEntity> findByEmailAndIsActiveTrue(String email);


}
