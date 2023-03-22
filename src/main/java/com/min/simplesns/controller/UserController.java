package com.min.simplesns.controller;

import com.min.simplesns.controller.request.UserJoinRequest;
import com.min.simplesns.controller.request.UserLoginRequest;
import com.min.simplesns.controller.response.Response;
import com.min.simplesns.controller.response.UserJoinResponse;
import com.min.simplesns.controller.response.UserLoginResponse;
import com.min.simplesns.model.User;
import com.min.simplesns.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // TODO : implement
    @PostMapping("/join")
    public Response<UserJoinResponse> join(@RequestBody UserJoinRequest request){

        User user = userService.join(request.getName(), request.getPassword());

        return Response.success(UserJoinResponse.fromUser(user));
    }

    @PostMapping("/login")
    public Response<UserLoginResponse> login(@RequestBody UserLoginRequest request){
        String token = userService.login(request.getName(), request.getPassword());

        return Response.success(new UserLoginResponse(token));
    }
}
