package com.example.schoolmanagement.Controller;

import com.example.schoolmanagement.Api.ApiResponse;
import com.example.schoolmanagement.Model.Teacher;
import com.example.schoolmanagement.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping("/get")
    public ResponseEntity getTeacher(){
        return ResponseEntity.status(200).body(teacherService.findAllTeachers());
    }

    @PostMapping("/add")
    public ResponseEntity addTeacher(@RequestBody @Valid Teacher teacher){
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(200).body(new ApiResponse("Teacher Added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateTeacher(@PathVariable Integer id, @RequestBody @Valid Teacher teacher){
        teacherService.updateTeacher(id, teacher);
        return ResponseEntity.status(200).body(new ApiResponse("Teacher Updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable Integer id){
        teacherService.deleteTeacher(id);
        return ResponseEntity.status(200).body(new ApiResponse("Teacher Deleted"));
    }
}