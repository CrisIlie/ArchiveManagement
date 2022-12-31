package org.example.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;
import java.util.List;

@Entity
@Table
@Audited
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
    private String departmentName;

    @NotBlank
    private String boxSummary;

    @NotBlank
    private String nomenclatureId;

    @NotNull
    @Past(message = "Beginning date must be less than today.")
    private Date beginningDate;

    @NotNull
    @Past(message = "End date must be less than today and more or equal with beginning date")
    @JsonFormat(pattern="yyyy-mm-dd")
    private Date endDate;

    @NotNull
    private Integer storageTime;

    @ManyToOne(fetch = FetchType.LAZY)
    private Department department;

    @OneToMany(cascade = {CascadeType.ALL},
            mappedBy = "box")
    private List<Document> documents;


}

