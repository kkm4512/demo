package CRUD_PRACTICE.demo.service;

import CRUD_PRACTICE.demo.constructor.UserInfo;
import CRUD_PRACTICE.demo.controller.UserController;
import CRUD_PRACTICE.demo.repository.UserRepository;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class UserService {
    private final UserRepository userRepository;
    private final UserController userController;

    public UserService(UserController userController, UserRepository userRepository) {
        this.userController = userController;
        this.userRepository = userRepository;
    }

    public static class NoUsersFoundException extends RuntimeException {
        public NoUsersFoundException(String message) {
            super(message);
        }
    }

    public void userCheck(UserInfo user){
        if (user.getName() == null || user.getPassword() == null || user.getNickname() == null || user.getEmail() == null) {
            throw new IllegalArgumentException("유저의 정보는 공백 일 수 없습니다.");
        }
    }

    public void idCheckArray(Long id){
        int findUserId = userController.findOneUserArray(id);
        if (findUserId == -1) throw new IllegalArgumentException("해당 아이디가 존재 하지 않습니다. Array");
    }

    public void isNullArray(){
        List<UserInfo> userInfos = userController.readList();
        if (userInfos.isEmpty()) {
            throw new NoUsersFoundException("사용자가 없습니다 Array");
        }
    }

    public void idCheckMap(Long id){
        Map<Long, UserInfo> usersMap = userController.readMap();
        UserInfo userInfo = usersMap.get(id);
        Optional.ofNullable(userInfo)
                .orElseThrow(()
                -> new IllegalArgumentException("아이디를 찾을 수 없습니다 Map"));
    }

    public void isNullMap(){
        Map<Long, UserInfo> usersMap = userController.readMap();
        Optional.ofNullable(usersMap).orElseThrow(
                () -> new IllegalArgumentException("사용자가 없습니다 Map")
        );
    }


    public void registerUser(UserInfo user){
        userCheck(user);
        userController.create(user);
    }

    public void updateUserArray(Long id, UserInfo updateUser){
        userCheck(updateUser);
        userController.updateArray(id,updateUser);
    }

    public void deleteUserByIdArray(Long id){
        idCheckArray(id);
        userController.deleteArray(id);
    }

    public List<UserInfo> getAllUsersArray(){
        isNullArray();
        return userController.readList();
    }

    public int findByIdArray(Long id){
        idCheckArray(id);
        return userController.findOneUserArray(id);
    }

    public void updateUserMap(Long id, UserInfo updateUser){
        idCheckMap(id);
        userController.userUpdateMap(id,updateUser);
    }

    public void deleteUserByIdMap(Long id){
        idCheckMap(id);
        userController.deleteMap(id);
    }

    public void getAllUsersMap(){
        isNullMap();
        userController.readMap();
    }

    public void findByIdMap(Long id){
        idCheckMap(id);
        userController.findOneUserMap(id);
    }


}
