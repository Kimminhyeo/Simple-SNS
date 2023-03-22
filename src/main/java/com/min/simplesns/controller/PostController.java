package com.min.simplesns.controller;

import com.min.simplesns.controller.request.PostCreateRequest;
import com.min.simplesns.controller.request.PostModifyRequest;
import com.min.simplesns.controller.response.PostResponse;
import com.min.simplesns.controller.response.Response;
import com.min.simplesns.model.Post;
import com.min.simplesns.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping
    public Response<Void> create(@RequestBody PostCreateRequest request, Authentication authentication){
        postService.create(request.getTitle(), request.getBody(), authentication.getName());

        return Response.success();
    }

    @PutMapping("/{postId}")
    public Response<PostResponse> modify(@PathVariable Integer postId, @RequestBody PostModifyRequest request, Authentication authentication){
        Post post = postService.modify(request.getTitle(), request.getBody(), authentication.getName(), postId);

        return Response.success(PostResponse.fromPost(post));
    }

    @DeleteMapping("/{postId}")
    public Response<Void> delete(@PathVariable Integer postId, Authentication authentication){
        postService.delete(authentication.getName(), postId);

        return Response.success();
    }
}
