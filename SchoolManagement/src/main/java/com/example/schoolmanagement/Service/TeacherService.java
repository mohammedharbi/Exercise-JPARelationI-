package com.example.schoolmanagement.Service;

import com.example.schoolmanagement.Api.ApiException;
import com.example.schoolmanagement.Model.Address;
import com.example.schoolmanagement.Model.Teacher;
import com.example.schoolmanagement.Repository.AddressRepository;
import com.example.schoolmanagement.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;
    private final AddressRepository addressRepository;

    public List<Teacher> findAllTeachers() {
        return teacherRepository.findAll();
    }
    public void addTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
    }
    public void updateTeacher(Integer id,Teacher teacher) {
        Teacher teacher1 = teacherRepository.findTeacherById(id);
        if (teacher1 != null) {
            teacher1.setName(teacher.getName());
            teacherRepository.save(teacher1);
        }else throw new ApiException("Teach not found");
    }
    public void deleteTeacher(Integer id) {
        Teacher teacher1 = teacherRepository.findTeacherById(id);
        if (teacher1 == null){throw new ApiException("Teacher not found");}

        Address address = addressRepository.findAddressById(id);
        if (address == null){throw new ApiException("Address not found");}

        teacher1.setAddress(null);

        addressRepository.delete(address);
        teacherRepository.delete(teacher1);
    }


}
