package com.kenard.unipds.slowapi.controller;

import com.kenard.unipds.slowapi.model.DocAutorizacao;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.SecureRandom;
import java.time.LocalDateTime;

@RestController
@CrossOrigin("*")
public class DocAutorizacaoController {

    @GetMapping("/api/v1/autorizacao/{cliente}")
    public ResponseEntity<DocAutorizacao> autorizar(@PathVariable Long cliente, @RequestParam(name = "servico") Integer servico) {
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        DocAutorizacao doc = new DocAutorizacao();
        doc.setDataHora(LocalDateTime.now());
        doc.setCodigoCliente(cliente);
        doc.setCodigoServico(servico);
        doc.setChaveAutorizacao(generatedKey());
        return ResponseEntity.ok(doc);
    }

    private String generatedKey() {
        StringBuilder str = new StringBuilder();
        SecureRandom random = new SecureRandom();
        for (int i = 0; i < 30; i++) {
            str.append(Integer.toHexString(i).toUpperCase());
        }
        return str.toString();
    }
}
