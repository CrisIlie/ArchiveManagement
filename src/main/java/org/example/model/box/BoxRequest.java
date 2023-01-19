package org.example.model.box;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.entity.statusEnum.BoxStatusEnum;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;
import java.util.Date;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoxRequest {

    private Integer id;

    @NotBlank(message = "Invalid box type")
    private String boxType;

    @NotBlank(message = "Invalid box code")
    private String clientBoxCode;

    @NotBlank
    private String boxSummary;

    @NotBlank
    private String nomenclatureId;

    @Past
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate beginningDate;

    @Past
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    @NotNull(message = "Storage time must be a number (number of years)")
    private Integer storageTime;

    private Integer departmentId;

    private Integer clientId;

    private Integer orderId;
}
