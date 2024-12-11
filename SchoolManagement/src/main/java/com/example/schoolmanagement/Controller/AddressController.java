package com.example.schoolmanagement.Controller;

import com.example.schoolmanagement.Api.ApiResponse;
import com.example.schoolmanagement.DTO.AddressDTO;
import com.example.schoolmanagement.Service.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/address")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @GetMapping("/get")
    public ResponseEntity findAllAddresses() {
        return ResponseEntity.status(200).body(addressService.findAllAddress());
    }

    @PostMapping("/add")
    public ResponseEntity addAddress(@RequestBody @Valid AddressDTO addressDTO) {
        addressService.addAddress(addressDTO);
        return ResponseEntity.status(200).body(new ApiResponse("added address"));
    }
    @PutMapping("/update")
    public ResponseEntity updateAddress(@RequestBody @Valid AddressDTO addressDTO) {
        addressService.updateAddress(addressDTO);
        return ResponseEntity.status(200).body(new ApiResponse("updated address"));
    }

}