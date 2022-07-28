package com.cars.cars.controller;

import com.cars.cars.DTO.PostDTO;
import com.cars.cars.client.ClientGetFeignPost;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("post")
public class PostController {

    private ClientGetFeignPost clientGetFeignPost;

    @GetMapping
    public List<PostDTO> getAllPosts() {
        return clientGetFeignPost.getAllPosts();
    }
//
//    @GetMapping(value = "/id/{id}")
//    public CarsDTO getAllPosts(@PathVariable Integer id) {
//        return clientGetFeign.getPostById(id);
//    }

}
