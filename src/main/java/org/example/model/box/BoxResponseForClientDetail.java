package org.example.model.box;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Data
@Getter
@Setter
public class BoxResponseForClientDetail {
    private String clientBoxCode;
    private String summary;
    private LocalDate beginningDate;
    private LocalDate endDate;
    private Integer storageTime;

}
