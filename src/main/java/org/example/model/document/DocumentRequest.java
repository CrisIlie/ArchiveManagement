package org.example.model.document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.sql.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DocumentRequest {

    private Integer id;

    @NotBlank(message = "Document title must be of text format")
    private String documentTitle;

    @NotBlank
    private String documentDescription;

    @NotBlank(message = "Invalid department name")
    private String departmentName;

    @Past
    private Date archivingDate;

    private Integer boxId;
    private int[] documentBoxesIds;
}
