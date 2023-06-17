package com.example.form.controller;

import com.example.form.entity.Like;
import com.example.form.request.LikeCreateRequest;
import com.example.form.service.LikeService;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/likes")
public class LikeController {

    private LikeService likeService;
    public LikeController(LikeService likeService){
        this.likeService = likeService;
    }



    @GetMapping
    public List<Like> getAllLikes(@RequestParam Optional<Long> userId,@RequestParam Optional<Long>postId){
        return likeService.getAllLikesWithParam(userId,postId);
    }
    @PostMapping
    public Like createOneLike(@RequestBody LikeCreateRequest request){
        return likeService.createOneLike(request);
    }
    @GetMapping("/{likeId}")
    public Like getOneLike(@PathVariable Long likeId){
        return likeService.getOneLikeById(likeId);
    }
    @DeleteMapping("/{likeId}")
    public void deleteOneLike (@PathVariable Long likeId){
        likeService.deleteOneLikeById(likeId);
    }


}
