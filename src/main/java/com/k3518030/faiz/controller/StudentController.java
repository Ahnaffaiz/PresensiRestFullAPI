package com.k3518030.faiz.controller;

import com.k3518030.faiz.dto.*;
import com.k3518030.faiz.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/register")
    public ResponseEntity<ResultDto<StudentDto>> registerNewStudent(@RequestBody StudentDto studentDto){
        StudentDto student = studentService.registerNewStudent(studentDto);
        ResultDto<StudentDto> result = new ResultDto<>();
        result.setData(student);
        result.setMessage("Data berhasil ditambahkan");
        return ResponseEntity.ok(result);
    }

    @PostMapping("/login")
    public ResponseEntity<ResultDto<StudentDto>> loginStudent(@RequestBody LoginDto loginDto){
        ResultDto<StudentDto> resultDto = new ResultDto<>();
        StudentDto result = studentService.loginStudent(loginDto);
        resultDto.setData(result);
        resultDto.setMessage("Data berhasil ditemukan");
        return ResponseEntity.ok(resultDto);

    }

    @PostMapping("/address/{idStudent}")
    public ResponseEntity<ResultDto<List<StudentAddressDto>>> addNewAddress(@RequestBody StudentAddressDto studentAddressDto, @PathVariable("idStudent") Integer idStudent){
        List<StudentAddressDto> addressDtos = studentService.putNewAddress(idStudent, studentAddressDto);
        ResultDto<List<StudentAddressDto>> result = new ResultDto<>();
        result.setData(addressDtos);
        result.setMessage("Alamat Berhasil Ditambahkan");
        return ResponseEntity.ok(result);
    }

    @GetMapping("/address/{idStudent}")
    public ResponseEntity<ResultDto<List<StudentAddressDto>>> getStudentAddress(@PathVariable("idStudent") Integer idStudent){
        List<StudentAddressDto> addressDtos = studentService.findStudentAddress(idStudent);
        ResultDto<List<StudentAddressDto>> result = new ResultDto<>();
        result.setData(addressDtos);
        result.setMessage("Data Berhasil ditemukan");
        return ResponseEntity.ok(result);
    }

    @PostMapping("/mail/{idStudent}")
    public ResponseEntity<ResultDto<List<StudentMailDto>>> addNewMail(@RequestBody StudentMailDto studentMailDto, @PathVariable("idStudent") Integer idStudent){
        List<StudentMailDto> mailDtos = studentService.putNewEmail(idStudent, studentMailDto);
        ResultDto<List<StudentMailDto>> result = new ResultDto<>();
        result.setData(mailDtos);
        result.setMessage("Data Berhasil Ditambakan");
        return ResponseEntity.ok(result);
    }

    @GetMapping("/mail/{idStudent}")
    private ResponseEntity<ResultDto<List<StudentMailDto>>> getStudentMail(@PathVariable("idStudent") Integer idStudent){
        List<StudentMailDto> mailDtos = studentService.findStudentMails(idStudent);
        ResultDto<List<StudentMailDto>> result = new ResultDto<>();
        result.setData(mailDtos);
        result.setMessage("data Berhasil didapat");
        return ResponseEntity.ok(result);
    }


}
