package com.k3518030.faiz.controller;

import com.k3518030.faiz.dto.PresensiDto;
import com.k3518030.faiz.dto.ProdiDto;
import com.k3518030.faiz.dto.ResultDto;
import com.k3518030.faiz.entity.DbProdi;
import com.k3518030.faiz.service.ProdiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prodi")
public class ProdiController {
    @Autowired
    private ProdiService prodiService;

    @PostMapping("/add-prodi")
    private ResponseEntity<ResultDto<ProdiDto>> addNewProdi(@RequestBody ProdiDto prodiDto){
        ProdiDto prodi = prodiService.putNewProdi(prodiDto);
        ResultDto<ProdiDto> result = new ResultDto<>();
        result.setData(prodi);
        result.setMessage("Prodi Berhasil Ditambahkan");
        return ResponseEntity.ok(result);
    }

    @GetMapping("/showall")
    public ResponseEntity<ResultDto<List<ProdiDto>>> showAllProdi(){
        ResultDto<List<ProdiDto>> result = new ResultDto<>();
        List<ProdiDto> prodiDtoList = prodiService.getAllProdi();
        result.setData(prodiDtoList);
        result.setMessage("Data Prodi berhasil didapatkan");
        return ResponseEntity.ok(result);
    }
}
