package com.prapp.examplesecurityjwt.dao.repository;

import com.prapp.examplesecurityjwt.dao.entity.ProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProfileRepository extends JpaRepository<ProfileEntity, UUID> {

}