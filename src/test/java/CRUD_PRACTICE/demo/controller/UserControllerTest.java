package CRUD_PRACTICE.demo.controller;

import CRUD_PRACTICE.demo.constructor.UserInfo;
import CRUD_PRACTICE.demo.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserControllerTest {

    private UserRepository userRepository;
    private UserController userController;


    @BeforeEach
    void setup() {
        userRepository = new UserRepository();
        userController = new UserController(userRepository);
    }


    @Test
    void create() {
        // given
        UserInfo user1 = new UserInfo();
        UserInfo user2 = new UserInfo();

        user1.setName("user1");
        user1.setPassword("user1");
        user1.setNickname("user1");
        user1.setEmail("user1");

        user2.setName("user2");
        user2.setPassword("user2");
        user2.setNickname("user2");
        user2.setEmail("user2");


        //when

        userController.create(user1);
        userController.create(user2);


        //then
    }

    @Test
    void findOneUserList() {

        //given
        UserInfo user1 = new UserInfo();
        user1.setName("user1");
        user1.setPassword("user1");
        user1.setNickname("user1");
        user1.setEmail("user1");

        UserInfo user2 = new UserInfo();
        user2.setName("user2");
        user2.setPassword("user2");
        user2.setNickname("user2");
        user2.setEmail("user2");

        //when
        userController.create(user1);
        userController.create(user2);
        //id를 통해, 해당하는 UserInfo 객체 전부 가져오는데 성공
        System.out.println(userController.findOneUserList(2L));

        //then


    }

    @Test
    void update() {

        //given
        UserInfo user1 = new UserInfo();
        user1.setName("user1");
        user1.setPassword("user1");
        user1.setNickname("user1");
        user1.setEmail("user1");

        UserInfo user2 = new UserInfo();
        user2.setName("user2");
        user2.setPassword("user2");
        user2.setNickname("user2");
        user2.setEmail("user2");

        UserInfo user100 = new UserInfo();
        user100.setName("user100");
        user100.setPassword("user100");
        user100.setNickname("user100");
        user100.setEmail("user100");

        //when
        userController.create(user1);
        userController.create(user2);
        userController.update(user2.getId(),user100);

        //then
        UserInfo updatedUser = userRepository.getAllUsersList().stream()
                .filter(user -> user.getId().equals(user2.getId()))
                .findFirst()
                .orElse(null);

        assertNotNull(updatedUser, "Updated user should not be null");
        assertEquals("user100", updatedUser.getName());
        assertEquals("user100", updatedUser.getPassword());
        assertEquals("user100", updatedUser.getNickname());
        assertEquals("user100", updatedUser.getEmail());
    }

    @Test
    void delete() {

        //given
        UserInfo user1 = new UserInfo();
        user1.setName("user1");
        user1.setPassword("user1");
        user1.setNickname("user1");
        user1.setEmail("user1");

        UserInfo user2 = new UserInfo();
        user2.setName("user2");
        user2.setPassword("user2");
        user2.setNickname("user2");
        user2.setEmail("user2");

        userController.create(user1);
        userController.create(user2);

        //when
        System.out.println(userRepository.getAllUsersList());
        userController.delete(user2);
        System.out.println(userRepository.getAllUsersList());


        //then
    }
}