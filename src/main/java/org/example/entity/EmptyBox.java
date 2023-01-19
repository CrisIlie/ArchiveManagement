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
public class EmptyBox {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    private String boxType;

    @NotNull
    private Integer stock;

}
