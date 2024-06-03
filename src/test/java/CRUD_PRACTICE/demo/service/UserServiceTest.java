package CRUD_PRACTICE.demo.service;

import CRUD_PRACTICE.demo.constructor.UserInfo;
import CRUD_PRACTICE.demo.controller.UserController;
import CRUD_PRACTICE.demo.repository.UserRepository;
import org.apache.catalina.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserServiceTest {

    private UserService userService;
    private UserInfo user1;
    private UserInfo user2;


    @BeforeEach
    public void setup(){
        UserRepository userRepository = new UserRepository();
        UserController userController = new UserController(userRepository);
        userService = new UserService(userController, userRepository);
        user1 = new UserInfo();
        user2 = new UserInfo();

        user1.setName("user1");
        user1.setPassword("user1");
        user1.setNickname("user1");
        user1.setEmail("user1");

        user2.setName("user2");
        user2.setPassword("user2");
        user2.setNickname("user2");
        user2.setEmail("user2");
    }


    @Test
    void registerUser() {

        // given

        // when
        userService.registerUser(user1);
        // then

    }

    @Test
    void updateUserArray() {

        // given
        userService.registerUser(user1);
        UserInfo user1212 = new UserInfo();
        user1212.setName("user1212");
        user1212.setPassword("user1212");
        user1212.setNickname("user1212");
        user1212.setEmail("user1212");


        // when
        userService.updateUserArray(user1.getId(),user1212);

        // then
        int idx = userService.findByIdArray(user1.getId());
        UserInfo updatedUser = userService.getAllUsersArray().get(idx);
        assertThat(updatedUser.getName()).isEqualTo(user1.getName());
        assertThat(updatedUser.getName()).isEqualTo(user1.getName());
        assertThat(updatedUser.getName()).isEqualTo(user1.getName());
        assertThat(updatedUser.getName()).isEqualTo(user1.getName());
    }

    @Test
    void deleteUserByIdArray() {

        // given
        userService.registerUser(user1);

        // when
        userService.deleteUserByIdArray(user1.getId());

        // then

    }

    @Test
    void getAllUsersArray() {

        // given

        // when
        userService.getAllUsersArray();

        // then

    }

    @Test
    void findByIdArray() {

        // given
        userService.registerUser(user1);

        // when
        userService.findByIdArray(user1.getId());

        // then

    }

    @Test
    void updateUserMap() {

        // given
        userService.registerUser(user1);
        UserInfo user1212 = new UserInfo();
        user1212.setName("user1212");
        user1212.setPassword("user1212");
        user1212.setNickname("user1212");
        user1212.setEmail("user1212");

        // when
        userService.updateUserMap(user1.getId(),user1212);
        // then

    }

    @Test
    void deleteUserByIdMap() {

        // given
        userService.registerUser(user1);

        // when
        userService.deleteUserByIdMap(user1.getId());

        // then

    }

    @Test
    void getAllUsersMap() {

        // given

        // when
        userService.getAllUsersMap();

        // then

    }

    @Test
    void findByIdMap() {

        // given
        userService.registerUser(user1);

        // when
        userService.findByIdMap(user1.getId());

        // then

    }
}