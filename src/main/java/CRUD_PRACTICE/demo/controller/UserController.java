package CRUD_PRACTICE.demo.controller;

import CRUD_PRACTICE.demo.constructor.UserInfo;
import CRUD_PRACTICE.demo.repository.UserRepository;

import java.util.List;
import java.util.Map;

public class UserController implements UserControllerInterface {

    private final UserRepository userRepository;


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


    /**
     * 1. 업데이트할 유저의 id 받음,업데이트할 유저의 정보를 받음
     * 1-1. findOneUserList 함수를 통해 유저의 id에 해당하는 객체를 전부 꺼내옴
     * 2.
     */

    //유저 업데이트
    @Override
    public UserInfo update(Long id, UserInfo updateUser) {
        int idx = this.findOneUserList(id);
        UserInfo userInfo = userRepository.getAllUsersList().get(idx);
        userInfo.setName(updateUser.getName());
        userInfo.setNickname(updateUser.getNickname());
        userInfo.setPassword(updateUser.getPassword());
        userInfo.setEmail(updateUser.getEmail());
        return userInfo;
    }


    //유저 지우기
    //왜 아이디가 null 이지?
    @Override
    public boolean delete(UserInfo userInfo) {
        int idx = this.findOneUserList(userInfo.getId());
        UserInfo removed = userRepository.getAllUsersList().remove(idx);
        return removed.getId() > 0;
    }

    //유저들 불러오기 List
    @Override
    public List<UserInfo> readList() {
        return userRepository.getAllUsersList();
    }

    //유저 찾기 List (인덱스 반환)
    @Override
    public int findOneUserList(Long id) {
        List<UserInfo> allUsersList = userRepository.getAllUsersList();
        for (int i = 0; i < allUsersList.size(); i++) {
            if (allUsersList.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    //유저들 불러오기 Map
    @Override
    public Map<Long, UserInfo> readMap() {
        return userRepository.getAllUsersMap();
    }

    //유저 찾기 Map
    @Override
    public UserInfo findOneUserMap(Long id) {
        return null;
    }


}
