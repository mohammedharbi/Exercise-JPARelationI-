package com.example.schoolmanagement.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "name is empty")
    @Size(min = 4, message = "name must be at least 4 characters")
    @Column(unique = false, nullable = false)
    private String name;

    @NotNull(message = "age is null")
    @Min(value = 18, message = "age must be greater than 18")
    @Column(unique = false , nullable = false)
    private Integer age;

    @NotEmpty(message = "email is empty")
    @Email
    @Column(unique = true, nullable = false)
    private String email;

    @NotNull(message = "salary is null")
    @Column(unique = false, nullable = false)
    private Double salary;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Address address;
}