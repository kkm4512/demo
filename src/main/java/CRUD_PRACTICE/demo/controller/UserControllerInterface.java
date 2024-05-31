package CRUD_PRACTICE.demo.controller;

import CRUD_PRACTICE.demo.constructor.UserInfo;

import java.util.List;
import java.util.Map;

/**
 * 1. controller에서 구현할 함수들의 interface 설정
 *      [ C R U D ]
 * 1. C //유저 생성
 * 2  R //유저목록 읽기
 * 3. U // 유저정보 업데이트
 * 4. D // 유저 삭제
 * 5. 유저 찾기
 */
public interface UserControllerInterface {

    void create(UserInfo userInfo);
    UserInfo update(Long id, UserInfo userInfo);
    boolean delete(UserInfo userInfo);
    List<UserInfo> readList();

    //findOne 메서드들 Optional 부여해주기, return값이 없을 수 도있음
    int findOneUserList(Long id);

    Map<Long,UserInfo> readMap();
    UserInfo findOneUserMap(Long id);

}
