package com.example.schoolmanagement.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address {

    @Id
    private Integer id;

    @NotEmpty(message = "area is empty")
    @Column(unique = false, nullable = false)
    private String area;

    @NotEmpty(message = "street is empty")
    @Column(unique = false, nullable = false)
    private String street;

    @NotNull(message = "Building number is empty")
    @Column(unique = false, nullable = false)
    private Integer buildingNumber;

    @OneToOne
    @MapsId
    @JsonIgnore
    private Teacher teacher;
}
