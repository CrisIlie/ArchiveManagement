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
public class Department {
    @Id
    @NotBlank
    private Integer id;

    @NotBlank
    private String departmentName;

    @ManyToOne(fetch = FetchType.LAZY)
    private Client client;

    @OneToMany(cascade = {CascadeType.ALL},
            mappedBy = "department")
    private List<Box> boxes;


}
