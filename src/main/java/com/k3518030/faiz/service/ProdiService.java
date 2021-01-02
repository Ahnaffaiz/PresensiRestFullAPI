package com.k3518030.faiz.service;

import com.k3518030.faiz.dto.PresensiDto;
import com.k3518030.faiz.dto.ProdiDto;
import com.k3518030.faiz.entity.DbPresensi;
import com.k3518030.faiz.entity.DbProdi;
import com.k3518030.faiz.repository.ProdiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdiService {
    @Autowired
    private ProdiRepository prodiRepository;

    public ProdiDto putNewProdi(ProdiDto prodiDto){
        DbProdi prodi = new DbProdi();
        prodi.setProdi(prodiDto.getProdi());
        ProdiDto prodiDto1 = new ProdiDto();
        DbProdi prodi1 = prodiRepository.save(prodi);
        prodiDto1.setProdi(prodi1.getProdi());
        prodiDto1.setId(prodi1.getId());
        return prodiDto1;

    }

    public List<ProdiDto> getAllProdi(){
        List<DbProdi> prodiList = prodiRepository.findAll();
        List<ProdiDto> prodiDtoList = new ArrayList<>();
        for (int i = 0; i < prodiList.size(); i++) {
            ProdiDto prodiDto = new ProdiDto();
            prodiDto.setId(prodiList.get(i).getId());
            prodiDto.setProdi(prodiList.get(i).getProdi());
            prodiDtoList.add(prodiDto);
        }
        return prodiDtoList;
    }
}
