package br.unipar.programacaointernet.clinica.controller;

import br.unipar.programacaointernet.clinica.model.Atendimento;
import br.unipar.programacaointernet.clinica.service.AtendimentoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AtendimentoApiController {
    private final AtendimentoService atendimentoService;

    public AtendimentoApiController(AtendimentoService atendimentoService) {
        this.atendimentoService = atendimentoService;
    }

    @GetMapping(path = "/api/atendimentos")
    @Operation(summary = "Obter todos os atendimentos", description = "Retorna uma lista")
    public ResponseEntity<List<Atendimento>> getAll() {
        return ResponseEntity.ok(this.atendimentoService.getAll());
    }

    @PostMapping(path = "/api/atendimentos")
    @Operation(summary = "Salvar atendimento", description = "Salva um novo atendimento")
    public ResponseEntity<Atendimento> save(@RequestBody Atendimento atendimento) {
        return ResponseEntity.ok(this.atendimentoService.save(atendimento));
    }
}
