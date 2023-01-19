package org.example.model.box;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.example.entity.statusEnum.BoxStatusEnum;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;


@Data
public class CreateBoxRequest {
    @NotBlank
    private String boxType;
    @NotBlank
    private String clientBoxCode;
    @NotBlank
    private String boxSummary;
    @NotBlank
    private String nomenclatureId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate beginningDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate endDate;
    @NotNull
    private Integer storageTime;

    private Integer client_id;
    private Integer department_id;

}
