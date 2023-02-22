package org.example.Controller;

import org.example.Request.CepRequest;
import org.example.Response.CepResponse;
import org.example.Response.ResponseExceptionHandler;
import org.example.Service.CepRestTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/consulta-endereco")
public class CepRestTemplateController {
    @Autowired
    private CepRestTemplateService cepRestTemplateService;
    @PostMapping
    public ResponseEntity<Object> pesquisar(@RequestBody CepRequest cepRequest) {
        try {
            CepResponse cepResponse = cepRestTemplateService.pesquisar(cepRequest).getBody();
            return ResponseEntity.ok().body(cepResponse);

        } catch (Exception e) {
            return ResponseExceptionHandler.errorResponseNotFound("Não foi possivel encontrar o cep indicado:" + cepRequest.getCep(), HttpStatus.NOT_FOUND);
        }
    }
}
