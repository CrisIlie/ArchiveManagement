package org.example.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.example.entity.statusEnum.BoxStatusEnum;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


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
    @Column(unique=true)
    private String clientBoxCode;

    @Enumerated(EnumType.STRING)
    private BoxStatusEnum status;

    @NotBlank
    private String boxSummary;

    @NotBlank
    private String nomenclatureId;


    @Past(message = "Beginning date must be less than today.")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate beginningDate;


    @Past(message = "End date must be less than today and more or equal with beginning date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    @NotNull
    private Integer storageTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="department_id", referencedColumnName = "id")
    private Department department;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="client_id", referencedColumnName = "id")
    private Client client;

    @ManyToMany(mappedBy = "orderedBoxes")
    private List<Order> boxOrders = new ArrayList<>();

}

