package com.min.simplesns.repository;

import com.min.simplesns.model.entity.LikeEntity;
import com.min.simplesns.model.entity.PostEntity;
import com.min.simplesns.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface LikeEntityRepository extends JpaRepository<LikeEntity, Integer> {
    Optional<LikeEntity> findByUserAndPost(UserEntity userEntity, PostEntity postEntity);

    @Query("SELECT count(*) FROM LikeEntity entity WHERE entity.post =:post")
    Integer countByPost(@Param("post") PostEntity post);
    List<LikeEntity> findAllByPost(PostEntity post);
}
