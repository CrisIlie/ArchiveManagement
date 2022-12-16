package org.example.model.document;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.sql.Date;

@Data
public class CreateDocumentRequest {
    @NotBlank
    private String documentTitle;

    @NotBlank
    private String documentDescription;

    @NotBlank
    private String documentDepartment;

    private Date archivingDate;

}
