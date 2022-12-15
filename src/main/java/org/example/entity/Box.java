package org.example.entity;

import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.sql.Date;
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
public class Box {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    private String boxType;

    @NotBlank
    private String clientBoxCode;

    @NotBlank
    private String clientName;

    @NotBlank
    private Integer departmentName;

    @NotBlank
    private String boxSummary;

    @NotBlank
    private String nomenclatureId;

    @NotBlank
    @Past(message = "Beginning date must be less than today.")
    private Date beginningDate;

    @NotBlank
    @Past(message = "End date must be less than today and more or equal with beginning date")
    private Date endDate;

    @NotBlank
    private Integer storageTime;

    @ManyToOne(fetch = FetchType.LAZY)
    private Department department;

    @OneToMany(cascade = {CascadeType.ALL},
            mappedBy = "box")
    private List<Document> documents;


}

