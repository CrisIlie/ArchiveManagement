package org.example.entity;

import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table
@Audited
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    private String name;

    @NotBlank
    private String address;

    @NotBlank
    private String email;

    private Boolean active;

    @OneToMany(cascade = {CascadeType.ALL},
            mappedBy = "client")
    private List<Department> departments;

    @OneToMany(cascade = {CascadeType.ALL},
            mappedBy = "client")
    private List<User> users;
}