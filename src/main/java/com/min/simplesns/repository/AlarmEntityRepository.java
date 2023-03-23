package com.min.simplesns.repository;

import com.min.simplesns.model.entity.AlarmEntity;
import com.min.simplesns.model.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AlarmEntityRepository extends JpaRepository<AlarmEntity, Integer> {
    Page<AlarmEntity> findAllByUser(UserEntity user, Pageable pageable);
}
