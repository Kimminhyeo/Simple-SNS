package com.min.simplesns.fixture;

import com.min.simplesns.model.entity.PostEntity;
import com.min.simplesns.model.entity.UserEntity;
import org.springframework.security.core.parameters.P;

public class PostEntityFixture {
    public static PostEntity get(String userName, Integer postId){
        UserEntity user = new UserEntity();
        user.setId(1);
        user.setUserName(userName);

        PostEntity result = new PostEntity();
        result.setUser(user);
        result.setId(postId);

        return result;
    }
}
