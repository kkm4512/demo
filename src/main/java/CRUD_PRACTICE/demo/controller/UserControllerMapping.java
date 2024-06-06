package CRUD_PRACTICE.demo.controller;

import CRUD_PRACTICE.demo.constructor.UserInfo;
import CRUD_PRACTICE.demo.entity.UserEntity;
import CRUD_PRACTICE.demo.service.DBUserService;
import CRUD_PRACTICE.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/api")
public class UserControllerMapping {

    private final UserService userService;
    private final DBUserService dbUserService;

    //회원가입
    @PostMapping("/signUp")
    public boolean signUp(@RequestBody UserEntity user) {
        return dbUserService.create(user);
    }

    //전체유저조회 Array
    @GetMapping("getAllUsersArray")
    public List<UserEntity> getAllUsersArray(){
        return dbUserService.readList();
    }

    //유저 업데이트 Array
    @PutMapping("/updateUserArray")
    public boolean updateUserArray(@RequestBody UserEntity user) {
        return dbUserService.updateArray(user.getId(),user);
    }

    //유저 찾기
    @GetMapping("/findSomeUsersArray/{id}")
    public UserEntity findSomeUsersArray(@PathVariable("id") Long id) {
        return dbUserService.findOneUserArray(id);
    }

    //유저 삭제
    @DeleteMapping("/deleteSomeUsersArray")
    public boolean deleteSomeUsersArray(@RequestBody UserEntity user) {
        return dbUserService.deleteArray(user.getId());
    }

    @GetMapping("/getAllUsersMap")
    public List<UserEntity> getAllUsersMap() {
        return dbUserService.readMap();
    }

    @PostMapping("/updateUserMap")
    public boolean updateUserMap(@RequestBody UserEntity user) {
        return dbUserService.updateMap(user.getId(),user);
    }

    @DeleteMapping("/deleteSomeUsersMap")
    public boolean deleteSomeUsersMap(@RequestBody UserEntity user) {
        return dbUserService.deleteMap(user.getId());
    }

    @GetMapping("/findSomeUsersMap")
    public UserEntity findSomeUsersMap(@PathVariable("id") Long id) {
        return dbUserService.findOneUserMap(id);
    }

}
