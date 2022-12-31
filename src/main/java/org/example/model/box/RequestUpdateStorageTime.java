package org.example.model.box;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class RequestUpdateStorageTime {
    private Integer id;

    @NotNull
    private Integer storageTime;

}
