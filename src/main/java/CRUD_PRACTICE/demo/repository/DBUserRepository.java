package CRUD_PRACTICE.demo.repository;


import CRUD_PRACTICE.demo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DBUserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmail(String email);
    Optional<UserEntity> findByName(String name);
    Optional<UserEntity> findByNickname(String nickname);
}
