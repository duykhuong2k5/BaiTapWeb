package com.example.demo.model;

import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryModel {
    private Long categoryId;
    private String categoryCode;

    @NotEmpty
    @Length(min = 5)
    private String categoryName;

    private String images;
    private MultipartFile imageFile; // upload file
    private boolean status;
    private Boolean isEdit = false;

    public Boolean getIsEdit() {
        return isEdit;
    }

    public void setIsEdit(Boolean isEdit) {
        this.isEdit = isEdit;
    }


}