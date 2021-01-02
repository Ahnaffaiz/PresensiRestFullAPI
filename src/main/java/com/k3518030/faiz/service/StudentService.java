package com.k3518030.faiz.service;

import com.k3518030.faiz.dto.LoginDto;
import com.k3518030.faiz.dto.StudentAddressDto;
import com.k3518030.faiz.dto.StudentDto;
import com.k3518030.faiz.dto.StudentMailDto;
import com.k3518030.faiz.entity.DbProdi;
import com.k3518030.faiz.entity.DbStudent;
import com.k3518030.faiz.entity.DbStudentAddres;
import com.k3518030.faiz.entity.DbStudentMail;
import com.k3518030.faiz.repository.ProdiRepository;
import com.k3518030.faiz.repository.StudentAddressRepository;
import com.k3518030.faiz.repository.StudentMailRepository;
import com.k3518030.faiz.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ProdiRepository prodiRepository;
    @Autowired
    private StudentAddressRepository studentAddressRepository;
    @Autowired
    private StudentMailRepository studentMailRepository;

    public StudentDto registerNewStudent(StudentDto studentDto){
        Optional<DbProdi> optionalDbProdi = prodiRepository.findById(studentDto.getIdProdi());
        DbStudent student = new DbStudent();
        StudentDto result = new StudentDto();
        if (optionalDbProdi.isPresent()){
            DbProdi prodi = optionalDbProdi.get();
            student.setIdProdi(prodi);
            student.setName(studentDto.getName());
            student.setPassword(studentDto.getPassword());
            student.setGender(studentDto.getGender());
            DbStudent dbStudent = studentRepository.save(student);
            result.setId(dbStudent.getId());
            result.setIdProdi(prodi.getId());
            result.setName(dbStudent.getName());
            result.setGender(dbStudent.getGender());
            result.setPassword(dbStudent.getPassword());
        }
        return result;
    }

    public StudentDto loginStudent(LoginDto loginDto){
        Optional<DbStudent> optionalDbStudent = studentRepository.findByNameAndPassword(loginDto.getName(), loginDto.getPassword());
        StudentDto studentDto = new StudentDto();
        DbStudent student = optionalDbStudent.get();
        if (optionalDbStudent.isPresent()){
            studentDto.setId(student.getId());
            studentDto.setIdProdi(student.getIdProdi().getId());
            studentDto.setName(student.getName());
            studentDto.setGender(student.getGender());
            studentDto.setPassword(student.getPassword());
        }
        return studentDto;
    }

    public List<StudentAddressDto> putNewAddress(Integer idStudent, StudentAddressDto studentAddressDto){
        Optional<DbStudent> optionalDbStudent = studentRepository.findById(idStudent);
        if (optionalDbStudent.isPresent()){
            DbStudent student = optionalDbStudent.get();
            DbStudentAddres addres = new DbStudentAddres();
            addres.setIdStudent(student);
            addres.setAddress(studentAddressDto.getAddress());
            studentAddressRepository.save(addres);
        }
        return findStudentAddress(idStudent);
    }

    public List<StudentAddressDto> findStudentAddress(Integer idStudent){
        List<StudentAddressDto> addressDtos = new ArrayList<>();
        Optional<DbStudent> studentOptional = studentRepository.findById(idStudent);
        if (studentOptional.isPresent()){
            DbStudent dbStudent = studentOptional.get();
            List<DbStudentAddres> addressDtoList = dbStudent.getDbStudentAddresList();
            for (int i = 0; i < addressDtoList.size(); i++) {
                StudentAddressDto addressDto = new StudentAddressDto(addressDtoList.get(i).getId(), addressDtoList.get(i).getAddress());
                addressDtos.add(addressDto);
            }
        }
        return addressDtos;
    }

    public List<StudentMailDto> putNewEmail(Integer idStudent, StudentMailDto studentMailDto){
        Optional<DbStudent> optionalDbStudent = studentRepository.findById(idStudent);
        if (optionalDbStudent.isPresent()){
            DbStudent student = optionalDbStudent.get();
            DbStudentMail mail = new DbStudentMail();
            mail.setIdStudent(student);
            mail.setEmail(studentMailDto.getEmail());
            studentMailRepository.save(mail);
        }
        return findStudentMails(idStudent);
    }

    public List<StudentMailDto> findStudentMails(Integer idStudent){
        List<StudentMailDto> studentMailDtos = new ArrayList<>();
        Optional<DbStudent> optionalDbStudent = studentRepository.findById(idStudent);
        if (optionalDbStudent.isPresent()){
            DbStudent dbStudent = optionalDbStudent.get();
            List<DbStudentMail> dbStudentMails = dbStudent.getDbStudentMailList();
            for (int i = 0; i < dbStudentMails.size(); i++) {
                StudentMailDto studentMailDto = new StudentMailDto(dbStudentMails.get(i).getId(), dbStudentMails.get(i).getEmail());
                studentMailDtos.add(studentMailDto);
            }
        }
        return studentMailDtos;

    }

}
