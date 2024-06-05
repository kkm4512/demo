package CRUD_PRACTICE.demo.controller;

import CRUD_PRACTICE.demo.constructor.UserInfo;
import CRUD_PRACTICE.demo.entity.UserEntity;
import CRUD_PRACTICE.demo.repository.DBUserRepository;
import CRUD_PRACTICE.demo.service.DBUserService;

import java.util.List;
import java.util.Map;

public class DBUserController implements UserControllerInterface{
    private final DBUserService dbUserService;

    public DBUserController(DBUserService dbUserService) {
        this.dbUserService = dbUserService;
    }


    @Override
    public void create(UserInfo userInfo) {

    }

    @Override
    public UserInfo updateArray(Long id, UserInfo userInfo) {
        return null;
    }

    @Override
    public boolean deleteArray(Long id) {
        return false;
    }

    @Override
    public List<UserInfo> readList() {
        return List.of();
    }

    @Override
    public int findOneUserIndexArray(Long id) {
        return 0;
    }

    @Override
    public UserInfo findOneUserArray(Long id) {
        return null;
    }

    @Override
    public UserInfo updateMap(Long id, UserInfo userInfo) {
        return null;
    }

    @Override
    public boolean deleteMap(Long id) {
        return false;
    }

    @Override
    public Map<Long, UserInfo> readMap() {
        return Map.of();
    }

    @Override
    public UserInfo findOneUserMap(Long id) {
        return null;
    }
}
