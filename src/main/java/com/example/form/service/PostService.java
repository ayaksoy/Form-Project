package com.example.form.service;


import com.example.form.entity.Post;
import com.example.form.entity.User;
import com.example.form.repository.PostRepository;
import com.example.form.request.PostCreateRequest;
import com.example.form.request.PostUpdateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    private UserService userService;
    private  PostRepository postRepository;
    public PostService (PostRepository postRepository, UserService userService){
        this.postRepository=postRepository;
        this.userService = userService;
    }
    public List<Post> getAllPosts(Optional<Long> userId) {
        if (userId.isPresent()){
            return postRepository.findByUserId(userId.get());

        }return postRepository.findAll();
    }


    public Post getOnePostById(Long postId) {
        return postRepository.findById(postId).orElse(null);
    }

    public void deleteOnePostById(Long postId) {
        postRepository.deleteById(postId);
    }

    public Post updateOnePost(Long postId, PostUpdateRequest updatePost) {
        Optional <Post> post = postRepository.findById(postId);
        if (post.isPresent()){
            Post toUpdate = post.get();
            toUpdate.setText(updatePost.getText());
            toUpdate.setTitle(updatePost.getTitle());
            postRepository.save(toUpdate);
            return toUpdate;
        }return null;
    }

    public Post createOnePost(PostCreateRequest newPostRequest) {
       User user= userService.getOneUserById(newPostRequest.getUserId());
        if (user == null)
            return null;
        Post toSave = new Post();
        toSave.setId(newPostRequest.getId());
        toSave.setText(newPostRequest.getText());
        toSave.setTitle(newPostRequest.getTitle());
        toSave.setUser(user);
        return postRepository.save(toSave);

    }
}
