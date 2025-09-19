package com.example.demo.model;

import org.springframework.web.multipart.MultipartFile;

public class VideoModel {
	private String videoId;
    private boolean active;
    private String description; 
    private MultipartFile imageFile; // url hinh
    private String poster;
    private String title;
    private int views;
    
    private Long categoryId;
    
    private Boolean isEdit = false;
}

