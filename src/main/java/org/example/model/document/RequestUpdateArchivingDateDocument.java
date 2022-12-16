package org.example.model.document;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.sql.Date;

@Data
public class RequestUpdateArchivingDateDocument {

    private Integer id;

    @NotNull
    @Past
    private Date archivingDate;
}
