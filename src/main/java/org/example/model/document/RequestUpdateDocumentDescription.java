package org.example.model.document;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class RequestUpdateDocumentDescription {

    private Integer id;

    @NotBlank
    private String documentDescription;
}
