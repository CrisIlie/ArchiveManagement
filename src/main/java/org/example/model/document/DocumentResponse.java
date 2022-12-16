package org.example.model.document;

import lombok.Data;

import java.sql.Date;

@Data
public class DocumentResponse {

    private Integer id;
    private String documentTitle;
    private String documentDescription;
    private String departmentName;
    private Date archivingDate;
}
