package com.example.schoolmanagement.Service;

import com.example.schoolmanagement.Api.ApiException;
import com.example.schoolmanagement.DTO.AddressDTO;
import com.example.schoolmanagement.Model.Address;
import com.example.schoolmanagement.Model.Teacher;
import com.example.schoolmanagement.Repository.AddressRepository;
import com.example.schoolmanagement.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
    private final TeacherRepository teacherRepository;

    public List<Address> findAllAddress() {
        return addressRepository.findAll();
    }
    public void addAddress(AddressDTO addressDTO) {
        Teacher teacher = teacherRepository.findTeacherById(addressDTO.getTeacher_id());
        if (teacher == null) {throw new ApiException("Teacher Not Found");}

        Address address = new Address(null, addressDTO.getArea(), addressDTO.getStreet(), addressDTO.getBuildingNumber(), teacher);
        addressRepository.save(address);
    }
    public void updateAddress(AddressDTO addressDTO) {
        Address address = addressRepository.findAddressById(addressDTO.getTeacher_id());
        if (address == null) {throw new ApiException("Teacher Not Found");}

        address.setArea(addressDTO.getArea());
        address.setStreet(addressDTO.getStreet());
        address.setBuildingNumber(addressDTO.getBuildingNumber());
        addressRepository.save(address);

    }
}
