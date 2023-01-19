package org.example.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "t_order")
@Audited
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate boxOrderDate;

    @NotNull
    private Boolean delivered;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "box_orders", joinColumns =
            {@JoinColumn(name = "order_id", referencedColumnName = "id")},
           inverseJoinColumns = {@JoinColumn(name = "box_id", referencedColumnName = "id")})
    @Builder.Default
    private Set<Box> orderedBoxes = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private Client client;

}

