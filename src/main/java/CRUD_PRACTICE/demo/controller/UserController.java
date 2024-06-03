package CRUD_PRACTICE.demo.controller;

import CRUD_PRACTICE.demo.constructor.UserInfo;
import CRUD_PRACTICE.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;

@Controller
public class UserController implements UserControllerInterface {

    private final UserRepository userRepository;

    @Autowired
    public void userUpdateArray(UserInfo updateUser, UserInfo userInfo) {
        userInfo.setName(updateUser.getName());
        userInfo.setNickname(updateUser.getNickname());
        userInfo.setPassword(updateUser.getPassword());
        userInfo.setEmail(updateUser.getEmail());
    }

    public UserInfo userUpdateMap(Long id, UserInfo updateUser) {
        UserInfo userInfo = userRepository.getAllUsersMap().get(id);
        userInfo.setId(id);
        userInfo.setName(updateUser.getName());
        userInfo.setEmail(updateUser.getEmail());
        userInfo.setNickname(updateUser.getNickname());
        userInfo.setPassword(updateUser.getPassword());
        return userInfo;
    }


    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //유저 생성
    @Override
    public void create(UserInfo user) {
        user.setId(userRepository.sequenceAdd());
        userRepository.addUserList(user);
        userRepository.addUserMap(user);

    }

    //유저 업데이트 Array
    @Override
    public UserInfo updateArray(Long id, UserInfo updateUser) {
        int idx = this.findOneUserArray(id);
        UserInfo userInfo = userRepository.getAllUsersList().get(idx);
        userUpdateArray(updateUser, userInfo);

        return userInfo;
    }


    //유저 지우기 Array
    @Override
    public boolean deleteArray(Long id) {
        int idx = this.findOneUserArray(id);
        UserInfo removed = userRepository.getAllUsersList().remove(idx);
        return removed.getId() > 0;
    }

    //유저들 불러오기 Array
    @Override
    public List<UserInfo> readList() {
        return userRepository.getAllUsersList();
    }

    //유저 찾기 Array (인덱스 반환)
    @Override
    public int findOneUserArray(Long id) {
        List<UserInfo> allUsersList = userRepository.getAllUsersList();
        for (int i = 0; i < allUsersList.size(); i++) {
            if (allUsersList.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    //유저 업데이트 Map
    @Override
    public UserInfo updateMap(Long id, UserInfo updateUser) {
        return userUpdateMap(id, updateUser);
    }

    //유저 지우기 Map
    @Override
    public boolean deleteMap(Long id) {
        Map<Long, UserInfo> allUsersMap = userRepository.getAllUsersMap();
        allUsersMap.remove(id);
        return true;
    }

    //유저들 불러오기 Map
    @Override
    public Map<Long, UserInfo> readMap() {
        return userRepository.getAllUsersMap();
    }

    //유저 찾기 Map
    @Override
    public UserInfo findOneUserMap(Long id) {
        return userRepository.getAllUsersMap().get(id);
    }


}
