package com.prapp.examplesecurityjwt.dao.repository;

import com.prapp.examplesecurityjwt.dao.entity.CompanyEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CompanyRepository extends JpaRepository<CompanyEntity, UUID> {

    Page<CompanyEntity> findAllByIsActiveTrue(Pageable pageable);

    List<CompanyEntity> findAllByIsActiveTrue();

    Optional<CompanyEntity> findByIdAndIsActiveTrue(UUID id);

}
