package CRUD_PRACTICE.demo.controller;

import CRUD_PRACTICE.demo.constructor.UserInfo;
import CRUD_PRACTICE.demo.entity.UserEntity;
import CRUD_PRACTICE.demo.service.DBUserService;
import CRUD_PRACTICE.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserControllerMapping {

    private final UserService userService;
    private final DBUserService dbUserService;

    public UserControllerMapping(UserService userService, DBUserService dbUserService) {
        this.userService = userService;
        this.dbUserService = dbUserService;
    }

    @PostMapping("/signUp")
    public boolean signUp(@RequestBody UserEntity user) {
        boolean b = dbUserService.create(user);
        System.out.println(b);
        return true;
    }

    @GetMapping("getAllUsersArray")
    public List<UserInfo> getAllUsersArray(){
        return userService.getAllUsersArray();
    }

    @PostMapping("/updateUserArray")
    public boolean updateUserArray(@RequestBody UserInfo user) {
        return userService.updateUserArray(user.getId(),user);
    }

    @PostMapping("/findSomeUsersArray")
    public UserInfo findSomeUsersArray(@RequestBody UserInfo user) {
        return userService.findByIdArray(user.getId());
    }

    @PostMapping("/deleteSomeUsersArray")
    public boolean deleteSomeUsersArray(@RequestBody UserInfo user) {
        return userService.deleteUserByIdArray(user.getId());
    }

    @GetMapping("/getAllUsersMap")
    public Map<Long, UserInfo> getAllUsersMap() {
        return userService.getAllUsersMap();
    }

    @PostMapping("/updateUserMap")
    public boolean updateUserMap(@RequestBody UserInfo user) {
        return userService.updateUserMap(user.getId(),user);
    }

    @PostMapping("/deleteSomeUsersMap")
    public boolean deleteSomeUsersMap(@RequestBody UserInfo user) {
        return userService.deleteUserByIdMap(user.getId());
    }

    @PostMapping("/findSomeUsersMap")
    public UserInfo findSomeUsersMap(@RequestBody UserInfo user) {
        return userService.findByIdMap(user.getId());
    }

}
