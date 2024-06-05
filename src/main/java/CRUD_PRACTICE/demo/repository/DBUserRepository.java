package CRUD_PRACTICE.demo.repository;

import CRUD_PRACTICE.demo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DBUserRepository extends JpaRepository<UserEntity, Long> {
}
