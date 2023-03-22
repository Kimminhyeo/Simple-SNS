package com.min.simplesns.fixture;

import com.min.simplesns.model.entity.PostEntity;
import com.min.simplesns.model.entity.UserEntity;
import org.springframework.security.core.parameters.P;

public class PostEntityFixture {
    public static PostEntity get(String userName, Integer postId, Integer userId){
        UserEntity user = new UserEntity();
        user.setId(userId);
        user.setUserName(userName);

        PostEntity result = new PostEntity();
        result.setUser(user);
        result.setId(postId);

        return result;
    }
}
