package CRUD_PRACTICE.demo.controller;

import CRUD_PRACTICE.demo.constructor.UserInfo;
import CRUD_PRACTICE.demo.repository.UserRepository;
import org.apache.tomcat.util.http.fileupload.MultipartStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserControllerTest {

    private UserRepository userRepository;
    private UserController userController;
    public UserInfo user1;
    public UserInfo user2;
    public UserInfo user100;
    public UserInfo user777;

    public UserControllerTest(UserRepository userRepository, UserController userController) {
        this.userRepository = userRepository;
        this.userController = userController;
    }


    @BeforeEach
    void setup() {
        user1 = new UserInfo();
        user2 = new UserInfo();
        user777 = new UserInfo();
        user100 = new UserInfo();

        user1.setName("user1");
        user1.setPassword("user1");
        user1.setNickname("user1");
        user1.setEmail("user1");

        user2.setName("user2");
        user2.setPassword("user2");
        user2.setNickname("user2");
        user2.setEmail("user2");

        user777.setName("user777");
        user777.setPassword("user777");
        user777.setNickname("user777");
        user777.setEmail("user777");

        user100.setName("user100");
        user100.setPassword("user100");
        user100.setNickname("user100");
        user100.setEmail("user100");
    }


    @Test
    void create() {
        // given
        //BeforEach

        //when
        userController.create(user1);


        //then
    }

    @Test
    void findOneUserList() {

        //given
        //BeforEach
        userController.create(user1);
        userController.create(user2);

        //when

        //id를 통해, 해당하는 UserInfo 객체 전부 가져오는데 성공

        //then


    }

    @Test
    void update() {

        //given
        //BeforEach
        userController.create(user1);
        userController.create(user2);

        //when
        userController.updateArray(user2.getId(), user100);

        //then
        UserInfo updatedUser = userRepository.getAllUsersList().stream()
                .filter(user -> user.getId().equals(user2.getId()))
                .findFirst()
                .orElse(null);

    }

    @Test
    void delete() {

        //given
        //BeforEach
        userController.create(user1);
        userController.create(user2);

        //when
        userController.deleteArray(user2.getId());


        //then
    }

    @Test
    void updateMap() {

        //given
        //BeforEach
        userController.create(user1);
        userController.create(user2);

        //when
        userController.updateMap(user2.getId(), user777);

        //then
    }

    @Test
    void deleteMap() {
        //given
        //BeforEach
        userController.create(user1);
        userController.create(user2);

        //when
        userController.deleteMap(user1.getId());

        //then
    }

    @Test
    void findOneUserMap() {
        //given
        //BeforEach
        userController.create(user1);
        userController.create(user2);

        //when
        userController.findOneUserMap(user1.getId());

        //then


    }
}