package CRUD_PRACTICE.demo.service;

import CRUD_PRACTICE.demo.entity.UserEntity;
import CRUD_PRACTICE.demo.exceptionError.DuplicateUserException;
import CRUD_PRACTICE.demo.exceptionError.UserNotFoundException;
import CRUD_PRACTICE.demo.repository.DBUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class DBUserService implements DBUserServiceInterface{
    private final DBUserRepository dbUserRepository;


    //유저 정보 Send
    public UserEntity sendUserInfo(Long id){
        return dbUserRepository.findById(id).orElseThrow();
    }

    //존재하는지 확인 ID
    public void idCheck(Long id){
        dbUserRepository.findById(id).orElseThrow( () -> new UserNotFoundException("사용자가 존재하지 않습니다.") );
    }

    //공백인지 확인
    public void userCheck(UserEntity user){
        if ( user.getName() == null || user.getNickname() == null || user.getPassword() == null || user.getEmail() == null) {
            throw new IllegalArgumentException("사용자의 정보는 공백일 수 없습니다.");
        }
    }

    //중복체크
    public void userDuplicateCheck(UserEntity user){
        if (dbUserRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new DuplicateUserException("이메일이 중복됩니다.");
        }
        if (dbUserRepository.findByNickname(user.getNickname()).isPresent()) {
            throw new DuplicateUserException("닉네임이 중복됩니다.");
        }
        if (dbUserRepository.findByName(user.getName()).isPresent()) {
            throw new DuplicateUserException("이름이 중복됩니다.");
        }
    }


    /**
     * 회원가입
     */
    @Override
    public boolean create(UserEntity user) {
        userCheck(user);
        userDuplicateCheck(user);
        dbUserRepository.save(user);
        return true;
    }

    /**
     * 업데이트 Array
     */
    @Override
    public boolean updateArray(Long id, UserEntity newUser) {
        idCheck(id);
        UserEntity oldUser = sendUserInfo(id);
        updateArrayFunction(oldUser, newUser);
        return true;
    }

    /**
     * 삭제 Array
     */
    @Override
    public boolean deleteArray(Long id) {
        idCheck(id);
        UserEntity findUser = sendUserInfo(id);
        dbUserRepository.delete(findUser);
        return true;
    }

    /***
     * 모든회원조회 Array
     */
   @Override
    public List<UserEntity> readList() {
        return dbUserRepository.findAll();
    }

    //인덱스 반환용
    @Override
    public int findOneUserIndexArray(Long id) {
        return 0;
    }

    /***
     * 단일회원조회 Array
     */
    @Override
    public UserEntity findOneUserArray(Long id) {
        idCheck(id);
        return sendUserInfo(id);
    }

    /***
     * 업데이트 Map
     */
    @Override
    public boolean updateMap(Long id, UserEntity newUser) {
        idCheck(id);
        UserEntity oldUser = sendUserInfo(id);
        updateMapFunction(oldUser,newUser);
        return true;
    }

    /***
     * 삭제 Map
     */
    @Override
    public boolean deleteMap(Long id) {
        idCheck(id);
        UserEntity findUser = sendUserInfo(id);
        dbUserRepository.delete(findUser);
        return true;
    }

    /***
     * 모든회원조회 Map
     */
    @Override
    public List<UserEntity> readMap() {
        return dbUserRepository.findAll();
    }

    /***
     * 단일회원조회 Map
     */
    @Override
    public UserEntity findOneUserMap(Long id) {
        idCheck(id);
        return sendUserInfo(id);
    }

    /***
     * updateArrayFunction
     */

    private void updateArrayFunction(UserEntity oldUser, UserEntity newUser){
        oldUser.setName(newUser.getName());
        oldUser.setNickname(newUser.getNickname());
        oldUser.setPassword(newUser.getPassword());
        oldUser.setEmail(newUser.getEmail());
    }

    private void updateMapFunction(UserEntity oldUser, UserEntity newUser){
        oldUser.setName(newUser.getName());
        oldUser.setNickname(newUser.getNickname());
        oldUser.setPassword(newUser.getPassword());
        oldUser.setEmail(newUser.getEmail());
    }


}
