package vn.iostar.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "videos")
public class Video implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title", columnDefinition = "NVARCHAR(255)")
    private String title;
    @Column(name = "description", columnDefinition = "NVARCHAR(MAX)")
    private String description;
    @Column(name = "url", columnDefinition = "NVARCHAR(500)")
    private String url;
}


