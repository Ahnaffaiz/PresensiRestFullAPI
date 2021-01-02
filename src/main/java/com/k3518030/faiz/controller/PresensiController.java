package com.k3518030.faiz.controller;

import com.k3518030.faiz.dto.PresensiDto;
import com.k3518030.faiz.dto.ResultDto;
import com.k3518030.faiz.service.PresensiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/presensi")
public class PresensiController {
    @Autowired
    private PresensiService presensiService;

    @GetMapping("/{idStudent}")
    public ResponseEntity<ResultDto<PresensiDto>> newPresensi(@PathVariable("idStudent") Integer idStudent){
        PresensiDto presensi = presensiService.newPresensi(idStudent);
        ResultDto<PresensiDto> result = new ResultDto<>();
        result.setData(presensi);
        result.setMessage("Presensi Berhasil Dilakukan");
        return ResponseEntity.ok(result);
    }

    @GetMapping("/showall")
    public ResponseEntity<ResultDto<List<PresensiDto>>> showAllPresensi(){
        ResultDto<List<PresensiDto>> result = new ResultDto<>();
        List<PresensiDto> presensiDtoList = presensiService.getAllPresensi();
        result.setData(presensiDtoList);
        result.setMessage("Semua Data Presensi Berhasil ditampilkan");
        return ResponseEntity.ok(result);
    }

}
