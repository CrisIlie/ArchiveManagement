package org.example.entity;

import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table
@Audited
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true, length = 30)
    private String userName;


    @Column(nullable = false, unique = true, length = 50)
    private String userEmail;

    @Column(nullable = false, length = 25)
    private String password;

}
