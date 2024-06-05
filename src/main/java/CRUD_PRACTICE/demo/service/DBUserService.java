package CRUD_PRACTICE.demo.service;

import CRUD_PRACTICE.demo.constructor.UserInfo;
import CRUD_PRACTICE.demo.entity.UserEntity;
import CRUD_PRACTICE.demo.repository.DBUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class DBUserService implements DBUserServiceInterface{
    private final DBUserRepository dbUserRepository;

    public static class DuplicateUserException extends RuntimeException {
        public DuplicateUserException(String msg) {
            super(msg);
        }
    }

    //공백인지 확인
    public void userCheck(UserEntity user){
        if ( user.getName() == null || user.getNickname() == null || user.getPassword() == null || user.getEmail() == null) {
            throw new IllegalArgumentException("사용자의 정보는 공백일 수 없습니다.");
        }
    }

//    public void userDuplicateCheck(UserEntity user){
//        if (dbUserRepository.findByEmail(user.getEmail()).isPresent()) {
//            throw new DuplicateUserException("이메일이 중복됩니다.");
//        }
//        if (dbUserRepository.findByNickname(user.getNickname()).isPresent()) {
//            throw new DuplicateUserException("닉네임이 중복됩니다.");
//        }
//        if (dbUserRepository.findByName(user.getName()).isPresent()) {
//            throw new DuplicateUserException("이름이 중복됩니다.");
//        }
//    }


    @Override
    public boolean create(UserEntity user) {
        userCheck(user);
//        userDuplicateCheck(user);
        dbUserRepository.save(user);
        return true;
    }

    @Override
    public UserEntity updateArray(Long id, UserEntity user) {
        return null;
    }

    @Override
    public boolean deleteArray(Long id) {
        return false;
    }

    @Override
    public List<UserEntity> readList() {
        return List.of();
    }

    @Override
    public int findOneUserIndexArray(Long id) {
        return 0;
    }

    @Override
    public UserEntity findOneUserArray(Long id) {
        return null;
    }

    @Override
    public UserEntity updateMap(Long id, UserEntity user) {
        return null;
    }

    @Override
    public boolean deleteMap(Long id) {
        return false;
    }

    @Override
    public Map<Long, UserEntity> readMap() {
        return Map.of();
    }

    @Override
    public UserEntity findOneUserMap(Long id) {
        return null;
    }
}
