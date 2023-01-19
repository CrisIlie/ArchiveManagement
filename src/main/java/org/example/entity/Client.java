package org.example.entity;

import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Audited
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Column(unique = true)
    private String clientName;

    @NotBlank
    private String address;

    @NotBlank
    private String clientEmail;


    @OneToMany(cascade = {CascadeType.ALL},
            mappedBy = "client")
    private List<Department> departments;

    @OneToMany(cascade = {CascadeType.ALL},
            mappedBy = "client")
    private List<Box> boxes = new ArrayList<>();

    @OneToMany(cascade = {CascadeType.ALL},mappedBy = "client")
    private List<EmptyBoxOrder> emptyBoxOrders;

    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "client")
    private List<Order> boxOrders;

}