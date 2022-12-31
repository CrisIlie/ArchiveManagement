package org.example.model.document;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;


@Data
public class CreateDocumentRequest {
    @NotBlank
    private String documentTitle;

    @NotBlank
    private String documentDescription;

    @NotBlank
    private String documentDepartment;

    @NotBlank
    private String clientBoxCode;

    private Date archivingDate;

}
