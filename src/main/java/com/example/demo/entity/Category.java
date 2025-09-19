package com.example.demo.entity;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Category")
public class Category implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CategoryId")
    private Long categoryId;

    @Column(name = "CategoryCode")
    private String categoryCode;

    @Column(name = "CategoryName", columnDefinition = "nvarchar(255)")
    private String categoryName;

    @Column(name = "Images")
    private String images;

    @Column(name = "Status")
    private Boolean status;

    

    public Long getCategoryId() {
		return categoryId;
	}



	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}



	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private Set<Video> videos;
}
