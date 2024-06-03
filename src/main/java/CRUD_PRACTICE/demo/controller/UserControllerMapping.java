package CRUD_PRACTICE.demo.controller;

import CRUD_PRACTICE.demo.constructor.UserInfo;
import CRUD_PRACTICE.demo.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserControllerMapping {

    private final UserService userService;

    @Autowired
    public UserControllerMapping(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signUp")
    public String signUp(@RequestBody UserInfo user) {
        // 데이터를 처리하는 로직 추가
        userService.registerUser(user);

        // 예제 응답
        return "User Success created";
    }

    @GetMapping("getAllUsers")
    public List<UserInfo> showUsers(){
        return userService.getAllUsersArray();
    }
}
