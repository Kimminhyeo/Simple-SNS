package com.min.simplesns.fixture;

import com.min.simplesns.model.entity.UserEntity;

public class UserEntityFixture {
    // 가짜 테스트용 유저 엔티티 반환
    public static UserEntity get(String userName, String password){
        UserEntity result = new UserEntity();
        result.setId(1);
        result.setUserName(userName);
        result.setPassword(password);

        return result;
    }
}
