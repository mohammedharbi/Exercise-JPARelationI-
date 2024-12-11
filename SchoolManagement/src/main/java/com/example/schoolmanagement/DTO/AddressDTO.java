package com.example.schoolmanagement.DTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDTO {

    private Integer teacher_id;

    @NotEmpty(message = "area is empty")
    @Column(unique = false, nullable = false)
    private String area;

    @NotEmpty(message = "street is empty")
    @Column(unique = false, nullable = false)
    private String street;

    @NotNull(message = "Building number is empty")
    @Column(unique = false, nullable = false)
    private Integer buildingNumber;

}
