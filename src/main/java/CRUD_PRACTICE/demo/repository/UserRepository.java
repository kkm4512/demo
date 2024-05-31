package CRUD_PRACTICE.demo.repository;

import CRUD_PRACTICE.demo.constructor.UserInfo;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepository {

    public Long sequence = 0L;
    public List<UserInfo> userInfoArray = new ArrayList<>();
    public Map<Long,UserInfo> userInfoMap = new HashMap<>();

    public Long sequenceAdd(){
        return ++sequence;
    }

    public List<UserInfo> getAllUsersList(){
        return userInfoArray;
    }

    public Map<Long,UserInfo> getAllUsersMap(){
        return userInfoMap;
    }

    public void addUserList(UserInfo userInfo){
        userInfoArray.add(userInfo);
    }

    public void addUserMap (UserInfo userInfo){
        userInfoMap.put(userInfo.getId(),userInfo);
    }
}
