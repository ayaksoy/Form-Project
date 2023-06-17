package com.example.form.request;

import lombok.Data;

@Data
public class PostCreateRequest {
    String title;
    String text;
    Long id;
    Long userId;

}


