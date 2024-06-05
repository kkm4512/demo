package CRUD_PRACTICE.demo.service;

import CRUD_PRACTICE.demo.entity.UserEntity;

import java.util.List;
import java.util.Map;

public interface DBUserServiceInterface {

    boolean create(UserEntity user);

    UserEntity updateArray(Long id, UserEntity user);

    boolean deleteArray(Long id);

    List<UserEntity> readList();

    int findOneUserIndexArray(Long id);

    UserEntity findOneUserArray(Long id);

    UserEntity updateMap(Long id, UserEntity user);

    boolean deleteMap(Long id);

    Map<Long, UserEntity> readMap();

    UserEntity findOneUserMap(Long id);
}
