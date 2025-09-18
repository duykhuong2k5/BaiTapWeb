package vn.iostar.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Users")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(nullable = false, length = 50)
    private String userName;

    @Column(length = 100, columnDefinition = "NVARCHAR(100)")
    private String fullName;

    @Column(nullable = false, length = 100)
    private String password;

    @Column(length = 255)
    private String avatar;

    @Column(nullable = false)
    private Integer roleid;

    @Column(length = 15)
    private String phone;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
}
