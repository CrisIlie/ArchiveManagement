package org.example.entity;

import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.sql.Date;

@Entity
@Table
@Audited
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    private String documentTitle;

    @NotBlank
    private String documentDescription;

    @NotBlank
    private String documentDepartment;

    @NotNull
    @Past(message="Archiving date must be less than today")
    private Date archivingDate;

    @ManyToOne(fetch = FetchType.LAZY)
    private Box box;

}
