package com.bsoftware.pagamentoeletronico.resource;

import com.bsoftware.pagamentoeletronico.service.ModeloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RestController
@RequestMapping("/modelo")
public class ModeloResource {

    @Autowired
    private ModeloService modeloService;

    @GetMapping
    public ResponseEntity<byte[]> relatorio(){
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_PDF_VALUE).body(modeloService.lerparaDoc());
    }

    @PostMapping
    public void escreverdeDoc(@RequestBody MultipartFile file){
        modeloService.escreverparaDoc(file);
    }
}
