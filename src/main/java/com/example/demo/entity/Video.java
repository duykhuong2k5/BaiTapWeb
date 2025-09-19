package com.example.demo.entity;

import java.io.Serializable;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Videos")
public class Video implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "VideoId", length = 50) // thêm length cho rõ ràng
    private String videoId;

    @Column(name = "Active")
    private Boolean active;

    @Column(name = "Description", columnDefinition = "TEXT", nullable = false)
    private String description;

    @Column(name = "Poster")
    private String poster;

    @Column(name = "Title", length = 255, nullable = false)
    private String title;

    @Column(name = "Views")
    private Integer views;

    @ManyToOne(fetch = FetchType.LAZY) 
    @JoinColumn(name = "CategoryId")
    private Category category;
}
