package org.example.model.document;

import lombok.Data;

import java.util.Date;


@Data
public class DocumentResponse {

    private Integer id;
    private String documentTitle;
    private String documentDescription;
    private String departmentName;
    private String clientBoxCode;
    private Date archivingDate;
}
