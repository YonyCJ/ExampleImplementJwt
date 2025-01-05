package com.prapp.examplesecurityjwt.dao.repository;

import com.prapp.examplesecurityjwt.dao.entity.UserProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfileEntity, UUID> {

    List<UserProfileEntity> findByUserId(UUID userId);

}
