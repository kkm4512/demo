package CRUD_PRACTICE.demo.service;

import CRUD_PRACTICE.demo.entity.UserEntity;
import CRUD_PRACTICE.demo.repository.DBUserRepository;
import net.bytebuddy.dynamic.loading.ClassInjector;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class DBUserServiceTest {

    private final DBUserService dbUserService;
    private final DBUserRepository dbUserRepository;
    private UserEntity user1;
    private UserEntity user2;

    @Autowired
    DBUserServiceTest(DBUserService dbUserService, DBUserRepository dbUserRepository) {
        this.dbUserService = dbUserService;
        this.dbUserRepository = dbUserRepository;
    }

    @BeforeEach
    public void beforeTestCase(){
        user1 = new UserEntity();
        user1.setName("John Doe1");
        user1.setNickname("johnd1");
        user1.setEmail("john.doe@example.com1");
        user1.setPassword("password1");

        user2 = new UserEntity();
        user2.setName("John Doe2");
        user2.setNickname("johnd2");
        user2.setEmail("john.doe@example.com2");
        user2.setPassword("password2");

        dbUserService.create(user1);
        dbUserService.create(user2);
    }


    @Test
    void create() {
        // given
        UserEntity user = new UserEntity();
        user.setName("John Doe");
        user.setNickname("johnd");
        user.setEmail("john.doe@example.com");
        user.setPassword("password");


        // when
        dbUserService.create(user);

        // then
        UserEntity createdUser = dbUserRepository.findById(user.getId()).orElseThrow();
        assertThat(createdUser).isNotNull();
        assertThat(createdUser.getName()).isEqualTo(user.getName());
        assertThat(createdUser.getNickname()).isEqualTo(user.getNickname());
        assertThat(createdUser.getPassword()).isEqualTo(user.getPassword());
        assertThat(createdUser.getEmail()).isEqualTo(user.getEmail());
    }

    @Test
    void updateArray() {
        // given

        // when
        dbUserService.updateArray(user1.getId(),user2);

        // then
        UserEntity updatedUser = dbUserRepository.findById(user2.getId()).orElseThrow();
        assertThat(updatedUser).isNotNull();
        assertThat(updatedUser.getName()).isEqualTo(user2.getName());
        assertThat(updatedUser.getNickname()).isEqualTo(user2.getNickname());
        assertThat(updatedUser.getEmail()).isEqualTo(user2.getEmail());
        assertThat(updatedUser.getPassword()).isEqualTo(user2.getPassword());
    }

    @Test
    void deleteArray() {
        // given
        //BeforeEach

        // when
        dbUserService.deleteArray(user1.getId());


        // then
        Optional<UserEntity> deletedUser = dbUserRepository.findById(user1.getId());
        assertThat(deletedUser).isEmpty();

    }

    @Test
    void readList() {
        // given
        //BeforeEach

        // when
        List<UserEntity> users = dbUserService.readList();

        // then
        assertThat(users).isNotNull();
        if (users.isEmpty()) {
            System.out.println("[]");
        } else {
            //최소 1명의 유저가 존재
            assertThat(users.size()).isGreaterThanOrEqualTo(1);
        }

    }

    @Test
    void findOneUserArray() {
        // given
        //BeforeEach


        // when
        UserEntity findUser = dbUserService.findOneUserArray(user1.getId());

        // then
        UserEntity findUserDB = dbUserRepository.findById(user1.getId()).orElseThrow();
        assertThat(findUser).isNotNull();
        assertThat(findUserDB).isNotNull();
        assertThat(findUser).isEqualTo(findUserDB);
    }
}