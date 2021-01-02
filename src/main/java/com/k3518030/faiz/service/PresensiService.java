package com.k3518030.faiz.service;

import com.k3518030.faiz.dto.PresensiDto;
import com.k3518030.faiz.dto.ResultDto;
import com.k3518030.faiz.entity.DbPresensi;
import com.k3518030.faiz.entity.DbStudent;
import com.k3518030.faiz.repository.PresensiRepository;
import com.k3518030.faiz.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PresensiService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private PresensiRepository presensiRepository;

    public PresensiDto newPresensi(Integer idStudent){
        Optional<DbStudent> optionalDbStudent = studentRepository.findById(idStudent);
            DbPresensi presensi = new DbPresensi();
            PresensiDto result = new PresensiDto();
            if (optionalDbStudent.isPresent()){
                DbStudent dbStudent = optionalDbStudent.get();
                presensi.setIdStudent(dbStudent);
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                presensi.setDatePresensi(timestamp);
                DbPresensi dbPresensi = presensiRepository.save(presensi);
                result.setId(dbPresensi.getId());
                result.setIdStudent(dbStudent.getId());
                result.setDatePresensi(dbPresensi.getDatePresensi());
            }
            return result;
    }

    public List<PresensiDto> getAllPresensi(){
        List<DbPresensi> presensis = presensiRepository.findAll();
        List<PresensiDto> presensiDtoList = new ArrayList<>();
        for (int i = 0; i < presensis.size(); i++) {
            PresensiDto presensiDto = new PresensiDto();
            presensiDto.setId(presensis.get(i).getId());
            presensiDto.setIdStudent(presensis.get(i).getIdStudent().getId());
            presensiDto.setDatePresensi(presensis.get(i).getDatePresensi());
            presensiDtoList.add(presensiDto);
        }
        return presensiDtoList;
    }

}
