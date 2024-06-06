package CRUD_PRACTICE.demo.service;

import CRUD_PRACTICE.demo.entity.UserEntity;

import java.util.List;
import java.util.Map;

public interface DBUserServiceInterface {

    boolean create(UserEntity user);

    boolean updateArray(Long id, UserEntity user);

    boolean deleteArray(Long id);

    List<UserEntity> readList();

    int findOneUserIndexArray(Long id);

    UserEntity findOneUserArray(Long id);

    boolean updateMap(Long id, UserEntity user);

    boolean deleteMap(Long id);

    List<UserEntity> readMap();

    UserEntity findOneUserMap(Long id);
}
