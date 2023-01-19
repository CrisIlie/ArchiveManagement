package org.example.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table
@Audited
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmptyBoxOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    private String boxType;

    @NotNull
    private Integer orderedAmount;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate orderDate;

    @ManyToOne(fetch = FetchType.LAZY)
    private Client client;
}
